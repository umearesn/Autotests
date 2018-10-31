package task_1;

import java.io.*;

public class Output extends Thread {
    private static String path = "src/main/java/GitMavenHomework/results/resulted_data.txt";
    private String result;

    Output(String res) throws Exception {
        this.result = res;
    }

    @Override
    public void run(){
        try {
            FileWriter writer = new FileWriter(this.path, true);
            writer.append(this.result);
            writer.flush();
            writer.close();
        } catch (Exception error) {}
    }
}