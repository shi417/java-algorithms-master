package algorithms.sorting.selection_sort;

/**
 * @Author: shaohan
 * @Date: 2018/9/26 19:16
 * @Description: 选择排序
 */
public class SelectionSort {
    public static void sort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            if (min != i) {
                swap(arr, min, i);
            }
        }
    }
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}
