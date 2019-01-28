package learn.jdk.thread;

public class RunAndStartDiff {

    public static void main(String[] args) {

        System.out.println("main enter"); // 线程1
        Threadd threadd = new Threadd();
        threadd.run();                    // 仍然是线程1
//        new Thread(threadd).start();      // 线程2
        System.out.println("main end");   // 线程1
    }
}

class Threadd implements Runnable{

    @Override
    public void run() {
        System.out.println("thread begin");
        try {
            Thread.sleep(2000); // 线程1，被阻塞2秒
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("thread end");
    }

}

