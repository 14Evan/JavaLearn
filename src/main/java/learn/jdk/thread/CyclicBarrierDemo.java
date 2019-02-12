package learn.jdk.thread;

import java.util.concurrent.*;

/**
 * CyclicBarrier 字面意思理解
 * Cyclic 周期性
 * Barrier，障碍物；屏障
 * 周期性的障碍物
 * 因为有CyclicBarrier.reset(); 可以重置，所以是周期性的
 *
 * new CyclicBarrier 的2个参数
 * parm1： the number of threads that must invoke {@link #await} before the barrier is tripped
 * parm2： arrierAction the command to execute when the barrier is tripped, or {@code null} if there is no action
 *
 */
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
