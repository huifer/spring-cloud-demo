package org.huifer.springcloud.servicea.valid;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EnumValidtor implements ConstraintValidator<EnumValidAnnotation, String> {

  private Class<?> clazz;

  @Override
  public void initialize(EnumValidAnnotation enumValidAnnotation) {
    clazz = enumValidAnnotation.target();
  }

  @Override
  public boolean isValid(String value
      , ConstraintValidatorContext context) {

    try {
      if (clazz.isEnum()) {
        // 这个是美剧的全部
        Object[] objs = clazz.getEnumConstants();
        for (Object obj : objs) {
          if (obj instanceof Enum) {
            Enum rel = (Enum) obj;
            if (rel.name().equalsIgnoreCase(value)) {
              return true;
            }
          }
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return false;
  }

}
