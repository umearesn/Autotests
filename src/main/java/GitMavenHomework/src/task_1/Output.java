package task_1;

import java.io.*;

public class Output extends Thread {
    private String result;
    private String aimFileName;

    Output(String res, String  aimFileName) throws Exception {
        this.result = res;
        this.aimFileName = aimFileName;
    }

    @Override
    public void run(){
        try {
            FileWriter writer = new FileWriter(
                    new File("src/main/java/GitMavenHomework/src/task_1/results/" + this.aimFileName), true);
            writer.append("\n" + this.result);
            writer.flush();
            writer.close();
        } catch (Exception error) {}
    }
}