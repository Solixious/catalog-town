package com.strawhat.catalogtown.model.request;

import lombok.Data;

@Data
public class UpdateMerchantRequest {

  private String code;
  private String name;
  private String description;
  private String addressLine1;
  private String addressLine2;
  private String city;
  private String pinCode;
  private String country;
}
