package algorithms.sorting.bubble_sort;

/**
 * @Author: shaohan
 * @Date: 2018/9/25 20:27
 * @Description: 冒泡排序
 *
 * 总结：
 *    1.可以通过设置一个标志来优化冒泡排序，见代码
 *    2.是原地排序
 *    3.是稳定排序
 *    4.时间复杂度 最好 O(n)  最坏O(n^2) 平均O(n^2)
 *
 */
public class BubbleSort {
    /**
     * 通过这个标志来优化冒泡排序
     * 如果在一轮冒泡中没有发生过sawp，说明已经排好序了
     */
    private static boolean flag = true;

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            flag = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr,j);
                }
            }
            if (!flag) {
                break;
            }
        }
    }

    private static void swap(int[] arr, int j) {
        int temp = arr[j];
        arr[j] = arr[j + 1];
        arr[j + 1] = temp;
        flag = true;
    }
}
