package algorithms.search.binary_search;

/**
 * @auther: sh
 * @date: 2018/11/17 0017 23:13
 * @description: 二分查找
 * 总结：1.时间复杂度O(logn) 性能十分强悍
 *      2.应用场景很有局限性：依赖顺序表结构（数组），依赖有序数据
 *
 */
public class BinarySearch {
    /**
     * 最简单的二分查找（没有重复数据）
     * @param arr 数组
     * @param value 要查找的值
     * @param length 数组长度
     *
     */
    public int binarySearch(int[] arr, int value, int length) {
        int low = 0;
        int high = length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] == value) {
                return mid;
            }
            if (arr[mid] > value) {
                high = --mid;
            }
            if (arr[mid] < value) {
                low = ++mid;
            }
        }
        return -1;
    }
}
