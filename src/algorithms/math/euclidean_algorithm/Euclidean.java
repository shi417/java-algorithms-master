package algorithms.math.euclidean_algorithm;

import java.util.Scanner;

/**
 * @Author: shaohan
 * @Date: 2018/9/24 12:03
 * @Description: 欧几里得算法 求最大公约数
 */
public class Euclidean {
    public static void main(String[] args) {

        int res = gcd(6, 5);
        System.out.println(res);
    }

    public static int gcd(int max, int min) {
        if (min == 0) {
            return max;
        } else {
            return gcd(min, max % min);
        }
    }
}
