package org.huifer.springcloud.servicea.event.login.impl;

import org.huifer.springcloud.servicea.event.login.LoginEvent;
import org.huifer.springcloud.servicea.event.login.LoginEventListener;
import org.springframework.stereotype.Service;

/**
 * QQ 登陆事件
 */
@Service("qqLoginEventListener")
public class QqLoginEventListenerImpl implements LoginEventListener {

  /**
   * 登陆之后
   *
   * @param loginEvent
   */
  @Override
  public void afterLogin(LoginEvent loginEvent) {
    System.out.println("qq 登陆");
  }
}
