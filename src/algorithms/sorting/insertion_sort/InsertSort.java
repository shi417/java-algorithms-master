package algorithms.sorting.insertion_sort;

/**
 * @Author: shaohan
 * @Date: 2018/9/26 19:39
 * @Description: 插入排序
 *
 * 总结：
 *      1.是原地排序
 *      2.是稳定排序
 *      3.时间复杂度 最好 O(n)  最坏O(n^2) 平均O(n^2)
 *      4.为什么插入排序比冒泡排序更优秀呢
 *          从代码实现的角度看，冒泡排序的交换有三个赋值操作，而插入排序只有一次
 *
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
