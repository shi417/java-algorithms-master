package algorithms.recursion;

import org.junit.Test;

import java.util.Map;

/**
 * @Author: shaohan
 * @Date: 2018/11/15 22:41
 * @Description: 上楼梯
 */
public class UpStairs {
    /**
     * 使用一个Map记录已经计算过的
     * 解决重复计算的问题
     */
    private Map<Integer, Integer> cacheMap;

    /**
     *
     * @param stairs 楼梯数
     * @return 上法有多少种
     */
    public int up(int stairs) {
        if (stairs == 1) {
            return 1;
        }
        if (stairs == 2) {
            return 2;
        }
        if (cacheMap.containsKey(stairs)) {
            return cacheMap.get(stairs);
        }
        int ret =  up(stairs - 1) + up(stairs - 2);
        cacheMap.put(stairs, ret);
        return ret;
    }

    @Test
    public void test() {
        System.out.println(up(41));
    }
}
