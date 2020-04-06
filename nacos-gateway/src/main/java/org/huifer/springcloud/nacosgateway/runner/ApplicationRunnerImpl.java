package org.huifer.springcloud.nacosgateway.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ApplicationRunnerImpl implements ApplicationRunner {
    private static final Logger LOG = LoggerFactory.getLogger(ApplicationRunnerImpl.class);

    @Override
    public void run(ApplicationArguments args) throws Exception {
        LOG.info("启动成功");
    }
}
