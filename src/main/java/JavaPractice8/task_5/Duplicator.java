package task_5;

import task_4.Reverse;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.lang.*;


public class Duplicator<E> /*extends Reverse<Double>*/ {
    private ListIterator<Double> it;

    private ListIterator makeIterator(List<Double> lst) {
        ListIterator<Double> it = lst.listIterator();
        while( it.hasNext() ){
            it.next();
        }
        return it;
    }

    private void outputNewPart(List<Double> result, ListIterator<Double> it) {
        try {
            System.out.println(it.next());
            outputNewPart(result, it);
        } catch (NoSuchElementException error) {
            System.out.println("List has been printed.");
        }
    }

    private void outputDefaultList(List<Double> lst, ListIterator<Double> it){
        try {
            System.out.println(it.next());
            outputDefaultList(lst, it);
        } catch (NoSuchElementException error) {
        }
    }

    private ArrayList<Double> dublicatedPositive(List<Double> lst, ArrayList<Double> result, ListIterator<Double> it){
        try {
            Double pos = it.previous();
            if (pos.compareTo(new Double(0)) > 0) {
                result.add(pos);
            }
            dublicatedPositive(lst, result, it);
        } catch (NoSuchElementException error) {
            it = lst.listIterator();
            outputDefaultList(lst, it);
        }
        return result;
    }

    public void printModifiedList(List<Double> lst){
        ArrayList<Double> result = new ArrayList<>();
        result = dublicatedPositive(lst, result, makeIterator(lst));
        it = result.listIterator();
        outputNewPart(result, it);
    }

    public static void main(String[] args) {
        List<Double> lst = new ArrayList<Double>();
        lst.add(new Double(1.0));
        lst.add(new Double(-2.5));
        lst.add(new Double(3.3));
        lst.add(new Double(-8.7));
        lst.add(new Double(5.4));
        Duplicator<Double> rev = new Duplicator<>();
        rev.printModifiedList(lst);
    }

}
