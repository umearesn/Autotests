package com.akhmetyanov.task_6;

import java.util.*;

public class Filter {
    public void getPopularDept(List<Student> lst){
        lst.stream().sorted(new StudentsComparator()).forEach(p -> System.out.printf("%s: %s \n", p.getName(), p.getDepartment()));
        /*Map depts = new HashMap<String, Integer>();
        ListIterator<Student> it = lst.listIterator();
        try {
            Student curr = it.next();
            if (depts.get(curr.getDepartment()) == null){
                depts.put(curr.getDepartment(), 1);
            } else {
                depts.put(curr.getDepartment(), depts.get(curr.getDepartment() + 1));
            }
        } catch (NoSuchElementException error) {
            String top1;
            String top2;
            String top3;
            Entry<String, Integer> maxEntry = Collections.max(depts.entrySet())
        }*/
    }

    public static void main(String[] args) {
        List<Student> lst = Arrays.asList(
                new Student("Arslan", "DIHT"),
                new Student("Andrew", "DIHT"),
                new Student("Robert", "DPFE"),
                new Student("Noname", "DDDD"),
                new Student("Someone", "DIHT")
        );
        Filter f = new Filter();
        f.getPopularDept(lst);
    }
}
