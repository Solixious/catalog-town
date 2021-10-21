package com.strawhat.catalogtown.model.request;

import lombok.Data;

@Data
public class CreateMerchantRequest {
  String name;
  String description;
  String addressLine1;
  String addressLine2;
  String city;
  String pinCode;
}
