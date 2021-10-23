package com.strawhat.catalogtown.service.impl;

import com.strawhat.catalogtown.constants.ErrorCode;
import com.strawhat.catalogtown.exception.CatalogTownException;
import com.strawhat.catalogtown.model.entity.MerchantEntity;
import com.strawhat.catalogtown.model.request.CreateMerchantRequest;
import com.strawhat.catalogtown.model.response.CreateMerchantResponse;
import com.strawhat.catalogtown.repository.MerchantRepository;
import com.strawhat.catalogtown.service.MerchantService;
import lombok.extern.slf4j.Slf4j;
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

  @Override
  public CreateMerchantResponse createMerchant(final CreateMerchantRequest request)
      throws CatalogTownException {
    log.debug("Received Create Merchant Request: {}", request);

    if(isExistingMerchant(request.getName())) {
      log.error("Merchant name already exists: {}", request.getName());
      throw new CatalogTownException(ErrorCode.MERCHANT_EXISTS);
    }

    MerchantEntity merchantEntity = this.merchantRepository.save(convertToEntity(request));

    log.debug("Created New Merchant : {}", merchantEntity);
    return convertToMerchantResponse(merchantEntity);
  }

  @Override
  public boolean isExistingMerchant(final String name) {
    log.debug("Checking if merchant name exists: {}", name);
    return this.merchantRepository.findByName(name).isPresent();
  }

  private CreateMerchantResponse convertToMerchantResponse(final MerchantEntity merchantEntity) {
    return CreateMerchantResponse.builder()
        .name(merchantEntity.getName())
        .code(merchantEntity.getCode())
        .description(merchantEntity.getDescription())
        .addressLine1(merchantEntity.getAddressLine1())
        .addressLine2(merchantEntity.getAddressLine2())
        .pinCode(merchantEntity.getPinCode())
        .city(merchantEntity.getCity())
        .country(merchantEntity.getCountry())
        .createdBy(merchantEntity.getCreatedBy())
        .createdDate(merchantEntity.getCreateDate().toString())
        .build();
  }

  private MerchantEntity convertToEntity(final CreateMerchantRequest request) {
    return MerchantEntity.builder()
        .name(request.getName())
        .code(generateMerchantCode(request.getName()))
        .description(request.getDescription())
        .addressLine1(request.getAddressLine1())
        .addressLine2(request.getAddressLine2())
        .pinCode(request.getPinCode())
        .city(request.getCity())
        .country(request.getCountry())
        .build();
  }

  private String generateMerchantCode(String name) {
    String merchantCode;
    name = name.toUpperCase() + MERCHANT_CODE_APPEND_TEXT;
    while(this.merchantRepository.findByCode(merchantCode = new StringBuilder(name.substring(0, 4)).append(DASH)
        .append(new Random().nextInt(8999) + 1000).toString()).isPresent());
    return merchantCode;
  }
}
