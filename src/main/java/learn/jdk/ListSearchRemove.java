package learn.jdk;

import com.google.common.collect.Lists;
import com.sun.org.apache.xerces.internal.dom.PSVIAttrNSImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListSearchRemove {


    private static final String ONE = "1";

    public static void main(String[] args) {
        List<String> oldList = new ArrayList<String>();
        oldList.add("1");
        oldList.add("1");
        oldList.add("1");
        oldList.add("1");
        oldList.add("1");
        oldList.add("1");
        oldList.add("2");
        oldList.add("2");

        oldList.remove(ONE);

        List<String> newList = new ArrayList<String>();
        for(String ones : oldList){
            if(!ONE.equals(ones)){
                newList.add(ones);
            }
        }

        for (int i = 0; i < newList.size(); i++) {
            System.out.println(newList.get(i));
        }


        Iterator<String> oldIterator = oldList.iterator();
        while (oldIterator.hasNext()){
            if(ONE.equals(oldIterator.next())){
                oldIterator.remove();
            }
        }

        List<String> newList2 = new ArrayList<String>();

        while (oldIterator.hasNext()){
            newList2.add(oldIterator.next());
        }



        for (int i = 0; i < oldList.size(); i++) {
            System.out.println(oldList.get(i));
        }
    }

}
