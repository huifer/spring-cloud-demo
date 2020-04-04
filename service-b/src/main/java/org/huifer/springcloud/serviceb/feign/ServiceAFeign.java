package org.huifer.springcloud.serviceb.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


// 标注需要远程的服务
@FeignClient("service-a")
// 标注 远程服务的路由前缀
@RequestMapping("/app-one")
public interface ServiceAFeign {
    @GetMapping("/test/index")
    String index();
}
