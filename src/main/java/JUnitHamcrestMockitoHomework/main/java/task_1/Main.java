package task_1;

import java.util.Scanner;

public class Main {

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
