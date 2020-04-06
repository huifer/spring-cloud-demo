package org.huifer.springcloud.servicea.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.huifer.springcloud.servicea.constants.BaseConstants;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import java.nio.charset.Charset;

/**
 * Redis序列化工具，使用Fastjson
 */
public class FastJson2JsonRedisSerializer<T> implements RedisSerializer<T> {

  public static final Charset DEFAULT_CHARSET = Charset.forName(BaseConstants.DEFAULT_CHARSET);

  private Class<T> clazz;

  public FastJson2JsonRedisSerializer(Class<T> clazz) {
    super();
    this.clazz = clazz;
  }

  @Override
  public byte[] serialize(T t) throws SerializationException {
    if (t == null) {
      return new byte[0];
    }
    return JSON.toJSONString(t, SerializerFeature.WriteClassName).getBytes(DEFAULT_CHARSET);
  }

  @Override
  public T deserialize(byte[] bytes) throws SerializationException {
    if (bytes == null || bytes.length <= 0) {
      return null;
    }
    String str = new String(bytes, DEFAULT_CHARSET);

    return JSON.parseObject(str, clazz);
  }
}