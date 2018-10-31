package task_1;

import java.io.File;

public class Task_1 {
    static Encoder test;

    public static void main(String[] args) throws Exception {
        File file = new File("src/main/java/GitMavenHomework/resources/user_1.csv");
        Input test = new Input(file);
        test.start();
    }
}
