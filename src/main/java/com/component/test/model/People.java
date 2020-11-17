package com.component.test.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @Author: bao
 * @Date: 2020/5/27 0027 8:55
 */
public class People {
    private Integer id =1;
    @NotEmpty
    private String name="xiaoming";

    public Integer getId() {
        return id;
    }

    private Integer age=18;

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
