package algorithms.string.hamming_distance;

/**
 * @Author: shaohan
 * @Date: 2018/9/25 20:07
 * @Description: 汉明距离
 * 在信息理论中，Hamming Distance 表示两个等长字符串在对应位置上不同字符的数目
 * 对于二进制串ａ和ｂ来说，汉明距离等于ａXORｂ中１的数目，我们又称其为汉明权重
 */
public class HammingDistance {
    /**
     * 针对字符串
     * @param a
     * @param b
     * @return
     */
    public int hammingForString(String a, String b) {
        int flag = 0;
        if (a.length() != b.length()) {
            return -1;
        }
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == b.charAt(i)) {
                flag += 1;
            }
        }
        return flag;
    }

    /**
     * 针对二进制串
     * @param a
     * @param b
     * @return
     */
    public int hammingForBit(int a, int b) {
        return Integer.bitCount(a ^ b);
    }


}
