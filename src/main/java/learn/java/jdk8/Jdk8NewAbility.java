package learn.java.jdk8;

import java.util.Arrays;
import java.util.List;

public class Jdk8NewAbility {


    public static void main(String[] args) {
        lambdaTest();
    }

    /**
     * Lambda表达式
     * Java 8引入了函数式接口的概念。函数式接口就是只有一个方法的普通接口。
     * java.lang.Runnable与java.util.concurrent.Callable是函数式接口最典型的例子。
     * 为此，Java 8增加了一种特殊的注解 @{@link FunctionalInterface}
     */
    public static void lambdaTest() {
        List<String> list = Arrays.asList("1", "2", "3");
        list.forEach(System.out::println);
    }

    /**
     * 接口的默认方法与静态方法
     * public interface DefaultFunctionInterface {
     *      default String defaultFunction() {
     *          return "default function";
     *      }
     * }
     *
     * public interface StaticFunctionInterface {
     *     static String staticFunction() {
     *         return "static function";
     *     }
     * }
     *
     */

    /**
     * 方法引用
     * 通常与Lambda表达式联合使用，可以直接引用已有Java类或对象的方法。
     * 般有四种不同的方法引用：
     *
     * 构造器引用。语法是Class::new，或者更一般的Class< T >::new，要求构造器方法是没有参数；
     *
     * 静态方法引用。语法是Class::static_method，要求接受一个Class类型的参数；
     *
     * 特定类的任意对象方法引用。它的语法是Class::method。要求方法是没有参数的；
     *
     * 特定对象的方法引用，它的语法是instance::method。要求方法接受一个参数，与3不同的地方在于，3是在列表元素上分别调用方法，
     * 而4是在某个对象上调用方法，将列表元素作为参数传入；
     */


    /**
     *  {@link java.util.Optional}
     * Java 8引入Optional类来防止空指针异常，Optional类最先是由Google的Guava项目引入的。
     * Optional类实际上是个容器：它可以保存类型T的值，或者保存null。
     * 使用Optional类我们就不用显式进行空指针检查了。
     *
     * /

     /**
     * Stream API是把真正的函数式编程风格引入到Java中。
     * 其实简单来说可以把Stream理解为MapReduce，
     * 当然Google的MapReduce的灵感也是来自函数式编程。
     * 她其实是一连串支持连续、并行聚集操作的元素。
     * 从语法上看，也很像linux的管道、或者链式编程，代码写起来简洁明了，非常酷帅！
     */

    /**
     * Java 8新的Date-Time API (JSR 310)受Joda-Time的影响，
     * 提供了新的java.time包，
     * 可以用来替代 java.util.Date和java.util.Calendar。
     * 一般会用到Clock、LocaleDate、LocalTime、LocaleDateTime、ZonedDateTime、Duration这些类，
     * 对于时间日期的改进还是非常不错的。
     */

}
