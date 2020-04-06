package org.huifer.springcloud.servicea.service;


import org.huifer.springcloud.servicea.base.HuiFerBaseInfo;

/**
 * 统计标记接口
 */
public interface IStatisticsService extends HuiFerBaseInfo {


  /**
   * 信息
   *
   * @return 统计服务
   */
  default String init() {
    return "统计服务";
  }
}
