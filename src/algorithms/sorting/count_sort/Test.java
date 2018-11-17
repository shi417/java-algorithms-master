package algorithms.sorting.count_sort;

import java.util.Arrays;

/**
 * @author : sh
 * @date : 2018/11/17 0017 21:34
 * @description :
 */
public class Test {
    @org.junit.Test
    public void test() {
        CountingSort sort = new CountingSort();
        int[] a = {7,4,4,1,0};
        sort.countingSort(a, a.length);
        System.out.println(Arrays.toString(a));
    }

}
