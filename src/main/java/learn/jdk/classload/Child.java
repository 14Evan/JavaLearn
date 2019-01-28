package learn.jdk.classload;

public class Child extends Parent {

    private static String chichar ="child";

    public Child() {
        System.out.println("new child");
    }

    static {
        System.out.println("static area in child");
    }

    static void staticMethodInChild(){
        System.out.println("static method in child");
    }

    public void childtest(){
        System.out.println("child print");
    }

}
