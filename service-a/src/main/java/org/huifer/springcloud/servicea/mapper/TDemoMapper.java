package org.huifer.springcloud.servicea.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.huifer.springcloud.servicea.model.db.TDemo;
import org.huifer.springcloud.servicea.model.enums.SexEnums;

@Mapper
public interface TDemoMapper {

  int deleteByPrimaryKey(Integer id);

  int insert(TDemo record);

  int insertSelective(TDemo record);

  TDemo selectByPrimaryKey(Integer id);

  int updateByPrimaryKeySelective(TDemo record);

  int updateByPrimaryKey(TDemo record);

  TDemo queryEnums(@Param("man") SexEnums man);
}