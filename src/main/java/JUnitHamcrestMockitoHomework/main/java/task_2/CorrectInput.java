package task_2;

import java.util.Scanner;

public class CorrectInput {

    public int correctInput(){
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

}
