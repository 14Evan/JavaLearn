package learn.java.pattern;

public enum SingletonEnum {

    enum1;

    private Singleton singleton;

    //枚举类的构造方法在类加载是被实例化
    private SingletonEnum(){
        singleton = new Singleton();
    }

    public Singleton getInstance(){
        return singleton;
    }

}

class Singleton{

}


