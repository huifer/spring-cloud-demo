package org.huifer.springcloud.servicea.controller;

import org.huifer.springcloud.servicea.entity.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/test")
public class TestController {
    private static final Logger LOG = LoggerFactory.getLogger(TestController.class);
    @Autowired
    HttpServletRequest httpServletRequest;
    @Autowired
    private RedisTemplate<String, UserInfo> redisTemplate;

    @GetMapping("/index")
    public String index() {
        UserInfo userInfo = new UserInfo();
        userInfo.setName("123");
        userInfo.setAge(3);


        redisTemplate.opsForValue().set("325", userInfo);

        System.out.println(httpServletRequest.getHeader("tid"));
        return "这是 服务a的测试地址";
    }
}
