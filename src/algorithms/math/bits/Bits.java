package algorithms.math.bits;


/**
 * @Author: shaohan
 * @Date: 2018/9/19 19:47
 * @Description: 该类封装了一些位运算的方法
 */
public class Bits {

    private static final int DEFAULT_NUMBER = 1;

    private int number;

    public Bits() {

    }

    public Bits(String number) {
        this.number = Integer.valueOf(number);
    }


    /**
     * 当且仅当设置了指定的位（1）时，返回 true。（计算 ((this & (1<<n)) != 0)。）
     * @param n
     * @return
     */
    public boolean testBit(int n) {
        return ((number & (1 << n)) != 0);
    }

    /**
     * 返回与number在设置了指定位（1）后等效的number
     * 计算 this | (1 <<n)
     * @param n
     * @return
     */
    public int setBit(int n) {
        return number | (1 << n);
    }

    /**
     * 返回与number在清除了指定位（1）后等效的number
     * 计算 this & ~(1 << n)
     * @param n
     * @return
     */
    public int clearBit(int n) {
        return number & ~(1 << n);
    }

    /**
     * 返回与number在指定位翻转后等效的number
     * 计算 this ^ ~(1 << n)
     * @param n
     * @return
     */
    public int flipBit(int n) {
        return number ^ ~(1 << n);
    }

    /**
     * 返回number最右端的1比特的索引
     * 计算  (this==0? -1 : log2(this & -this))
     * @return
     */
    public int getLowestSetBit() {
        if (number == 0) {
            return -1;
        } else {
            int n = 0;
            while ((1 << n) < (number & -number)) {

            }
            return n;
        }
    }
    /**
     * 返回一个整数的二进制补码形式的最高位数（符号位除外）
     * 计算 (ceil(log2(this < 0 ? -this : this+1)))
     *
     * @param
     * @return
     */
    public int bitLength() {
        int flag = 0;
        if (number >= 0) {
            while ((1 << flag) < (number + 1)) {
                flag += 1;
            }
            return flag;
        } else {
            number = -number;
            while ((1 << flag) < number) {
                flag += 1;
            }
            return flag;
        }
    }
}
