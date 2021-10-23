package com.strawhat.catalogtown.controller;

import com.strawhat.catalogtown.exception.CatalogTownException;
import com.strawhat.catalogtown.model.request.CreateMerchantRequest;
import com.strawhat.catalogtown.model.response.CreateMerchantResponse;
import com.strawhat.catalogtown.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.strawhat.catalogtown.constants.UrlConstants.*;

@RestController
@RequestMapping(BASE_PATH + MERCHANT)
public class MerchantController {

  @Autowired
  private MerchantService merchantService;

  @PostMapping(CREATE)
  public CreateMerchantResponse create(@RequestBody final CreateMerchantRequest createMerchantRequest) {
    try {
      return merchantService.createMerchant(createMerchantRequest);
    } catch (CatalogTownException e) {
      return CreateMerchantResponse.builder()
          .errorCode(e.getErrorCode())
          .errorDescription(e.getErrorDescription())
          .build();
    }
  }
}
