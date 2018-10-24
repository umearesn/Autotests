package task_7;

import java.util.ArrayList;
import java.util.List;
import java.lang.String;

public class ListOfStrings {
    public void printList(List<String> lst) {
        for (int i = 3; i < 6; i++) {
            int length = i;
            System.out.printf("%d", length);
            lst.stream().filter(str -> str.length() == length).forEach(str -> System.out.printf(" | %s", str));
            System.out.printf("\n");
        }
    }

    public static void main(String[] args) {
        List<String> lst = new ArrayList<String>();
        lst.add(new String("t"));
        lst.add(new String("te"));
        lst.add(new String("tes"));
        lst.add(new String("est"));
        lst.add(new String("e"));
        lst.add(new String("s"));
        lst.add(new String("ers"));
        lst.add(new String("test"));
        lst.add(new String("teste"));
        lst.add(new String("ars"));
        ListOfStrings mod = new ListOfStrings();
        mod.printList(lst);
    }
}

