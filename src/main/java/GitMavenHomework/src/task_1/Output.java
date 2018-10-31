package task_1;

import java.io.*;

public class Output extends Thread {
    private String result;
    private File aim;

    Output(String res, File aim) throws Exception {
        this.result = res;
        this.aim = aim;
    }

    @Override
    public void run(){
        try {
            FileWriter writer = new FileWriter(aim, true);
            writer.append("\n" + this.result);
            writer.flush();
            writer.close();
        } catch (Exception error) {}
    }
}