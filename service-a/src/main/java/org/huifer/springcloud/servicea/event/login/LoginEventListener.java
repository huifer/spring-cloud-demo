package org.huifer.springcloud.servicea.event.login;


import org.huifer.springcloud.servicea.event.EventListener;

public interface LoginEventListener extends EventListener {

  /**
   * 信息
   *
   * @return 具体信息描述
   */
  @Override
  default String info() {
    return "登陆事件监听";
  }

  /**
   * 登陆之后
   *
   * @param loginEvent
   */
  void afterLogin(LoginEvent loginEvent);


}
