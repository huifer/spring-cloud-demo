package org.huifer.springcloud.servicea.constants;

import lombok.Data;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 全局变量， 线程安全的 存储内容: 初始化时载入对象
 */
@Data
public class InitializrGlobalValue {

  public Map<String, String> map = new ConcurrentHashMap<>();

}
