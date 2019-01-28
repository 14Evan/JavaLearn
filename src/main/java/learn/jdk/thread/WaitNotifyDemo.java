package learn.jdk.thread;

public class WaitNotifyDemo {

    public static void main(String[] args) {
        new Thread(new Thread1()).start();
        new Thread(new Thread2()).start();
    }

    private static class Thread1 extends Thread {
        @Override
        public void run() {
            synchronized (WaitNotifyDemo.class) {
                System.out.println("enter thread1...");

                try {
                    WaitNotifyDemo.class.wait(); // Testwait.class的锁释放，并让出cpu
                    // wait方法是配合在synchronized方法内使用
                    // sleep 只是让出cpu但是不会放弃拥有的锁
                    WaitNotifyDemo.class.notify();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("thread1 is going on ....");
            }
        }
    }

    private static class Thread2 implements Runnable {
        @Override
        public void run() {
            synchronized (WaitNotifyDemo.class) {
                System.out.println("enter thread2...");

                try {
                    WaitNotifyDemo.class.notify(); // 唤醒17行代码，
                    // 但是17行想往下执行，需要先得到Testwait.class的锁
                    WaitNotifyDemo.class.wait();     // 等待2秒，锁还是持有中
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread2 is going on ....");
            }
        }
    }
}
