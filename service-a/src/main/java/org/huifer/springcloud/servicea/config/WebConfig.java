package org.huifer.springcloud.servicea.config;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.ToStringSerializer;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.huifer.springcloud.servicea.constants.BaseConstants;
import org.huifer.springcloud.servicea.intercepter.HttpServletRequestFilter;
import org.huifer.springcloud.servicea.intercepter.SiteHandlerInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {

  private static final Logger logger = LoggerFactory.getLogger(WebConfig.class);

  static {
    // 解决fastJson autoType is not support错误
    ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
  }

  @Autowired
  private FastJsonHttpMessageConverter fastJsonHttpMessageConverter;

  @Override
  public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
    converters.add(fastJsonHttpMessageConverter);
  }

  private FastJsonConfig fastjsonConfig() {
    FastJsonConfig result = new FastJsonConfig();

    JSONObject.DEFFAULT_DATE_FORMAT = BaseConstants.DateFormat.DEFAULT_FORMAT;

    result.setSerializerFeatures(
        // 保留map空的字段
        SerializerFeature.WriteMapNullValue,
        // 将String类型的null转成""
        SerializerFeature.WriteNullStringAsEmpty,
        // 将Number类型的null转成0
//                SerializerFeature.WriteNullNumberAsZero,
        // 将List类型的null转成[]
        SerializerFeature.WriteNullListAsEmpty,
        // 将Boolean类型的null转成false
        SerializerFeature.WriteNullBooleanAsFalse,
        // 避免循环引用
        SerializerFeature.DisableCircularReferenceDetect

    );
    result.setCharset(StandardCharsets.UTF_8);

    // 解决Long转json精度丢失的问题
    SerializeConfig serializeConfig = SerializeConfig.globalInstance;
    serializeConfig.put(BigInteger.class, ToStringSerializer.instance);
    serializeConfig.put(Long.class, ToStringSerializer.instance);
    serializeConfig.put(Long.TYPE, ToStringSerializer.instance);
    result.setDateFormat(BaseConstants.DateFormat.DEFAULT_FORMAT);
    result.setSerializeConfig(serializeConfig);
    return result;
  }

  @Bean
  public FastJsonHttpMessageConverter fastJsonHttpMessageConverter() {
    FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
    converter.setFastJsonConfig(fastjsonConfig());
    converter.setSupportedMediaTypes(getSupportedMediaType());
    return converter;
  }

  /**
   * 跨域处理
   *
   * @param registry
   */
  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**").allowedOrigins("*")
        .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")
        .maxAge(3600).allowCredentials(false);
  }

  /**
   * 支持的mediaType类型
   */
  private List<MediaType> getSupportedMediaType() {
    List<MediaType> result = new ArrayList<>();
    result.add(MediaType.APPLICATION_JSON);
    // 添加通用的json mediaType提高兼容性
    result.add(MediaType.parseMediaType("application/*+json"));
    return result;
  }

  /**
   * 注册拦截器
   */
  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(new SiteHandlerInterceptor()).addPathPatterns("/**");
  }

  /**
   * RestTemplate 配置
   *
   * @param factory
   * @return
   */
  @Bean
  public RestTemplate restTemplate(ClientHttpRequestFactory factory) {
    return new RestTemplate(factory);
  }

  /**
   * RestTemplate 连接工厂配置
   *
   * @return
   */
  @Bean
  public ClientHttpRequestFactory simpleClientHttpRequestFactory() {
    SimpleClientHttpRequestFactory result = new SimpleClientHttpRequestFactory();
    // 单位为ms
    result.setReadTimeout(5000);
    // 单位为ms
    result.setConnectTimeout(5000);
    return result;
  }

  /**
   * 注册HttpServletRequest过滤器，用于拦截RequestBody
   *
   * @return
   */
  @Bean
  public FilterRegistrationBean httpServletRequestReplacedRegistration() {
    FilterRegistrationBean result = new FilterRegistrationBean();
    result.setFilter(new HttpServletRequestFilter());
    result.addUrlPatterns("/*");
    result.setName("httpServletRequestFilter");
    result.setOrder(Ordered.LOWEST_PRECEDENCE);
    return result;
  }

  @PostConstruct
  public void init() {
    logger.info("====== init ======");
  }

  @PreDestroy
  public void cleanUp() throws Exception {
    logger.info("====== clean up ======");
  }
}
