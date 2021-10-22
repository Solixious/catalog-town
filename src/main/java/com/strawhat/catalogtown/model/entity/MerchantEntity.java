package com.strawhat.catalogtown.model.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Builder
@Data
@Entity(name = MerchantEntity.TABLE_NAME)
public class MerchantEntity {

  public static final String TABLE_NAME = "merchant";

  @Id
  private Long id;

  @Column(unique = true)
  private String code;

  @Column(unique = true)
  private String name;

  private String description;

  private String addressLine1;

  private String addressLine2;

  private String city;

  private String pinCode;

  private String country;

  @CreatedBy
  private String createdBy;

  @CreatedDate
  private String createdDate;
}
