package org.huifer.springcloud.nacosservicea.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@FeignClient("nacos-example")
//@RequestMapping("/nacos-example")
public interface NacosFeignController {
    @GetMapping("/nacos/author")
    Map<String, String> author();
}
