package task_1;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.StrictMath.sqrt;

public class PrimeNumbers {

    public static ArrayList<Integer> filterNumbers(int n){
        ArrayList<Integer> allNumbers = new ArrayList<>();
        for(int i = 2; i <= n; i++){
            allNumbers.add(i);
        }
        for (int i = 2; i <= n; i++) {
            for (int j = i * i; j <= n && i <= sqrt(n); j += i) {
                allNumbers.remove(new Integer(j));
            }
        }
        return allNumbers;
    }

    private static void printPrimeNumbers(ArrayList<Integer> input){
        for (Integer i: input) {
            System.out.printf("%d ", i);
        }
    }

    public static void main(String[] args) {
        System.out.printf("%s\n", "Please, enter the upper bound of numbers:");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        printPrimeNumbers(filterNumbers(n));
    }

}
