package org.huifer.springcloud.servicea.service.demo;


import org.huifer.springcloud.servicea.service.IBusinessService;

public interface IDemoBusinessService extends IBusinessService {

  /**
   * 添加
   */
  void add();

  /**
   * 添加一个错误
   */
  void addError();

  /**
   * 更新
   */
  void up();

  /**
   * 实例 service
   *
   * @return 实例 service
   */
  @Override
  default String info() {
    return "实例 service";
  }
}
