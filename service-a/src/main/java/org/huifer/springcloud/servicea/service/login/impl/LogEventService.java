package org.huifer.springcloud.servicea.service.login.impl;

import org.huifer.springcloud.servicea.event.login.LoginEvent;
import org.huifer.springcloud.servicea.event.login.LoginEventListener;
import org.huifer.springcloud.servicea.factory.EventListenerFactoryInterface;
import org.huifer.springcloud.servicea.factory.impl.LoginEventListenerFactory;
import org.huifer.springcloud.servicea.model.enums.LoginTypeEnums;
import org.huifer.springcloud.servicea.model.req.UserLoginReq;
import org.huifer.springcloud.servicea.service.login.ILoginEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service("logEventService")
public class LogEventService implements ILoginEventService {

  @Autowired
  private ApplicationContext applicationContext;
  private LoginEventListener loginEventListener;

  @Override
  public void login(UserLoginReq userLoginReq) {
    EventListenerFactoryInterface<LoginEventListener, LoginTypeEnums> eventListenerFactoryInterface
        = new LoginEventListenerFactory(applicationContext);

    LoginTypeEnums loginTypeEnums = LoginTypeEnums
        .valueOf(userLoginReq.getLoginType().toUpperCase());
    loginEventListener = eventListenerFactoryInterface.newInstance(loginTypeEnums);
    if (this.loginEventListener != null) {
      this.loginEventListener
          .afterLogin(new LoginEvent(userLoginReq.getLoginType(), userLoginReq.getUserId()));
    }

  }


}
