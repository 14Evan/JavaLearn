package learn.java.sort;

public class SortAL {

    public static void main(String[] args) {

        bubbleSort();

        selectionSort();

        insertionSort();
    }

    static int[] arr = { 1, 20, 45, 23, 0, 4, 78, 9, 70 };

    public static void bubbleSort() {
        System.out.println("this is bubbleSort");

        int length = arr.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1]; // 元素交换
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        for (int i = 0; i < length - 1; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void selectionSort() {
        System.out.println("this is selectionSort");

        int length = arr.length;
        int minIndex = 0;
        int temp = 0;
        for (int i = 0; i < length - 1; i++) {

            minIndex = i;

            for (int j = i + 1; j < length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }

        for (int i = 0; i < length - 1; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void insertionSort() {
        System.out.println("this is insertionSort");

        int length = arr.length;
        int preIndex = 0;
        int current = 0;
        for (int i = 1; i < length; i++) {
            preIndex = i - 1;
            current = arr[i];

            while (preIndex >= 0 && arr[preIndex] > current) {
                arr[preIndex + 1] = arr[preIndex];
                preIndex--;
            }

            arr[preIndex + 1] = current;
        }

        for (int i = 0; i < length - 1; i++) {
            System.out.println(arr[i]);
        }
    }
}
