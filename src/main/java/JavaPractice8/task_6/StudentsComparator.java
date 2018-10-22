package com.akhmetyanov.task_6;

import java.util.Comparator;

public class StudentsComparator implements Comparator<Student> {
    public int compare(Student a, Student b){
        return a.getName().compareToIgnoreCase(b.getName());
    }
}
