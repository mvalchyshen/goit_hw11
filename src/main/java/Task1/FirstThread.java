package Task1;

public class FirstThread implements Runnable{
    private int time = 0;
    @Override
    public void run() {
        Thread oneSecondThread = Thread.currentThread();
        while (!oneSecondThread.isInterrupted()) {
            if (oneSecondPassed()) {
                time++;
                System.out.println("Time passed : " + time);
            }
        }
    }

    private synchronized boolean oneSecondPassed() {
        boolean oneSecondPassed = false;
        try {
            wait(1000);
        } catch (InterruptedException e) {
            return false;
        }
        notifyAll();
        return true;
    }
}
