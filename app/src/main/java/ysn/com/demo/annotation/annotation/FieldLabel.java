package ysn.com.demo.annotation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author yangsanning
 * @ClassName FieldLabel
 * @Description FieldLabel 当前字段输出的名称 (ElementType.FIELD 仅作用在字段上)
 * @Date 2020/2/21
 * @History 2020/2/21 author: description:
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface FieldLabel {

    String value() default "";
}
