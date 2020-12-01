package com.component.model;

import javax.validation.constraints.NotEmpty;

/**
 * @Author: bao
 * @Date: 2020/6/10 0010 11:45
 */
public class Human {
    private Integer id =1;

    private String name="xiaoming";

    private String sex="男";

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
