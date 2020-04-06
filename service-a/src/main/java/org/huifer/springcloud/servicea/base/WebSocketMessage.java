package org.huifer.springcloud.servicea.base;

public interface WebSocketMessage extends HuiFerBaseInfo {

  @Override
  default String info() {
    return "web socket 消息接口";
  }

  /**
   * 转换成消息字符串
   *
   * @return 消息体
   */
  String toSendMessage();
}
