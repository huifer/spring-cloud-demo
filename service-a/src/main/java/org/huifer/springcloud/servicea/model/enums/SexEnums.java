package org.huifer.springcloud.servicea.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SexEnums {
  MAN(0, "MAN"),
  WOMAN(1, "WOMAN"),
  ;
  public int code;
  private String name;
}
