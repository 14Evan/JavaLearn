package learn.java.pattern;

public class SingletonLazy {

    private volatile static SingletonLazy instance = null;

    private SingletonLazy() {

    }

    private static SingletonLazy getInsatnce() {
        if(instance == null){
            synchronized (SingletonLazy.class){
                if(instance == null){
                    instance = new SingletonLazy();
                }
            }
        }
        return instance;
    }

}
