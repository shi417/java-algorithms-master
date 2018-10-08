package algorithms.math.primality_test;

import java.util.Scanner;

/**
 * @Author: shaohan
 * @Date: 2018/9/24 11:35
 * @Description: 素数
 * 规定1不是素数
 */
public class Primality {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int n = scanner.nextInt();
            boolean f = checkIsPrimality(n);
            System.out.println(f);
        }
    }

    public static boolean checkIsPrimality(int n) {
        if (n <= 1) {
            return false;
        } else if (n <= 3) {
            return true;
        } else {
            int m = (int) Math.sqrt(n);
            for (int i = 2; i <= m; i++) {
                if ((n % m) == 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
