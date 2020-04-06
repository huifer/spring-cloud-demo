package org.huifer.springcloud.servicea.event.login;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 登录事件
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginEvent {

  /**
   * 登录信息
   */
  private String loginType;
  private Integer userId;


}
