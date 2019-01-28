package learn.jdk.thread;

import java.util.concurrent.*;

public class CyclicBarrierDemo implements Runnable {

    private static CyclicBarrier barrier = new CyclicBarrier(3, new CyclicBarrierDemo());

    private static ExecutorService executor = Executors.newFixedThreadPool(3);

    private static void executeThread() {
        for (int i = 0; i < 3; i++) {
            executor.execute(() -> {
                System.out.println("我做1个，开始" + Thread.currentThread().getName());
                try {
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println("我做1个，结束" + Thread.currentThread().getName());
            });
        }
    }

    public static void main(String[] args) {

        executeThread();
        barrier.reset();
        System.out.println("one more time");
        executeThread();

        executor.shutdown(); //非测试代码不需要shutdowm，线程池不停复用下去即可
    }

    @Override
    public void run() {
        System.out.println("3个都完成了，执行我吧");
    }
}
