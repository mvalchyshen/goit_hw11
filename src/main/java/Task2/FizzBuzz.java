package Task2;

import java.util.concurrent.atomic.AtomicInteger;

public class FizzBuzz {
    private static final int END_GAME = 18;
    private volatile int number;
    private StringBuffer sb = new StringBuffer();

    public FizzBuzz() {

        this.number = 1;
        playGame();
    }

    private void playGame() {
        new Thread(() -> fizz()).start();
        new Thread(() -> buzz()).start();
        new Thread(() -> fizzBuzz()).start();
        new Thread(() -> numberFlow()).start();
        System.out.println("GAME BEGINS \n\n" + sb);

    }

    public synchronized void numberFlow() {
        while (number <= END_GAME) {
            addNumberToResult(String.valueOf(number));
            if (number % 3 == 0 || number % 5 == 0) {
                isWaiting();
            }
        }
    }

    public synchronized void fizz() {
        while (number <= END_GAME) {
            if (number % 3 == 0 && number % 5 != 0) {
                addNumberToResult("fizz");
            } else isWaiting();
        }
    }

    public synchronized void buzz() {
        while (number <= END_GAME) {
            if (number % 5 == 0 && number % 3 != 0) {
                addNumberToResult("buzz");
            } else isWaiting();
        }
    }

    public synchronized void fizzBuzz() {
        while (number <= END_GAME) {
            if (number % 15 == 0) {
                addNumberToResult("fizzbuzz");
            } else isWaiting();
        }
    }

    private void isWaiting() {
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private synchronized void addNumberToResult(String numberIs) {
        sb.append(String.valueOf(numberIs));
        number++;
        notifyAll();
    }

}
