package algorithms.sorting.selection_sort;

import java.util.Arrays;

/**
 * @Author: shaohan
 * @Date: 2018/9/26 19:32
 * @Description:
 */
public class Test {
    @org.junit.Test
    public void test() {
        int arr[] = {9,8,7,65,4,32,1};
        SelectionSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
