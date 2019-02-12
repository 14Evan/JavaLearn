package learn.java.pattern;

import java.io.Serializable;

public class SingletonStaticInnerClass {

    private SingletonStaticInnerClass() {

    }

    // 静态内部类
    // 静态内部类虽然保证了单例在多线程并发下的线程安全性，但是在遇到序列化对象时，默认的方式运行得到的结果就是多例的
    private static class InnerClass {
        private static SingletonStaticInnerClass instance = new SingletonStaticInnerClass();
    }

    public static SingletonStaticInnerClass getInstance() {
        return InnerClass.instance;
    }


    public static void main(String[] args) {
        SingletonStaticInnerClass class1 = getInstance();

        SingletonStaticInnerClass class2 = getInstance();

        System.out.println(class1 == class2);

    }

}
