package algorithms.sorting.count_sort;

import java.util.Arrays;

/**
 * @auther: sh
 * @date: 2018/11/16 0016 17:06
 * @description: 计数排序
 *      总结：1.线性   时间复杂度为O(n)
 *           2.可以理解为是桶排序的一种特殊情况。当要排序的n个数据所处的范围并不大（例如高考分数
 *           最高900分），比如最大值为k，就可以把数据划分为k个桶，每个桶内的数据时相同的，就可以省略
 *           桶内快排的时间。
 *           3.适用场景：数据范围不大（不是数据量）的场景。如果给非负整数之外的数据排序的话，
 *           需要先对数据进行处理。
 *           4.必然是稳定排序
 */
public class CountingSort {
    /**
     * 计数排序
     * @param arr 排序数组
     * @param n 数组长度
     */
    public void countingSort(int[] arr, int n) {
        if (n <= 1) return;
        //查找数组的范围
        int max = arr[0];
        for (int i : arr) {
            if (max < i) {
                max = i;
            }
        }
        //建立计数数组
        int[] count = new int[max + 1];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }
        //依次累加的处理计数数组
        int flag = count[0];
        for (int i = 1; i < count.length; i++) {
            count[i] += flag;
            flag = count[i];
        }
        //使用一个辅助数组，开始排序
        int[] helper = new int[n];
        for (int i = arr.length - 1; i >= 0; i--) {
            int index = count[arr[i]] - 1;
            helper[index] = arr[i];
            count[arr[i]]--;
        }
        //将结果拷贝带原数组
        System.arraycopy(helper, 0, arr, 0, n);
        System.out.println(Arrays.toString(arr));
    }

}
