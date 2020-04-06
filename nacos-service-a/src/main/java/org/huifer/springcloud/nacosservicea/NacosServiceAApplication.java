package org.huifer.springcloud.nacosservicea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class NacosServiceAApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosServiceAApplication.class, args);
    }
}
