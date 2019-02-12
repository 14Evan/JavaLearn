package learn.java.twosum;

import java.util.*;

public class TwoSum {

    public static void main(String[] args) {
        int[] arr = {100, 67, 89, 67, 45, 67, 55};

        System.out.println(Arrays.toString(sum2(arr, 100)));

        List<Integer> resList = Arrays.asList(sum2(arr, 100));

        for(int i = 0; i< resList.size(); i++){
            System.out.println(resList.get(i));
        }
    }

    public static Integer[] sum2(int arr[], int targetSum) {
        Integer[] res = new Integer[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(targetSum - arr[i])) {
                res[0] = map.get(targetSum - arr[i]);
                res[1] = i;
                break;
            }
            map.put(arr[i], i);
        }
        return res;
    }
}
