package org.huifer.springcloud.servicea.redis.expire;


import org.huifer.springcloud.servicea.base.HuiFerBaseInfo;

/**
 * 设置过期时间redis
 *
 * @param <S> 放入redis的对象
 */
public interface ISetExpireForRedis<S> extends HuiFerBaseInfo {


  /**
   * 设置过期
   *
   * @param sec 过期时间，秒
   * @param s   对象
   */
  void expire(long sec, S s);

  /**
   * 删除过期元素
   *
   * @param s
   */
  void removeExpire(S s);


  /**
   * 获取过期队列的一个对象id
   *
   * @param id 过期的末尾id
   * @return
   */
  S getExpireObj(String id);


  /**
   * 过期后执行什么
   *
   * @param id 过期的末尾id
   */
  default void doSomeThine(String id) {
  }


  /**
   * 信息
   *
   * @return redis 过期操作相关接口
   */
  @Override
  default String info() {
    return "redis 过期操作相关接口";
  }
}
