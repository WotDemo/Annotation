package ysn.com.demo.annotation.formatter;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import ysn.com.demo.annotation.annotation.FieldLabel;
import ysn.com.demo.annotation.annotation.TimeFormat;

/**
 * @Author yangsanning
 * @ClassName SimpleFormatter
 * @Description {@link FieldLabel} 以及 {@link TimeFormat} 注解转换输出
 * @Date 2020/2/21
 * @History 2020/2/21 author: description:
 */
public class SimpleFormatter {

    /**
     * {@link FieldLabel} 以及 {@link TimeFormat} 注解转换输出
     */
    public static String format(Object obj) {
        try {
            Class<?> cls = obj.getClass();
            StringBuilder builder = new StringBuilder();
            for (Field field : cls.getDeclaredFields()) {
                if (!field.isAccessible()) {
                    // 放弃java安全检测，设置可以访问私有字段
                    field.setAccessible(true);
                }

                // 获取FieldLabel注解
                FieldLabel label = field.getAnnotation(FieldLabel.class);

                // 获取字段名称
                String name = (label == null) ? field.getName() : label.value();

                // 获取字段对应的 value
                Object value = field.get(obj);

                // 如果是 Date类型, 走时间格式化
                if (null != value && field.getType() == Date.class) {
                    value = timeFormat(field, value);
                }
                builder.append(name).append(": ").append(value).append("\n");
            }
            return builder.toString();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("转换失败:" + e.getMessage());
        }
    }

    /**
     * 针对时间类型字段进行格式化的方法
     */
    private static Object timeFormat(Field field, Object value) {
        TimeFormat timeFormat = field.getAnnotation(TimeFormat.class);
        if (timeFormat == null) {
            return value;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(timeFormat.pattern());
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone(timeFormat.timezone()));
        return simpleDateFormat.format(value);
    }
}
