package algorithms.math.fibonacci;

/**
 * @Author: shaohan
 * @Date: 2018/9/23 21:36
 * @Description: 斐波那契数
 */
public class Fibonacci {
    /**
     * 默认大小
     */
    private static final int DEFAULT_LENGTH = 7;
    /**
     * 临界条件下的数组
     */
    private static final int[] DEFAULT_ARR = {1};

    private int[] arr;

    public int[] getArr() {
        return arr;
    }

    public void setArr(int[] arr) {
        this.arr = arr;
    }

    public Fibonacci(){
        arr = new int[DEFAULT_LENGTH];
        arr[0] = arr[1] = 1;
    }
    public Fibonacci(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException();
        }
        if (i == 1) {
            arr = DEFAULT_ARR;
        } else {
            arr = new int[i];
            arr[0] = arr[1] = 1;
        }
    }

    /**
     * 得到指定长度的斐波那契数列
     */
    public void calculate() {
        for (int i = 2; i < arr.length; i++) {
            arr[i] = arr[i - 1] + arr [i -2];
        }
    }

    /**
     * 得到指定位置的斐波那契数
     * @param n
     * @return
     */
    public int getFibonacci(int n) {
        if (n < arr.length && arr[n] != 0) {
            return arr[n];
        } else {
            if (n == 0 || n == 1) {
                return 1;
            } else {
                return getFibonacci(n - 1) + getFibonacci(n - 2);
            }
        }
    }
}
