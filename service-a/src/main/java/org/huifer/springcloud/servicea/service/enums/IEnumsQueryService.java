package org.huifer.springcloud.servicea.service.enums;


import org.huifer.springcloud.servicea.model.db.TDemo;
import org.huifer.springcloud.servicea.service.IBusinessService;

public interface IEnumsQueryService extends IBusinessService {

  TDemo query();

  @Override
  default String info() {
    return "枚举查询";
  }
}
