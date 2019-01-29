package learn.jdk.classload;

public class LoadDemo {

    public static void main(String[] args) {

        /*
        * 1 父类静态代码块
        * 2 子类静态代码块
        * 3 父类构造方法
        * 4 子类构造方法
        * 5 子类普通方法
        * 6 重写父类的方法，则打印重写后的方法
        *
        * */
        Child child = new Child();
        child.childtest();

//        System.out.println(Child.chichar);
//
//        Child.staticMethodInChild();
    }
}
