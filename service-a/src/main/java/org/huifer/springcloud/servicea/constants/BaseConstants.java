package org.huifer.springcloud.servicea.constants;

/**
 * 静态变量
 */
public class BaseConstants {

  public static final String DEFAULT_CHARSET = "UTF-8";

  public static final String REDIS_SPLIT = ":";

  /**
   * 时间格式化
   */
  public class DateFormat {

    public static final String DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";

  }


  /**
   * redis key
   */
  public class RedisKey {

    public static final String DEMO = "demo:";
  }

  /**
   * redis 过期key ， 成对
   */
  public class RedisExpireKey {

    public static final String EXPIRE_LIST = "EXPIRE_LIST:";
    public static final String EXPIRE_LIST_COPY = "EXPIRE_LIST:COPY:";
  }


}
