package wha.thread;

/**
 * Created by wwha on 17-7-5.
 */
public class MyRunnable implements Runnable {
    int value = 0;

    @Override
    public void run() {
        System.out.println("线程执行了");
    }

    public static void main(String[] args) {
        new Thread(new MyRunnable()).start();
    }
}
