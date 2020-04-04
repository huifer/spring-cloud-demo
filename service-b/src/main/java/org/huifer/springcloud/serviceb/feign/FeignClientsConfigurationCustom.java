package org.huifer.springcloud.serviceb.feign;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
@EnableFeignClients(basePackages = "org.huifer.springcloud.serviceb.feign")
public class FeignClientsConfigurationCustom implements RequestInterceptor {
  @Override
  public void apply(RequestTemplate requestTemplate) {
    HttpServletRequest httpServletRequest = getHttpServletRequest();
    String tid = httpServletRequest.getHeader("tid");
    System.out.println("转发tid=\t" + tid);
    Map<String,String> headers = getHeaders(httpServletRequest);
    for(String headerName : headers.keySet()){
      requestTemplate.header(headerName, getHeaders(getHttpServletRequest()).get(headerName));
    }
  }

  private HttpServletRequest getHttpServletRequest() {
    try {
      return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  private Map<String, String> getHeaders(HttpServletRequest request) {
    Map<String, String> map = new LinkedHashMap<>();
    Enumeration<String> enumeration = request.getHeaderNames();
    while (enumeration.hasMoreElements()) {
      String key = enumeration.nextElement();
      String value = request.getHeader(key);
      map.put(key, value);
    }
    return map;
  }

}