package com.strawhat.catalogtown.constants;

public enum ErrorCode {

  MERCHANT_EXISTS("The merchant being created already exists.");

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
