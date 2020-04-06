package org.huifer.springcloud.servicea.redis.expire;


import lombok.extern.slf4j.Slf4j;
import org.huifer.springcloud.servicea.constants.BaseConstants;
import org.huifer.springcloud.servicea.model.db.TDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service("demoExpire")
public class ISetExpireForRedisImpl<S> implements ISetExpireForRedis<TDemo> {

  /**
   * 过期队列
   */
  public static final String EXPIRE_LIST = BaseConstants.RedisExpireKey.EXPIRE_LIST;
  /**
   * 过期完整队列
   */
  public static final String EXPIRE_LIST_COPY = BaseConstants.RedisExpireKey.EXPIRE_LIST_COPY;

  @Autowired
  private RedisTemplate<String, TDemo> redisTemplate;

  @Override
  public void expire(long sec, TDemo tDemo) {
    // 设置过期信息的时候需要两个队列都设置
    String expireKey = EXPIRE_LIST + tDemo.getId().toString();
    log.info("设置过期key=[{}],过期时间=[{}],value=[{}]", expireKey, sec, tDemo);
    redisTemplate.opsForValue()
        .set(expireKey, tDemo, sec, TimeUnit.SECONDS);
    redisTemplate.opsForValue()
        .set(EXPIRE_LIST_COPY + tDemo.getId().toString(), tDemo);

  }

  @Override
  public void removeExpire(TDemo tDemo) {
    // 删除过期的时候两个都需要删除
    String expireKey = EXPIRE_LIST + tDemo.getId().toString();
    log.info("取消过期的key,key=[{}]", expireKey);
    redisTemplate.delete(expireKey);
    redisTemplate.delete(EXPIRE_LIST_COPY + tDemo.getId().toString());
  }

  @Override
  public TDemo getExpireObj(String id) {
    log.info("获取过期key");
    Set<String> keys = redisTemplate.keys(EXPIRE_LIST_COPY + "*");
    for (String key : keys) {
      String[] split = key.split(":");
      String s = split[split.length - 1];
      if (s.equals(id)) {
        return redisTemplate.opsForValue().get(EXPIRE_LIST_COPY + id);
      }
    }
    return null;
  }

  @Override
  public void doSomeThine(String id) {
    // 做一些你需要做的事情
    TDemo expireObj = this.getExpireObj(id);
  }
}
