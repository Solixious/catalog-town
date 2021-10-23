package com.strawhat.catalogtown.service.impl;

import com.strawhat.catalogtown.exception.CatalogTownException;
import com.strawhat.catalogtown.model.entity.MerchantEntity;
import com.strawhat.catalogtown.model.request.CreateMerchantRequest;
import com.strawhat.catalogtown.model.response.CreateMerchantResponse;
import com.strawhat.catalogtown.repository.MerchantRepository;
import com.strawhat.catalogtown.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class MerchantServiceImpl implements MerchantService {

  private static final String DASH = "-";

  @Autowired
  private MerchantRepository merchantRepository;

  @Override
  public CreateMerchantResponse createMerchant(CreateMerchantRequest request)
      throws CatalogTownException {
    MerchantEntity merchantEntity = merchantRepository.save(convertToEntity(request));
    return convertToMerchantResponse(merchantEntity);
  }

  private CreateMerchantResponse convertToMerchantResponse(MerchantEntity merchantEntity) {
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

  private MerchantEntity convertToEntity(CreateMerchantRequest request) {
    return MerchantEntity.builder()
        .name(request.getName())
        .code(generateMerchantCode(request.getName()))
        .description(request.getDescription())
        .addressLine1(request.getAddressLine1())
        .addressLine2(request.getAddressLine2())
        .pinCode(request.getPinCode())
        .city(request.getCity())
        .country("IN")
        .build();
  }

  private String generateMerchantCode(String name) {
    return new StringBuilder(name.substring(0, name.length() < 4 ? name.length() : 4)).append(DASH)
        .append(new Random().nextInt(89) + 10).toString();
  }
}
