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

    public Integer[] filterNumbers(int n){
        ArrayList<Integer> allNumbers = new ArrayList<>();
        for(int i = 2; i <= n; i++){
            allNumbers.add(i);
        }
        for (int i = 2; i <= n; i++) {
            for (int j = i * i; j <= n && i <= sqrt(n); j += i) {
                allNumbers.remove(new Integer(j));
            }
        }
        Integer[] res = new Integer[allNumbers.size()];
        for (int i = 0; i < allNumbers.size(); i++) {
            res[i] = allNumbers.get(i);
        }
        return res;
    }


    private static void printPrimeNumbers(Integer[] input){
        for (Integer i: input) {
            System.out.printf("%d ", i);
        }
    }

    public static void main(String[] args) {
        System.out.printf("%s\n", "Please, enter the upper bound of numbers:");
        int n = correctInput();
        PrimeNumbers prime = new PrimeNumbers();
        printPrimeNumbers(prime.filterNumbers(n));
    }

}
