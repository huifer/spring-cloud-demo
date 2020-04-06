package org.huifer.springcloud.servicea.service.login;


import org.huifer.springcloud.servicea.model.req.UserLoginReq;
import org.huifer.springcloud.servicea.service.IBusinessService;

public interface ILoginEventService extends IBusinessService {

  /**
   * 登陆事件
   * @param userLoginReq
   */
  void login(UserLoginReq userLoginReq);

  /**
   * 信息
   *
   * @return "业务接口标记"
   */
  @Override
  default String info() {
    return "登陆事件服务";
  }
}
