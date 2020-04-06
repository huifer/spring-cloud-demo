package org.huifer.springcloud.servicea.redis.expire.listener;

import lombok.extern.slf4j.Slf4j;
import org.huifer.springcloud.servicea.model.db.TDemo;
import org.huifer.springcloud.servicea.model.res.UserInfoRes;
import org.huifer.springcloud.servicea.redis.expire.ISetExpireForRedisImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.KeyExpirationEventMessageListener;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.stereotype.Service;

import static org.huifer.springcloud.servicea.constants.BaseConstants.REDIS_SPLIT;


/**
 * redis 过期监听
 */
@Service
@Slf4j
public class ExpireListenerService extends KeyExpirationEventMessageListener {

  @Autowired
  private RedisTemplate<String, TDemo> redisTemplate;

  @Autowired
  private RedisTemplate<String, UserInfoRes> ro;
  @Autowired
  @Qualifier("demoExpire")
  private ISetExpireForRedisImpl iSetExpireForRedis;


  public ExpireListenerService(
      RedisMessageListenerContainer listenerContainer) {
    super(listenerContainer);
  }

  /**
   * key 过期时候的消息
   */
  @Override
  public void onMessage(Message message, byte[] pattern) {
    // 过期的key
    String expiredKey = message.toString();
    // value 获取需要copy队列
    if (expiredKey.startsWith(ISetExpireForRedisImpl.EXPIRE_LIST)) {
      // 具体实现通过不同的类进行执行
      demoExpireDoWork(expiredKey);
    }
  }

  /**
   * demo 过期之后做什么事情
   *
   * @param expiredKey
   */
  private void demoExpireDoWork(String expiredKey) {
    String expireId = getExpireId(expiredKey);
    TDemo expireObj = this.iSetExpireForRedis.getExpireObj(expireId);
    log.info("过期key = [{}] , value = [{}] ", expiredKey, expireObj);
    iSetExpireForRedis.doSomeThine(expireId);
  }

  /**
   * 获取过期的ID
   *
   * @param expiredKey 过期的key xxx:数字id(唯一id)
   * @return
   */
  private String getExpireId(String expiredKey) {
    String[] split = expiredKey.split(REDIS_SPLIT);
    return split[split.length - 1];
  }
}
