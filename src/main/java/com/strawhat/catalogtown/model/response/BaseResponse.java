package com.strawhat.catalogtown.model.response;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class BaseResponse {

  private String errorCode;
  private String errorDescription;
}
