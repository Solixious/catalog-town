package com.strawhat.catalogtown.model.response;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class CheckMerchantResponse extends BaseResponse {

  private String name;
  private Boolean exists;
}
