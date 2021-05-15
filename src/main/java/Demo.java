import Task1.FirstThread;
import Task1.SecondThread;
import Task2.FizzBuzz;

public class Demo {
    public static void main(String[] args) {
        Thread one = new Thread(new FirstThread());
        Thread two = new Thread(new SecondThread());
        one.start();
        two.start();
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        one.interrupt();
        two.interrupt();

        new FizzBuzz();
    }
}
