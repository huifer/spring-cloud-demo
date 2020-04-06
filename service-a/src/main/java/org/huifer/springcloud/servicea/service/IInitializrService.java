package org.huifer.springcloud.servicea.service;


import org.huifer.springcloud.servicea.base.HuiFerBaseInfo;
import org.huifer.springcloud.servicea.constants.InitializrGlobalValue;

/**
 * 项目启动后做的一些事情
 */
public interface IInitializrService extends HuiFerBaseInfo {

  /**
   * 初始化缓存
   */
  void initCache();

  /**
   * 初始化全局变量
   */
  void initGlobalVariable();


  /**
   * 获取全局变量
   * @return
   */
  InitializrGlobalValue getValue();

  /**
   * 信息
   *
   * @return 具体信息描述
   */
  @Override
  default String info() {
    return "启动时做的一些操作";
  }
}
