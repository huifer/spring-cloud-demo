package org.huifer.springcloud.servicea.service.enums.impl;

import lombok.extern.slf4j.Slf4j;
import org.huifer.springcloud.servicea.mapper.TDemoMapper;
import org.huifer.springcloud.servicea.model.db.TDemo;
import org.huifer.springcloud.servicea.model.enums.SexEnums;
import org.huifer.springcloud.servicea.service.enums.IEnumsQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service("enumsQueryService")
public class IEnumsQueryServiceImpl implements IEnumsQueryService {

  @Autowired
  private TDemoMapper tDemoMapper;

  @Override
  public TDemo query() {
    return tDemoMapper.queryEnums(SexEnums.MAN);
  }

}
