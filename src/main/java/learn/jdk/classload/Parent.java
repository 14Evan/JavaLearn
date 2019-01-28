package learn.jdk.classload;

public class Parent {

    private static String staticchar = "parent";

    private static int intdefa;

    public Parent() {
        System.out.println("new parent");
    }

    static {
        System.out.println("static area in parent");
    }

    static void staticMethodInParent() {
        System.out.println("static method in parent");
    }

    public void test() {
        System.out.println("test method to parent print");
    }

}
