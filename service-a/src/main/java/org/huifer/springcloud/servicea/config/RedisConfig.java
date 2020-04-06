package org.huifer.springcloud.servicea.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

  @Bean
  public RedisMessageListenerContainer redisMessageListenerContainer() {
    return new RedisMessageListenerContainer();
  }

  @Bean
  public RedisSerializer gsonConfigForRedis() {
    return new GsonConfigForRedis<Object>(Object.class);
  }

  @Bean
  public RedisTemplate redisTemplate(RedisConnectionFactory factory,
                                     RedisSerializer gsonConfigForRedis) {
    RedisMessageListenerContainer container = redisMessageListenerContainer();
    container.setConnectionFactory(factory);

    StringRedisTemplate result = new StringRedisTemplate(factory);
    result.setValueSerializer(gsonConfigForRedis);
    result.setHashValueSerializer(gsonConfigForRedis);
    result.setKeySerializer(new StringRedisSerializer());
    result.afterPropertiesSet();
    return result;
  }

}
