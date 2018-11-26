package task_2;

import javafx.util.Pair;
import org.omg.CORBA.INTERNAL;

import javax.swing.*;
import java.util.*;

public class Matrix {
    private ArrayList<ArrayList<Integer>> matrix = null;
    private Integer height = null, width = null;

    private Integer correctInput(){
        Integer res;
        Scanner in = new Scanner(System.in);
        try{
            res = in.nextInt();
        } catch (Exception incorrectInput){
            System.out.println("Input is invalid. Try again!");
            res = correctInput();
        }
        return res;
    }

    public void initMatrix(){
        System.out.println("Please, enter the height of the matrix:");
        this.height = correctInput();
        System.out.println("Please, enter the width of the matrix:");
        this.width = correctInput();
        matrix = new ArrayList<>(this.height);
        for(int i = 0; i < this.height; i++) {
            matrix.add(i, new ArrayList<Integer>(this.width));
            System.out.printf("\n%s\n", "Enter elements of the first row:");
            for( int j = 0; j < this.width; j++){
                System.out.printf("%s%d;%d%s", "Enter the element at the position (", i, j, "): ");;
                matrix.get(i).add(j, correctInput());
            }
        }
    }

    public void printMatrix(){
        for(int i = 0; i < this.height; i++) {
            for( int j = 0; j < this.width; j++){
                System.out.printf("%d ", matrix.get(i).get(j));
            }
            System.out.println();
        }
    }

    ///
    public static <K, V> void printMap(Map<K, V> map) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            System.out.println("Key : " + entry.getKey()
                    + " Value : " + entry.getValue());
        }
    }

    ///

    public void sortTheRows(){
        ArrayList<Integer> rowSum = new ArrayList<>(this.height);
        for(int i = 0; i < this.height; i++){
            rowSum.add(i, 0);
            for(int j = 0; j < this.width; j++){
                rowSum.set(i, rowSum.get(i) + this.matrix.get(i).get(j));
            }
        }
        /*
        for (Integer elem: rowSum) {
            System.out.println(elem);
        }
        */
        Map<Integer, Integer> rows = new TreeMap<Integer, Integer>(Collections.reverseOrder());
        for(int i = 0; i < this.height; i++){
            rows.put(rowSum.get(i), i);
        }
        System.out.println("Test");
        Matrix res = new Matrix();
        //res.height = 0;
        for (Map.Entry<Integer, Integer> entry : rows.entrySet()) {
            res.matrix = new ArrayList<>(this.height);
            res.width = this.width;
            res.matrix.add(this.matrix.get(entry.getValue()));
            res.height++;
            this.matrix = res.matrix;

            for(int i = 0; i < res.height; i++) {
                for( int j = 0; j < res.width; j++){
                    System.out.printf("%d ", res.matrix.get(i).get(j));
                }
                System.out.println();
            }
        }


        this.matrix = res.matrix;
        for(int i = 0; i < res.height; i++) {
            for( int j = 0; j < res.width; j++){
                System.out.printf("%d ", res.matrix.get(i).get(j));
            }
            System.out.println();
        }
        //printMap(rows);
    }

    public static void main(String[] args) {
        Matrix table = new Matrix();
        table.initMatrix();
        table.sortTheRows();
        //table.printMatrix();
    }

}
