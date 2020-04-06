package org.huifer.springcloud.nacos.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/nacos")
public class TestController {
    @Value("${author.name}")
    private String authorName;
    @Value("${author.email}")
    private String authorEmail;

    @GetMapping("/author")
    public Map<String, String> author() {
        Map<String, String> map = new HashMap<>();

        map.put("name", authorName);
        map.put("mail", authorEmail);
        return map;
    }

}
