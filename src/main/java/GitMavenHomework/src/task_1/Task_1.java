package task_1;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Task_1 {

    public static void main(String[] args) throws Exception {
        String name = "";
        File file = null, aim = null;
        System.out.printf("\n%s\n", "Write the name of the file that will be modified.");
        Scanner in = new Scanner(System.in);
        do{
            name = in.next();
            file = new File("src/main/java/GitMavenHomework/src/task_1/resources/" + name);
            if(!file.exists()) {
                System.out.printf("%s\n", "Can't find file " + name + "!");
            }
        } while (!file.exists());
        System.out.printf("\n%s\n", "Write the name of the file where to write the modified passwords (if such directory exists it will be rewrited!). ");
        name = in.next();
        aim = new File("src/main/java/GitMavenHomework/src/task_1/results/" + name);
        if(aim.exists()) {
            FileWriter writer = new FileWriter(aim);
            writer.write("");
        }
        System.out.printf("\n%s\n", "Are we going to encode? Press 1 to encode, 0 to decode.");
        int i = 2;
        while (i != 1 && i != 0){
            i = in.nextInt();
            if(i != 1 && i != 0){
                System.out.printf("\n%s\n", "Incorrect input. Try again!");
            }
        }
        Input test;
        if (i == 1) {
            test = new Input(file, true, aim);
        } else {
            test = new Input(file, false, aim);
        }
        test.start();
    }
}
