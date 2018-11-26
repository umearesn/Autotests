package task_1;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.StrictMath.sqrt;

public class PrimeNumbers {

    private static int correctInput(){
        int res;
        Scanner in = new Scanner(System.in);
        try{
            res = in.nextInt();
        } catch (Exception incorrectInput){
            System.out.println("Input is invalid. Try again!");
            res = correctInput();
        }
        return res;
    }

    public static ArrayList<Integer> filterNumbers(){
        System.out.printf("%s\n", "Please, enter the upper bound of numbers:");
        int n = correctInput();
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
        printPrimeNumbers(filterNumbers());
    }

}
