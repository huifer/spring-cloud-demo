package org.huifer.springcloud.servicea.service.login;

import java.util.UUID;

public abstract class AbsLogin {

  protected String uuid() {
    return UUID.randomUUID().toString();
  }
}
