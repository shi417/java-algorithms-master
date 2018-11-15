package algorithms.sorting.quick_sort;

/**
 * @Author: shaohan
 * @Date: 2018/11/16 00:56
 * @Description: 快速排序
 * <p>
 * 总：1.和归并排序一样，基于分治思想
 * 2.不稳定排序
 * 3.是原地排序
 */
public class QuickSort {
    public static void quickSort(int[] a, int start, int end) {
        if (start < end) {
            int parpatition = getParpatiton(a, start, end);
            quickSort(a, start, parpatition - 1);
            quickSort(a, parpatition + 1, end);
        }
    }

    public static int getParpatiton(int[] a, int start, int end) {

        int first = start;
        int last = end;
        int x = a[first];
        while (first < last) {
            while (first < last && a[last] > x) {
                last--;
            }
            if (first < last) {
                a[first++] = a[last];
            }
            while (first < last && a[first] < x) {
                first++;
            }
            if (first < last) {
                a[last--] = a[first];
            }
        }
        a[first] = x;
        return first;

    }
}
