package learn.jdk;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class CountDownLatchDemo {

    static CountDownLatch downLatch = new CountDownLatch(5);
    static AtomicInteger sotckNo = new AtomicInteger(5);

    public static void main(String args[]) {

        new Thread(new Thre()).start();
        new Thread(new Thre()).start();
        new Thread(new Thre()).start();
        new Thread(new Thre()).start();
        new Thread(new Thre()).start();

        try {
            downLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("end done");

    }

    static class Thre implements Runnable {
        public void run() {
            System.out.println("run here");
            System.out.println(sotckNo.decrementAndGet());
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            downLatch.countDown();
        }
    }
}


