package org.huifer.springcloud.nacosservicea.controller;

import org.huifer.springcloud.nacosservicea.feign.NacosFeignController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fasfasf")
public class TestController {

    @Autowired
    private NacosFeignController nacosFeignController;

    @GetMapping("/fassasf")
    public String name() {
        return "alksfjlkasjflajslkfjalksflk";
    }

    @GetMapping("/test")
    public Object test() {
        return nacosFeignController.author();
    }
}
