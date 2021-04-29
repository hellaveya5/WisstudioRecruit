package com.wisstudio.Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author:98333
 * @Date:2021/4/28
 * @Description:com.wisstudio.Annotation
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface GetMapping {
    String[] value() default {};
}
