package algorithms.sorting.insertion_sort;

import java.util.Arrays;

/**
 * @Author: shaohan
 * @Date: 2018/9/26 19:52
 * @Description:
 */
public class Test {
    @org.junit.Test
    public void test() {
        int[] arr = {9,8,7,6,5,4,1,5,7,5,22,54,5,45,4,58};
        InsertSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
