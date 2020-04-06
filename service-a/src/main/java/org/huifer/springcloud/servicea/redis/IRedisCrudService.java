package org.huifer.springcloud.servicea.redis;


import org.huifer.springcloud.servicea.base.HuiFerBaseInfo;

import java.util.List;

/**
 * redis 增删改查相关,这是一个基本类
 *
 * @param <S> 当前key中放的java对象
 */
public interface IRedisCrudService<S> extends HuiFerBaseInfo {


  /**
   * redis 增删改查
   *
   * @return redis 增删改查
   */
  @Override
  default String info() {
    return "redis 增删改查";
  }

  /**
   * 添加对象
   *
   * @param s java对象
   */
  void add(S s);

  /**
   * 查询所有
   *
   * @return 这个key 下的所有对象
   */
  List<S> queryAll();

  /**
   * 更新
   *
   * @param key redis 中的key
   * @param s   java对象
   */
  default void update(String key, S s) {

  }

  /**
   * 删除
   *
   * @param key redis 中的key
   */
  default void delete(String key) {
  }

  /**
   * 删除
   *
   * @param s
   */
  default void delete(S s) {

  }

  /**
   * 更新
   *
   * @param s
   */
  default void update(S s) {
  }

}
