package ysn.com.demo.annotation.bean;

import java.util.Date;

import ysn.com.demo.annotation.annotation.FieldLabel;
import ysn.com.demo.annotation.annotation.TimeFormat;

/**
 * @Author yangsanning
 * @ClassName User
 * @Description 一句话概括作用
 * @Date 2020/2/21
 * @History 2020/2/21 author: description:
 */
public class User {

    @FieldLabel("姓名")
    private String name;

    @FieldLabel("出生日期")
    @TimeFormat(pattern = "yyyy/MM/dd")
    private Date born;

    @FieldLabel("年龄")
    private double age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBorn() {
        return born;
    }

    public void setBorn(Date born) {
        this.born = born;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }
}