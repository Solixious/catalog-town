package com.strawhat.catalogtown.model.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@SuperBuilder
public class BaseResponse {

  private String errorCode;
  private String errorDescription;
}
