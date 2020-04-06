package org.huifer.springcloud.servicea.service.login;


import org.huifer.springcloud.servicea.service.IBusinessService;

public interface ILoginService extends IBusinessService {

  @Override
  default String info() {
    return "登录服务";
  }
}
