package org.huifer.springcloud.servicea.ws.demo;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.huifer.springcloud.servicea.model.message.ColMessage;
import org.huifer.springcloud.servicea.ws.AbsWebSocket;
import org.huifer.springcloud.servicea.ws.IWebSocketService;
import org.springframework.stereotype.Component;

import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

@Slf4j
@Component
@ServerEndpoint("/demoWebSocket/{userId}")
public class DemoWebSocketService extends AbsWebSocket implements IWebSocketService<ColMessage> {

  @Override
  public void sendMessage(String s) throws IOException {

    super.getSession().getBasicRemote().sendText(s);
  }

  @Override
  public void send(String userId, ColMessage colMessage) throws IOException {
    log.info("发送消息到:" + userId + "，报文:" + colMessage.toSendMessage());
    if (StringUtils.isNotBlank(userId) && getWebSocketMap().containsKey(userId)) {
      getWebSocketMap().get(userId).sendMessage(colMessage.toSendMessage());
    } else {
      log.error("用户" + userId + ",不在线！");
    }
  }

  @Override
  public void sendMessage(ColMessage colMessage) throws IOException {
    super.getSession().getBasicRemote().sendText(colMessage.toSendMessage());
  }
}
