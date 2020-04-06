package org.huifer.springcloud.servicea.ws;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 基本操作
 */
@Slf4j
public abstract class AbsWebSocket implements IWebSocketClient {

  /**
   * 连接数
   */
  private static int onlineCount = 0;
  /**
   * web socket 链接保存
   */
  private static ConcurrentHashMap<String, AbsWebSocket> webSocketMap = new ConcurrentHashMap<>();

  private Session session;

  private String userId = "";

  public static synchronized int getOnlineCount() {
    return onlineCount;
  }

  public static synchronized void addOnlineCount() {
    onlineCount++;
  }

  public static synchronized void subOnlineCount() {
    onlineCount--;
  }

  public static ConcurrentHashMap<String, AbsWebSocket> getWebSocketMap() {
    return webSocketMap;
  }

  @OnOpen
  @Override
  public void onOpen(Session session) {
    this.session = session;
    this.userId = userId;
    if (webSocketMap.containsKey(userId)) {
      webSocketMap.remove(userId);
      webSocketMap.put(userId, this);
    } else {
      webSocketMap.put(userId, this);
      addOnlineCount();
    }

    try {
      sendMessage("连接成功");
    } catch (IOException e) {
      log.error("用户:" + userId + ",网络异常!!!!!!");
    }

  }

  /**
   * 发消息
   *
   * @param s
   * @throws IOException
   */
  public void sendMessage(String s) throws IOException {

  }

  @OnClose
  @Override
  public void onClose() {
    if (webSocketMap.containsKey(userId)) {
      webSocketMap.remove(userId);
      //从set中删除
      subOnlineCount();
    }
    log.info("用户退出:" + userId + ",当前在线人数为:" + getOnlineCount());

  }

  @OnMessage
  @Override
  public void onMessage(String message, Session session) {
    log.info("用户消息:" + userId + ",报文:" + message);
    //可以群发消息
    //消息保存到数据库、redis
    if (StringUtils.isNotBlank(message)) {
      try {
        //解析发送的报文
        JSONObject jsonObject = JSON.parseObject(message);
        //追加发送人(防止串改)
        jsonObject.put("fromUserId", this.userId);
        String toUserId = jsonObject.getString("toUserId");
        //传送给对应toUserId用户的websocket
        if (StringUtils.isNotBlank(toUserId) && webSocketMap.containsKey(toUserId)) {
          webSocketMap.get(toUserId).sendMessage(jsonObject.toJSONString());
        } else {
          log.error("请求的userId:" + toUserId + "不在该服务器上");
          //否则不在这个服务器上，发送到mysql或者redis
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

  }

  @OnError
  @Override
  public void onError(Session session, Throwable error) {
    log.error("用户错误:" + this.userId + ",原因:" + error.getMessage());
    error.printStackTrace();

  }

  public Session getSession() {
    return session;
  }
}
