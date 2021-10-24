package com.strawhat.catalogtown.constants;

public enum ErrorCode {

  MERCHANT_EXISTS("The merchant being created already exists."),
  MERCHANT_NOT_FOUND("The merchant being update does not exists."),
  MERCHANT_CODE_NOT_FOUND("Merchant code is required for updating a merchant."),
  MERCHANT_NAME_LENGTH("Merchant name's length should be more than 3."),
  REQUEST_BODY_MISSING("The request body was missing.");

  private String errorDescription;

  ErrorCode(String errorDescription) {
    this.errorDescription = errorDescription;
  }

  public String getErrorDescription() {
    return this.errorDescription;
  }

  public String getErrorCode() {
    return this.name();
  }
}
