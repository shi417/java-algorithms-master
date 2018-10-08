package algorithms.sorting.merge_sort;

import java.util.Arrays;

/**
 * @Author: shaohan
 * @Date: 2018/9/28 17:18
 * @Description:
 */
public class Test {
    @org.junit.Test
    public void test() {
        int[] arr = {12,3,4,4,5,43,14,23,4,6,6,4,2,4,2,4,5};
        MergeSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
