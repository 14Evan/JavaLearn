package learn.jdk.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class CallableDemo {

    public static void main(String[] args) {
        try {
            CallableClass callableClass = new CallableClass();
            FutureTask<Integer> task = new FutureTask<>(callableClass);
            new Thread(task).start();

            System.out.println(1111);

            Integer sum = task.get();
            System.out.println(sum);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

class CallableClass implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        Thread.sleep(2000);
        int sum = 0;
        for (int i = 0; i <= 100000; i++) {
            sum = i;
        }
        return sum;
    }
}
