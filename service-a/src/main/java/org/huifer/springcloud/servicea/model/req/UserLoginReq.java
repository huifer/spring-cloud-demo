package org.huifer.springcloud.servicea.model.req;

import lombok.Data;

@Data
public class UserLoginReq {

  private String loginType;
  private Integer userId;
}
