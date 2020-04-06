package org.huifer.springcloud.nacos;

import org.huifer.springcloud.nacos.lis.MyApplicationStartedEventListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class NacosApplication {


    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(NacosApplication.class);
        app.addListeners(new MyApplicationStartedEventListener());
        app.run(args);

    }

}
