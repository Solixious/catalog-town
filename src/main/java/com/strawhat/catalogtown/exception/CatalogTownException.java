package com.strawhat.catalogtown.exception;

import com.strawhat.catalogtown.constants.ErrorCode;
import lombok.Data;

@Data
public class CatalogTownException extends Exception {

  private ErrorCode errorCode;

  public CatalogTownException(final ErrorCode errorCode) {
    this.errorCode = errorCode;
  }

  public String getErrorCode() {
    return errorCode.getErrorCode();
  }

  public String getErrorDescription() {
    return errorCode.getErrorDescription();
  }
}
