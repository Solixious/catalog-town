package com.strawhat.catalogtown.service;

import com.strawhat.catalogtown.exception.CatalogTownException;
import com.strawhat.catalogtown.model.request.CreateMerchantRequest;
import com.strawhat.catalogtown.model.Merchant;
import com.strawhat.catalogtown.model.request.UpdateMerchantRequest;

public interface MerchantService {

  /**
   * @param request Merchant Creation Request
   * @return Merchant Created Response
   * @throws CatalogTownException merchant is duplicated or necessary parameters are missing
   */
  Merchant createMerchant(CreateMerchantRequest request) throws CatalogTownException;

  /**
   * @param name Merchant name
   * @return true if the merchant exists
   * @throws CatalogTownException name length is too less
   */
  boolean isExistingMerchant(String name) throws CatalogTownException;

  /**
   * @param updateMerchantRequest Merchant Update Request
   * @return updated merchant
   * @throws CatalogTownException merchant does not exist
   */
  Merchant updateMerchant(UpdateMerchantRequest updateMerchantRequest) throws CatalogTownException;

  /**
   * @param code Merchant Code
   * @return merchant corresponding to the given code
   * @throws CatalogTownException merchant does not exist
   */
  Merchant getMerchant(String code) throws CatalogTownException;
}
