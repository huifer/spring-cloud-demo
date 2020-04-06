package org.huifer.springcloud.servicea.model.req;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.huifer.springcloud.servicea.model.enums.SexEnums;
import org.huifer.springcloud.servicea.valid.EnumValidAnnotation;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DemoReq {

  @EnumValidAnnotation(message = "枚举异常", target = SexEnums.class)
  private String target;

}
