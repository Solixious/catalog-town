package com.strawhat.catalogtown.model;

import com.strawhat.catalogtown.model.response.BaseResponse;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@SuperBuilder
public class Merchant extends BaseResponse {

  private String name;
  private String code;
  private String description;
  private String addressLine1;
  private String addressLine2;
  private String city;
  private String pinCode;
  private String country;
  private String createdBy;
  private String createDate;
  private String updatedBy;
  private String updateDate;
}
