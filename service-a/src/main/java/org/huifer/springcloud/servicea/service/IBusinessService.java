package org.huifer.springcloud.servicea.service;


import org.huifer.springcloud.servicea.base.HuiFerBaseInfo;

/**
 * 业务接口标记
 */
public interface IBusinessService extends HuiFerBaseInfo {

  /**
   * 信息
   *
   * @return "业务接口标记"
   */
  @Override
  default String info() {
    return "业务接口标记";
  }
}
