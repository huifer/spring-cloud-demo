package org.huifer.springcloud.servicea.event.login.impl;


import org.huifer.springcloud.servicea.event.login.LoginEvent;
import org.huifer.springcloud.servicea.event.login.LoginEventListener;
import org.springframework.stereotype.Service;

@Service("wxLoginEventListener")
public class WxLoginEventListenerImpl implements LoginEventListener {

  /**
   * 登陆之后
   *
   * @param loginEvent
   */
  @Override
  public void afterLogin(LoginEvent loginEvent) {
    System.out.println("wx 登陆");
  }
}
