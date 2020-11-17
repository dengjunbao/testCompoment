package com.component.test.controller.TestBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @Author: bao
 * @Date: 2020/9/4 0004 13:07
 */

@Component
 class Teacher {

    private String name = "";
    private Student student;
    @Autowired
    public Teacher (@Lazy Student student) {
        this.student = student;

    }

    public void teach () {
        System.out.println("teach:"+student);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
