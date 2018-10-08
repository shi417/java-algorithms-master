package algorithms.math.is_power_of_two;

/**
 * @Author: shaohan
 * @Date: 2018/9/25 19:00
 * @Description:  判断是非是2的次方
 */
public class IsPowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if (n < 1) {
            return false;
        }
        while (n != 1) {
            if ((n % 2) != 0) {
                return false;
            }
            n = n/2;
        }
        return true;
    }

    public boolean isPowerOfTwoByBits(int n) {
        if (n < 1) {
            return false;
        }
        n = n & (n - 1);
        return n == 0;
    }
}
