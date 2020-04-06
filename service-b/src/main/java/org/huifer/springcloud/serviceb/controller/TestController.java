package org.huifer.springcloud.serviceb.controller;

import org.huifer.springcloud.serviceb.feign.ServiceAFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private ServiceAFeign serviceAFeign;


    @Autowired
    HttpServletRequest httpServletRequest;


    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/app-one")
    public String appOne() {
        System.out.println(httpServletRequest.getHeader("tid"));
        return "服务互通" + serviceAFeign.index();
    }


    @GetMapping("/index")
    public String index() {
        return "这是 服务a的测试地址";
    }
}
