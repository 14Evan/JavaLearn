package learn.jdk.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListSearchRemove {

    private static final String ONE = "1";
    private int i;

    /**
     * 初始化一个数组，后续遍历使用
     *
     * @return
     */
    private static List<String> initOldList() {
        List<String> oldList = new ArrayList<String>();
        oldList.add(ONE);
        oldList.add(ONE);
        oldList.add(ONE);
        oldList.add(ONE);
        oldList.add(ONE);
        oldList.add(ONE);
        oldList.add("2");
        oldList.add("2");
        return oldList;
    }

    /**
     * 使用一个新的数组，把老的数组中符合条件的放入新数组
     */
    private static void removeOneInOldList1() {
        System.out.println("removeOneInOldList1");
        List<String> oldList = initOldList();
        List<String> newList = new ArrayList<String>();
        for (String ones : oldList) {
            if (!ONE.equals(ones)) {
                newList.add(ones);
            }
        }
        newList.forEach(System.out::println);
    }

    /**
     * 老数组得到迭代器，迭代器remove，就完成了oldList的筛选
     */
    private static void removeOneInOldList2() {
        System.out.println("removeOneInOldList2");
        List<String> oldList = initOldList();
        Iterator<String> oldIterator = oldList.iterator();
        while (oldIterator.hasNext()) {
            if (ONE.equals(oldIterator.next())) {
                oldIterator.remove();
            }
        }
        oldList.forEach(System.out::println);
    }

    /**
     * java 8 removeIf 函数 lambda表达式
     */
    private static void removeOneInOldList3() {
        System.out.println("removeOneInOldList3");
        List<String> oldList = initOldList();
        // oldList.remove(ONE); remove只能remove 1个
        oldList.removeIf(test -> test.contains("1"));

        oldList.forEach(System.out::println);
    }

    /**
     * 通过for i的方式，而不是removeOneInOldList1
     */
    private static void removeOneInOldList4() {
        System.out.println("removeOneInOldList4");
        List<String> oldList = initOldList();
        for (int i = 0; i < oldList.size(); i++) {
            if(ONE.equals(oldList.get(i))){
                oldList.remove(i);
                i--; // 当前位置元素移除，下标减1
            }
        }
        oldList.forEach(System.out::println);
    }

    public static void main(String[] args) {

        removeOneInOldList1();
        removeOneInOldList2();
        removeOneInOldList3();
        removeOneInOldList4();

    }

}
