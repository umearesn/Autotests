package task_9;

import java.time.LocalTime;

public class TimeThread extends Thread {
    @Override
    public void run() {
        try {
            System.out.println(LocalTime.now());
            TimeThread.sleep(2000);
            run();
        } catch (InterruptedException error) {}
    }
}
