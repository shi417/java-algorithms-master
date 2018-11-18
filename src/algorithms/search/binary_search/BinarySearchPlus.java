package algorithms.search.binary_search;

/**
 * @auther: sh
 * @date: 2018/11/17 0017 23:52
 * @description: 二分查找的各种变形
 * 前提：都是按从小到大的顺序排好的，并且会有重复数据
 */
public class BinarySearchPlus {
    /**
     * 基于二分查找思想  查找第一个与value相同的元素的下标
     * @param arr 数组
     * @param length 数组长度
     * @param value 查找的值
     * @return 下标
     */
    public int binarySearchForFrist(int arr[], int length, int value) {
        int low = 0;
        int high = length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] > value) {
                high = mid - 1;
            } else if (arr[mid] < value) {
                low = mid + 1;
            } else {
                if (mid == 0 || arr[--mid] != value) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    /**
     * 基于二分查找思想  查找最后一个与value相同的元素的下标
     * @param arr 数组
     * @param length 长度
     * @param value 要查找的值
     * @return 下标
     */
    public int binarySearchForLast(int arr[], int length, int value) {
        int low = 0;
        int high = length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] > value) {
                high = mid - 1;
            } else if (arr[mid] < value) {
                low = mid + 1;
            } else {
                if ((mid == length - 1) || arr[++mid] != value) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    /**
     * 基于二分查找思想  查找第一个大于等于value的元素的下标
     * @param arr
     * @param length
     * @param value
     * @return
     */
    public int binarySearchForFristX(int[] arr, int length, int value) {
        int low = 0;
        int high = length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] >= value) {
                if (mid == 0 || arr[--mid] < value) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
