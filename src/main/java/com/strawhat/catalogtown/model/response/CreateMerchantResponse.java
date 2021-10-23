package com.strawhat.catalogtown.model.response;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class CreateMerchantResponse extends BaseResponse {

  private String name;
  private String code;
  private String description;
  private String addressLine1;
  private String addressLine2;
  private String city;
  private String pinCode;
  private String country;
  private String createdBy;
  private String createdDate;
}
