package org.huifer.springcloud.servicea.web.mobile;

import org.huifer.springcloud.servicea.constants.InitializrGlobalValue;
import org.huifer.springcloud.servicea.model.req.UserLoginReq;
import org.huifer.springcloud.servicea.service.IInitializrService;
import org.huifer.springcloud.servicea.service.login.impl.LogEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/event")
public class EventController {

  @Autowired
  @Qualifier("logEventService")
  LogEventService logEventService;

  @Autowired
  IInitializrService initializrService;

  @PostMapping("/login")
  public void login(
      @RequestBody UserLoginReq userLoginReq
  ) {
    InitializrGlobalValue value = initializrService.getValue();
    logEventService.login(userLoginReq);
  }

}
