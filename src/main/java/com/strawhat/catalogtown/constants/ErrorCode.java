package com.strawhat.catalogtown.constants;

public enum ErrorCode {

  MERCHANT_EXISTS("The merchant being created already exists."),
  MERCHANT_NAME_LENGTH("Merchant name's length should be more than 3");

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
