package algorithms.sorting.bubble_sort;

import java.util.Arrays;

/**
 * @Author: shaohan
 * @Date: 2018/9/26 19:13
 * @Description:
 */
public class Test {
    int[] arr = {9,8,7,6,5,4,3,2,1,0,0};
    @org.junit.Test
    public void tets() {
        BubbleSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
