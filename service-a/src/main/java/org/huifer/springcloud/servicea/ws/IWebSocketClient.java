package org.huifer.springcloud.servicea.ws;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;

public interface IWebSocketClient {

  /**
   * 连接建立成功调用的方法
   *
   * @param session session
   */
  @OnOpen
  void onOpen(Session session);

  /**
   * 连接关闭调用的方法
   */
  @OnClose
  void onClose();

  /**
   * 收到客户端消息后调用的方法
   *
   * @param message 客户端发送过来的消息
   * @param session session
   */
  @OnMessage
  void onMessage(String message, Session session);

  /**
   * 出现异常时候的调用方法
   *
   * @param session session
   * @param error   异常
   */
  @OnError
  void onError(Session session, Throwable error);

}
