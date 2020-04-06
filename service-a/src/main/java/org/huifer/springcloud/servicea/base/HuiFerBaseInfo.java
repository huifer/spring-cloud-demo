package org.huifer.springcloud.servicea.base;

/**
 * 信息接口
 */
public interface HuiFerBaseInfo {

  /**
   * 信息
   *
   * @return 具体信息描述
   */
  default String info() {
    return "";
  }
}
