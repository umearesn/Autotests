package task_4;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class Reverse<E> {
    private ListIterator<E> it;
    private ListIterator makeIterator(List<E> lst) {
        ListIterator<E> it = lst.listIterator();
        while( it.hasNext() ){
            it.next();
        }
        return it;
    }

    private void listReversed(List<E> lst, ListIterator<E> it) {
        try {
            System.out.println(it.previous());
            listReversed(lst, it);
        } catch (NoSuchElementException error) {
            System.out.println("List has been printed.");
        }
    }

    public void printReversedList(List<E> lst){
        listReversed(lst, makeIterator(lst));
    }

    public static void main(String[] args) {
        List<Integer> lst = new ArrayList<Integer>();
        lst.add(new Integer(1));
        lst.add(new Integer(2));
        lst.add(new Integer(3));
        lst.add(new Integer(8));
        lst.add(new Integer(5));
        Reverse<Integer> rev = new Reverse<Integer>();
        rev.printReversedList(lst);
    }
}
