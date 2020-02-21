package ysn.com.demo.annotation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author yangsanning
 * @ClassName TimeFormat
 * @Description 时间字段类型的输出格式 (ElementType.FIELD 仅作用在字段上)
 * @Date 2020/2/21
 * @History 2020/2/21 author: description:
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface TimeFormat {

    String pattern() default "yyyy-MM-dd HH:mm:ss";

    String timezone() default "GMT+8";
}
