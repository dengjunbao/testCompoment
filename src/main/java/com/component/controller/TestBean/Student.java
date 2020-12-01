package com.component.controller.TestBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @Author: bao
 * @Date: 2020/9/4 0004 13:07
 */
@Component
 class Student {


    private Teacher teacher;
    @Autowired
    public Student (Teacher teacher) {
        this.teacher = teacher;
    }

    public void learn () {
        System.out.println("Student learn");
    }
}
