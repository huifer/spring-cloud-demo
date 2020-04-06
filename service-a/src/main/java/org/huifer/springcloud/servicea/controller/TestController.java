package org.huifer.springcloud.servicea.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;

@RestController
@RequestMapping("/test")
public class TestController {
    private static final Logger LOG = LoggerFactory.getLogger(TestController.class);
    @Autowired
    HttpServletRequest httpServletRequest;

    @GetMapping("/index")
    public String index() {
        System.out.println(httpServletRequest.getHeader("tid"));
        return "这是 服务a的测试地址";
    }
}
