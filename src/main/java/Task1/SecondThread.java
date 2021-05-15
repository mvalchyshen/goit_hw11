package Task1;

public class SecondThread implements Runnable{
    private FirstThread firstThread;
    @Override
    public void run() {
        Thread fiveSecondsThread = Thread.currentThread();
        while (!fiveSecondsThread.isInterrupted()) {
            if (fiveSecondsPause()) {
                System.out.println("Five seconds passed");
            }
        }

    }

    private synchronized boolean fiveSecondsPause() {
        for (int i = 0; i < 5; i++) {
            try {
                wait(1000);
            } catch (InterruptedException e) {
                return false;
            }
        }
        notifyAll();
        return true;

    }

}
