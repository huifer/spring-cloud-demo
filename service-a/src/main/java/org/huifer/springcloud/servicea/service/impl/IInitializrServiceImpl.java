package org.huifer.springcloud.servicea.service.impl;

import org.huifer.springcloud.servicea.constants.InitializrGlobalValue;
import org.huifer.springcloud.servicea.service.IInitializrService;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@Order
public class IInitializrServiceImpl implements IInitializrService {


  public static final InitializrGlobalValue INITIALIZR_VALUE = new InitializrGlobalValue();


  /**
   * 初始化缓存
   */
  @PostConstruct
  @Override
  public void initCache() {

  }

  /**
   * 获取全局变量
   *
   * @return
   */
  @Override
  public InitializrGlobalValue getValue() {
    return INITIALIZR_VALUE;
  }

  /**
   * 初始化全局变量
   */
  @PostConstruct
  @Override
  public void initGlobalVariable() {
    INITIALIZR_VALUE.getMap().put("1", "abc");
  }
}
