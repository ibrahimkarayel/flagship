package com.flagship.model.parser;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ParseEntryRule {

  @Id
  @GeneratedValue
  private Long id;

  @OneToOne(cascade = CascadeType.ALL)
  private PhoneSpec phoneSpec;

}
