package org.huifer.springcloud.servicea.web.pc;

import org.huifer.springcloud.servicea.model.db.TDemo;
import org.huifer.springcloud.servicea.redis.business.demo.HashRedisKeyImpl;
import org.huifer.springcloud.servicea.redis.business.demo.ListRedisKeyImpl;
import org.huifer.springcloud.servicea.redis.business.demo.ValueRedisKeyImpl;
import org.huifer.springcloud.servicea.redis.expire.ISetExpireForRedisImpl;
import org.huifer.springcloud.servicea.service.enums.IEnumsQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/pc")
public class PcController {

  @Autowired
  ListRedisKeyImpl listRedisKeyImpl;
  @Autowired
  HashRedisKeyImpl hashRedisKeyImpl;
  @Autowired
  @Qualifier("demoExpire")
  ISetExpireForRedisImpl setExpireForRedis;
  @Autowired
  @Qualifier("enumsQueryService")
  IEnumsQueryService enumsQueryService;
  @Autowired
  private ValueRedisKeyImpl valueRedisKeyImpl;

  @GetMapping("/add")
  public void add() {
    TDemo tDemo = new TDemo();
    tDemo.setId(0);
    tDemo.setName("asfasf");
    tDemo.setVersion(0L);
    tDemo.setCreateTime(new Date());
    tDemo.setUpdateTime(new Date());
    tDemo.setCreateUser(0);
    tDemo.setUpdateUser(0);

    valueRedisKeyImpl.add(tDemo);

  }

  @GetMapping("/list")
  public Object list() {
    return valueRedisKeyImpl.queryAll();
  }

  @GetMapping("/update")
  public void update() {
    TDemo tDemo = new TDemo();
    tDemo.setId(0);
    tDemo.setName("1231313123");
    tDemo.setVersion(0L);
    tDemo.setCreateTime(new Date());
    tDemo.setUpdateTime(new Date());
    tDemo.setCreateUser(0);
    tDemo.setUpdateUser(0);
    valueRedisKeyImpl.update("demo:a334ff69-8ae5-4f62-a6f1-52c32ec2aefb", tDemo);
  }

  @GetMapping("/id1")
  public void id1() {
    TDemo tDemo = new TDemo();
    tDemo.setId(0);
    tDemo.setName("11111111");
    listRedisKeyImpl.add(tDemo);
  }

  @GetMapping("/id2")
  public void id2() {
    TDemo tDemo = new TDemo();
    tDemo.setId(0);
    tDemo.setName("33333333");
    listRedisKeyImpl.update(tDemo);
  }

  @GetMapping("/i3")
  public void i3() {
    TDemo tDemo = new TDemo();
    tDemo.setId(0);
    tDemo.setName("11111111");
    hashRedisKeyImpl.add(tDemo);
  }

  @GetMapping("i4")
  public Object i4() {
    return hashRedisKeyImpl.queryAll();
  }

  @GetMapping("i5")
  public void i5() {
    TDemo tDemo = new TDemo();
    tDemo.setId(0);
    tDemo.setName("11111111");
    hashRedisKeyImpl.delete(tDemo);
  }

  @GetMapping("/a1")
  public void a1() {
    TDemo tDemo = new TDemo();
    tDemo.setId(0);
    tDemo.setName("11111111");
    setExpireForRedis.expire(10L, tDemo);
  }

  @GetMapping("/a2")
  public void a2() {
    TDemo tDemo = new TDemo();
    tDemo.setId(0);
    tDemo.setName("11111111");
    setExpireForRedis.removeExpire(tDemo);
  }

  @GetMapping("/enum")
  public Object enumsQuery() {
    return enumsQueryService.query();
  }
}
