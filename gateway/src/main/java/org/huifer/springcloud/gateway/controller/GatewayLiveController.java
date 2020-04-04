package org.huifer.springcloud.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gateway")
public class GatewayLiveController {
    @GetMapping("/")
    public String index() {
        return "gateway 存活";
    }
}
