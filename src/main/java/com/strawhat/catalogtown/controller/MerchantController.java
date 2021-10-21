package com.strawhat.catalogtown.controller;

import com.strawhat.catalogtown.model.request.CreateMerchantRequest;
import com.strawhat.catalogtown.model.response.CreateMerchantResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.strawhat.catalogtown.constants.UrlConstants.*;

@RestController
@RequestMapping(BASE_PATH + MERCHANT)
public class MerchantController {

  @PostMapping(CREATE)
  public CreateMerchantResponse create(final CreateMerchantRequest createMerchantRequest) {
    return new CreateMerchantResponse();
  }
}
