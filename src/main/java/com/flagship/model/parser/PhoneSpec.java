package com.flagship.model.parser;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class PhoneSpec {
  @Id
  @GeneratedValue
  private Long id;
  private String technology;
  private String G2;
  private String G3;
  private String G4;
  private String G5;
  private String speed;
}
