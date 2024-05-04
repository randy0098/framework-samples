package com.framework.backend.common.result;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Inherited
public @interface ResponseResult {
  boolean autoPackage() default true;
}
