package algorithms.sorting.heap_sort;

import java.util.Arrays;

/**
 * @Author: shaohan
 * @Date: 2018/9/26 20:23
 * @Description:
 */
public class Test {
    @org.junit.Test
    public void test() {
        Integer[] arr = {1,2,4,34};
        arr = HeapSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
