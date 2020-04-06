package org.huifer.springcloud.servicea.valid;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {EnumValidtor.class})
@Documented
public @interface EnumValidAnnotation {

  /**
   * 异常提示
   */
  String message() default "";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

  /**
   * 需要校验的类
   *
   * @return
   */
  Class<?> target();
}