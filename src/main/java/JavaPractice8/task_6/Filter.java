package task_6;

import java.util.*;

public class Filter {
    public void getPopularDept(List<Student> lst){
        lst.stream().sorted((a, b) -> a.getName().compareToIgnoreCase(b.getName()))
                .forEach(student -> System.out.printf("%s: %s \n", student.getName(), student.getDepartment()));
        Map<String, Integer> topDepts = new HashMap<>();
        lst.forEach(student -> topDepts.put(student.getDepartment(), topDepts.containsKey(student.getDepartment())
                ? topDepts.get(student.getDepartment()) + 1 : 1));
        System.out.printf("%s \n", "Top 3: ");
        topDepts.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).limit(3).forEach(pair -> System.out.printf("%s \n", pair.getKey()));
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
