package task_9;

import java.time.LocalTime;

public class MessageThread extends Thread{
    @Override
    public void run() {
        try {
            System.out.println("This is the message displayed every 10 seconds.");
            Thread.sleep(10000);
            run();
        } catch (InterruptedException error) {
        }
    }
}
