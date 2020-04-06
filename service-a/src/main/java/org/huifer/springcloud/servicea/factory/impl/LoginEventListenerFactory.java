package org.huifer.springcloud.servicea.factory.impl;

import org.huifer.springcloud.servicea.event.login.LoginEventListener;
import org.huifer.springcloud.servicea.event.login.impl.QqLoginEventListenerImpl;
import org.huifer.springcloud.servicea.event.login.impl.WxLoginEventListenerImpl;
import org.huifer.springcloud.servicea.factory.EventListenerFactoryInterface;
import org.huifer.springcloud.servicea.model.enums.LoginTypeEnums;
import org.springframework.context.ApplicationContext;

/**
 * 登录事件工厂
 *
 * @see LoginEventListener
 * @see QqLoginEventListenerImpl
 * @see WxLoginEventListenerImpl
 */
public class LoginEventListenerFactory implements

        EventListenerFactoryInterface<LoginEventListener, LoginTypeEnums> {

  private final ApplicationContext applicationContext;

  public LoginEventListenerFactory(
      ApplicationContext applicationContext) {
    this.applicationContext = applicationContext;
  }

  /**
   * 创建实例
   *
   * @param loginTypeEnums 枚举
   * @return 实例接口
   */
  @Override
  public LoginEventListener newInstance(LoginTypeEnums loginTypeEnums) {
    if (loginTypeEnums.equals(LoginTypeEnums.QQ)) {
      return applicationContext.getBean(QqLoginEventListenerImpl.class);
    } else if (loginTypeEnums.equals(LoginTypeEnums.WX)) {
      return applicationContext.getBean(WxLoginEventListenerImpl.class);
    } else {
      throw new IllegalArgumentException("参数异常,不能创建对应的登陆事件");
    }
  }

  /**
   * 信息
   *
   * @return 具体信息描述
   */
  @Override
  public String info() {
    return "登录事件工厂";
  }


}
