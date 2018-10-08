package algorithms.math.least_common_multiple;

import algorithms.math.euclidean_algorithm.Euclidean;

/**
 * @Author: shaohan
 * @Date: 2018/9/24 12:19
 * @Description: 最大公倍数
 */
public class LCM {
    public static void main(String[] args) {
        int res = lcm(9, 6);
        System.out.println(res);
    }

    public static int lcm(int i, int i1) {
        int product = i * i1;
        return product / Euclidean.gcd(i, i1);
    }
}
