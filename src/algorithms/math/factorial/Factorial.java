package algorithms.math.factorial;

import java.math.BigInteger;

/**
 * @Author: shaohan
 * @Date: 2018/9/23 21:24
 * @Description: 阶乘
 */
public class Factorial {
    public BigInteger calculate(int n) {
        if (n < 1) {
            throw new IllegalArgumentException();
        }
        if (n == 1) {
            return new BigInteger(String.valueOf(1));
        }else {
            return calculate(n - 1).multiply(new BigInteger(String.valueOf(n)));
        }
    }
}
