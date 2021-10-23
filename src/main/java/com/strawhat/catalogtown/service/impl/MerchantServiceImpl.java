package com.strawhat.catalogtown.service.impl;

import com.strawhat.catalogtown.constants.ErrorCode;
import com.strawhat.catalogtown.exception.CatalogTownException;
import com.strawhat.catalogtown.model.entity.MerchantEntity;
import com.strawhat.catalogtown.model.request.CreateMerchantRequest;
import com.strawhat.catalogtown.model.Merchant;
import com.strawhat.catalogtown.repository.MerchantRepository;
import com.strawhat.catalogtown.service.MerchantService;
import lombok.extern.slf4j.Slf4j;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@Slf4j
public class MerchantServiceImpl implements MerchantService {

  private static final String DASH = "-";
  public static final String MERCHANT_CODE_APPEND_TEXT = "XXXX";

  @Autowired
  private MerchantRepository merchantRepository;

  @Autowired
  private Mapper mapper;

  @Override
  public Merchant createMerchant(final CreateMerchantRequest request)
      throws CatalogTownException {
    log.debug("Received Create Merchant Request: {}", request);

    validateCreateMerchantRequest(request);

    MerchantEntity merchantEntity = this.merchantRepository.save(convertToEntity(request));

    log.debug("Created New Merchant : {}", merchantEntity);
    return convertToMerchantResponse(merchantEntity);
  }

  @Override
  public boolean isExistingMerchant(final String name) throws CatalogTownException {
    log.debug("Checking if merchant name exists: {}", name);

    validateMerchantNameLength(name);

    return this.merchantRepository.findByName(name).isPresent();
  }

  private Merchant convertToMerchantResponse(final MerchantEntity merchantEntity) {
    return mapper.map(merchantEntity, Merchant.class);
  }

  private MerchantEntity convertToEntity(final CreateMerchantRequest request) {
    MerchantEntity entity = mapper.map(request, MerchantEntity.class);
    entity.setCode(generateMerchantCode(request.getName()));
    return entity;
  }

  private String generateMerchantCode(String name) {
    String merchantCode;
    name = name.toUpperCase() + MERCHANT_CODE_APPEND_TEXT;
    while(this.merchantRepository.findByCode(merchantCode = new StringBuilder(name.substring(0, 4)).append(DASH)
        .append(new Random().nextInt(8999) + 1000).toString()).isPresent());
    return merchantCode;
  }

  private void validateCreateMerchantRequest(CreateMerchantRequest request)
      throws CatalogTownException {
    if(request == null) {
      log.error("Request body is missing.");
      throw new CatalogTownException(ErrorCode.REQUEST_BODY_MISSING);
    }

    if(isExistingMerchant(request.getName())) {
      log.error("Merchant name already exists: {}", request.getName());
      throw new CatalogTownException(ErrorCode.MERCHANT_EXISTS);
    }
  }

  private void validateMerchantNameLength(String name)
      throws CatalogTownException {
    if(name == null || name.equals("") || name.length() < 3) {
      log.error("Merchant name {} length should be more than 3.", name);
      throw new CatalogTownException(ErrorCode.MERCHANT_NAME_LENGTH);
    }
  }
}
