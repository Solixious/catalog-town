package com.strawhat.catalogtown.service;

import com.strawhat.catalogtown.exception.CatalogTownException;
import com.strawhat.catalogtown.model.request.CreateMerchantRequest;
import com.strawhat.catalogtown.model.response.CreateMerchantResponse;

public interface MerchantService {

  /**
   * @param request Merchant Creation Request
   * @return Merchant Created Response
   * @throws CatalogTownException merchant is duplicated or necessary parameters are missing
   */
  CreateMerchantResponse createMerchant(CreateMerchantRequest request) throws CatalogTownException;

  /**
   * @param name Merchant name
   * @return true if the merchant exists
   */
  boolean isExistingMerchant(String name);
}
