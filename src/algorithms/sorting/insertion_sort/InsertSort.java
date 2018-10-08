package algorithms.sorting.insertion_sort;

/**
 * @Author: shaohan
 * @Date: 2018/9/26 19:39
 * @Description: 插入排序
 */
public class InsertSort {
    public static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int cur = arr[i];
            int j = i - 1;
            while (j > -1 && arr[j] > cur) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = cur;
        }
    }

}
