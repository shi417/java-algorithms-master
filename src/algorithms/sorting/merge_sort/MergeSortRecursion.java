package algorithms.sorting.merge_sort;

import java.util.Arrays;

/**
 * @Author: shaohan
 * @Date: 2018/10/19 09:57
 * @Description:
 */
public class MergeSortRecursion {

    public static void mergeSort(int[] arr) {
        divideArray(arr, 0, arr.length - 1);
    }

    /**
     * 分
     *
     * @param arr
     * @param start
     * @param end
     */
    public static void divideArray(int[] arr, int start, int end) {
        if (start == end) {
            return;
        }
        int mid = (start + end) / 2;
        divideArray(arr, start, mid);
        divideArray(arr, mid + 1, end);
        mergeArray(arr, start, mid, end);
    }

    /**
     * 合
     *
     * @param arr
     * @param start
     * @param mid
     * @param end
     */
    public static void mergeArray(int[] arr, int start, int mid, int end) {
        int len = end - start + 1;
        int i = start;
        int j = mid + 1;
        int help[] = new int[len];
        int index = 0;
        while (i < mid + 1 && j < end + 1) {
            help[index++] = arr[i] < arr[j] ? arr[i++] : arr[j++];
        }
        while (i < mid + 1) {
            help[index++] = arr[i++];
        }
        while (j < end + 1) {
            help[index++] = arr[j++];
        }
        for (int k = 0; k < len; k++) {
            arr[start++] = help[k];
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 2, 36, 78, 45, 12, 98, 42, 1, 65, 12, 98, 43, 16};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
