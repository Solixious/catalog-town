package com.strawhat.catalogtown.controller;

import com.strawhat.catalogtown.exception.CatalogTownException;
import com.strawhat.catalogtown.model.request.CreateMerchantRequest;
import com.strawhat.catalogtown.model.request.UpdateMerchantRequest;
import com.strawhat.catalogtown.model.response.CheckMerchantResponse;
import com.strawhat.catalogtown.model.Merchant;
import com.strawhat.catalogtown.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.strawhat.catalogtown.constants.UrlConstants.*;

@RestController
@RequestMapping(BASE_PATH + MERCHANT)
public class MerchantController {

  @Autowired
  private MerchantService merchantService;

  @PostMapping(CREATE)
  public Merchant create(@RequestBody final CreateMerchantRequest createMerchantRequest) {
    try {
      return merchantService.createMerchant(createMerchantRequest);
    } catch (CatalogTownException e) {
      return Merchant.builder()
          .errorCode(e.getErrorCode())
          .errorDescription(e.getErrorDescription())
          .build();
    }
  }

  @GetMapping(CHECK)
  public CheckMerchantResponse check(@PathVariable final String name) {
    try {
      return CheckMerchantResponse.builder().name(name).exists(merchantService.isExistingMerchant(name)).build();
    } catch (CatalogTownException e) {
      return CheckMerchantResponse.builder()
          .errorCode(e.getErrorCode())
          .errorDescription(e.getErrorDescription())
          .build();
    }
  }

  @PostMapping(UPDATE)
  public Merchant update(@RequestBody final UpdateMerchantRequest updateMerchantRequest) {
    try {
      return merchantService.updateMerchant(updateMerchantRequest);
    } catch (CatalogTownException e) {
      return Merchant.builder()
          .errorCode(e.getErrorCode())
          .errorDescription(e.getErrorDescription())
          .build();
    }
  }

  @GetMapping(GET)
  public Merchant get(@PathVariable final String code) {
    try {
      return merchantService.getMerchant(code);
    } catch (CatalogTownException e) {
      return Merchant.builder()
          .errorCode(e.getErrorCode())
          .errorDescription(e.getErrorDescription())
          .build();
    }
  }

  @PostMapping(DEACTIVATE)
  public Merchant deactivate(@PathVariable final String code) {
    try {
      return merchantService.deactivate(code);
    } catch (CatalogTownException e) {
      return Merchant.builder()
          .errorCode(e.getErrorCode())
          .errorDescription(e.getErrorDescription())
          .build();
    }
  }

  @PostMapping(ACTIVATE)
  public Merchant activate(@PathVariable final String code) {
    try {
      return merchantService.activate(code);
    } catch (CatalogTownException e) {
      return Merchant.builder()
          .errorCode(e.getErrorCode())
          .errorDescription(e.getErrorDescription())
          .build();
    }
  }
}
