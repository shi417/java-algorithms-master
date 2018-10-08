package algorithms.sorting.merge_sort;

/**
 * @Author: shaohan
 * @Date: 2018/9/28 16:46
 * @Description: 归并排序
 */
public class MergeSort {
    public static void sort(int[] arr) {
        int len = 1;
        while (len < arr.length) {
            for (int i = 0; i < arr.length; i += len << 1) {
                goSort(arr, i, len);
            }
            len = len << 1;
        }

    }

    private static void goSort(int[] arr, int start, int len) {
        int[] help = new int[len << 1];
        int frist = start;
        int second = start + len;
        int i = 0;
        while (frist < (start + len) && second < (start + len + len) && second < arr.length) {
            help[i++] = arr[frist] < arr[second] ? arr[frist++] : arr[second++];
        }
        while (frist < (start + len) && frist < arr.length) {
            help[i++] = arr[frist++];
        }
        while (second < (start + len + len) && second < arr.length) {
            help[i++] = arr[second++];
        }
        int right = start + len + len;
        int index = 0;
        while(start < arr.length && start < right) {
            arr[start++] = help[index++];
        }
    }
}
