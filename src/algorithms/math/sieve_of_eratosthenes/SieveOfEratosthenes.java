package algorithms.math.sieve_of_eratosthenes;

import algorithms.math.primality_test.Primality;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author: shaohan
 * @Date: 2018/9/24 12:37
 * @Description: 素数筛
 */
public class SieveOfEratosthenes {

    public ArrayList<Integer> sieveOfEratosthenes(int[] res) {
        Arrays.sort(res);
        int max = res[res.length - 1];
        if (max < 0) {
            throw new IllegalArgumentException();
        }
        int[] flag = new int[max + 1];
        if (flag.length > 2) {
            for (int i = 0; i < res.length - 1; i++) {
                flag[res[i]] = 1;
            }
        }
        ArrayList<Integer> list = new ArrayList();
        for (int i = 2; i <= max; i++) {
            if (flag[i] == 1) {
                if (Primality.checkIsPrimality(i)) {
                    list.add(i);
                }
            }
            int next = i * i;
            while (next <= max) {
                flag[next] = 0;
                next += i;
            }
        }
        return list;
    }
}
