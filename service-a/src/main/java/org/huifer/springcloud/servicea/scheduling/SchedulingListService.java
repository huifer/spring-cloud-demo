package org.huifer.springcloud.servicea.scheduling;

import org.huifer.springcloud.servicea.scheduling.demo.IDemoScheduling;
import org.huifer.springcloud.servicea.scheduling.demo.impl.IDemoSchedulingImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * 定时任务列表,所有定时任务全部放在这里
 */
@Service
@EnableScheduling
public class SchedulingListService {

  private final IDemoScheduling iDemoScheduling;

  public SchedulingListService(@Qualifier("demoScheduling") IDemoScheduling iDemoScheduling) {
    this.iDemoScheduling = iDemoScheduling;
  }

  @Scheduled(cron = IDemoSchedulingImpl.PRINT_HELLO_CRON)
  public void printHello() {
    iDemoScheduling.printHello();
  }

}
