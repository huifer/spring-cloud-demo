package org.huifer.springcloud.servicea.ws;


import org.huifer.springcloud.servicea.base.HuiFerBaseInfo;

import java.io.IOException;


/**
 * @param <S> 发送的实体对象
 */
public interface IWebSocketService<S> extends HuiFerBaseInfo {

  /**
   * 发消息
   *
   * @param s 对象
   */
  void send(String userId, S s) throws IOException;


  /**
   * 服务器主动推送
   *
   * @param s 对象
   */
  void sendMessage(S s) throws IOException;

  @Override
  default String info() {
    return "webSocket 服务接口定义";
  }
}
