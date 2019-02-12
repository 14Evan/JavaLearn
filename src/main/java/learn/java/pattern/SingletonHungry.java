package learn.java.pattern;

public class SingletonHungry {

    private final static SingletonHungry instance = new SingletonHungry();

    private SingletonHungry() {

    }

    private static SingletonHungry getInsatnce() {
        return instance;
    }

}
