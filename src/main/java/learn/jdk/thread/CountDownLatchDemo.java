package learn.jdk.thread;

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
            downLatch.await(); // 只有当减少5次后，才会跳过该阻塞语句
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


