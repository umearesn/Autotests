package task_9;

public class TimeAndMessage {
    static TimeThread curTime;
    static MessageThread printMessage;

    public static void main(String[] args) {
        curTime = new TimeThread();
        printMessage = new MessageThread();
        curTime.start();
        printMessage.start();
    }
}
