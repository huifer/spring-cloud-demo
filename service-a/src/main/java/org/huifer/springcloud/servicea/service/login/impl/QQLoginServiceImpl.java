package org.huifer.springcloud.servicea.service.login.impl;

import lombok.extern.slf4j.Slf4j;
import org.huifer.springcloud.servicea.service.login.AbsLogin;
import org.huifer.springcloud.servicea.service.login.ILoginService;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class QQLoginServiceImpl extends AbsLogin implements ILoginService {

  @Override
  public String info() {
    return "QQ 登录";
  }
}
