package org.huifer.springcloud.servicea.model.db;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class TDemo implements Serializable {

  private static final long serialVersionUID = 1L;
  private Integer id;
  private String name;
  private Long version;
  private Date createTime;
  private Date updateTime;
  private Integer createUser;
  private Integer updateUser;

  public static TDemoBuilder builder() {
    return new TDemoBuilder();
  }

  @Override
  public String toString() {
    return "{\"TDemo\":{"
        + "\"id\":"
        + id
        + ",\"name\":\""
        + name + '\"'
        + ",\"version\":"
        + version
        + ",\"createTime\":\""
        + createTime + '\"'
        + ",\"updateTime\":\""
        + updateTime + '\"'
        + ",\"createUser\":"
        + createUser
        + ",\"updateUser\":"
        + updateUser
        + "}}";

  }
}