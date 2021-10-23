package com.strawhat.catalogtown.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = false)
@SuperBuilder
@Data
@Entity
@Table(name = MerchantEntity.TABLE_NAME)
public class MerchantEntity extends BaseEntity {

  public static final String TABLE_NAME = "merchant";

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
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
}
