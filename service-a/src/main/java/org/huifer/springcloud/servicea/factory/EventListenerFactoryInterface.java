package org.huifer.springcloud.servicea.factory;


import org.huifer.springcloud.servicea.base.HuiFerBaseInfo;

/**
 * 工厂接口
 *
 * @param <I> 事件接口
 * @param <E> 枚举
 */
public interface EventListenerFactoryInterface<I, E> extends HuiFerBaseInfo {

  /**
   * 创建实例
   *
   * @param e 枚举
   * @return 实例接口
   */
  I newInstance(E e);


  /**
   * 信息
   *
   * @return 具体信息描述
   */
  @Override
  default String info() {
    return "工厂接口";
  }
}
