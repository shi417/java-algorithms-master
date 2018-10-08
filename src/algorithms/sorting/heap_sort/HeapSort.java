package algorithms.sorting.heap_sort;

import data_structure.heap.MaxHeap;

/**
 * @Author: shaohan
 * @Date: 2018/9/26 20:17
 * @Description:堆排序
 */
public class HeapSort {
    public static Integer[] sort(Integer[] arr) {
        MaxHeap maxHeap = new MaxHeap(arr);
        System.out.println(maxHeap.toString());
        Integer[] brr = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            brr[i] = (Integer) maxHeap.pool();
        }
        return brr;
    }
}
