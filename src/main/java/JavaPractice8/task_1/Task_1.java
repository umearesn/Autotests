package task_1;

public class Task_1 {
    public static void addNew(int result, int n) {
        int test = 0;
        try  {
            test = 1 / n;
            result += n;
            n--;
            addNew(result, n);
        } catch (RuntimeException e) {
            System.out.println(result);
        }
    }

    public static void main(String[] args) {
        int n = 10;
        int result = 0;
        addNew(result, n);
    }
}

