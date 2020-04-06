package org.huifer.springcloud.servicea.model.message;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.huifer.springcloud.servicea.base.WebSocketMessage;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ColMessage implements WebSocketMessage {

  private String name;

  @Override
  public String toSendMessage() {
    return JSON.toJSONString(this);
  }
}
