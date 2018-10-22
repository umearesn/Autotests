package com.akhmetyanov.task_6;

import java.lang.String;

public class Student {
    private String name;
    private String department;

    Student(String name, String department){
        this.name = name;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }
}
