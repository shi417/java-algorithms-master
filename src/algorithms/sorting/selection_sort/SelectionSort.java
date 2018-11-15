package algorithms.sorting.selection_sort;

/**
 * @Author: shaohan
 * @Date: 2018/9/26 19:16
 * @Description: 选择排序
 * 总结：
 *  *      1.是原地排序
 *  *      2.是不稳定排序  5，8，5，2，9
 *  *      3.时间复杂度 最好 O(n^2)  最坏O(n^2) 平均O(n^2)
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
