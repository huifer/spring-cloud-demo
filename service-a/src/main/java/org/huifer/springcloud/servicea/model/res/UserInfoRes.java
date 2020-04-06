package org.huifer.springcloud.servicea.model.res;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoRes {

  private String name;
  private Integer age;

}
