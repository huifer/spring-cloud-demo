package org.huifer.springcloud.nacos.lis;

import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.Ordered;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;
import org.springframework.stereotype.Component;

public class MyApplicationStartedEventListener implements ApplicationListener<ApplicationEnvironmentPreparedEvent>, Ordered {
    @Override
    public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {
        ConfigurableEnvironment configurableEnvironment = event.getEnvironment();
        System.out.println(configurableEnvironment);
        MutablePropertySources mutablePropertySources = configurableEnvironment.getPropertySources();
        System.out.println(mutablePropertySources);
        for (PropertySource<?> mutablePropertySource : mutablePropertySources) {
            String name = mutablePropertySource.getName();
            Object property = mutablePropertySource.getProperty(name);
            System.out.println("配置名: " + name + " 数据: " + property);
        }

    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE + 10;
    }
}
