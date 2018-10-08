package algorithms.math.bits;

import java.math.BigInteger;
import java.util.Random;

/**
 * @Author: shaohan
 * @Date: 2018/9/19 19:49
 * @Description:
 */
public class Test {

    @org.junit.Test
    public void test3() {
        String[] posNums = {"0", "1", "2", "3", "4", "8", "10", "12", "13", "20", "30"};
        String[] negaNums = {"-0", "-1", "-2", "-3", "-4", "-8", "-10", "-12", "-13", "-20", "-31"};
        for (String str : negaNums
                ) {
            BigInteger integer = new BigInteger(str);
            boolean jdk = integer.testBit(-Integer.valueOf(str));
            Bits bits = new Bits(str);
            boolean my = bits.testBit(-Integer.valueOf(str));
            System.out.println(jdk == my);
        }
    }

    @org.junit.Test
    public void getLowestBit() {
//        while (true) {
//            BigInteger bigInteger = new BigInteger(2, new Random());
//            System.out.println(bigInteger.toString());
//            System.out.println(bigInteger.getLowestSetBit());
//            System.out.println("---------------------------------------------------------------------------------");
//        }
        //System.out.println(Integer.toBinaryString(-4));
        BigInteger bigInteger = new BigInteger("-2");
           System.out.println(bigInteger.toString());
            System.out.println(bigInteger.getLowestSetBit());
    }

    @org.junit.Test
    public void test4() {
        String str = "-3";

        BigInteger integer = new BigInteger(str);
        boolean jdk = integer.testBit(1);
        Bits bits = new Bits(str);
        boolean my = bits.testBit(1);
        System.out.println(my);

    }

    @org.junit.Test
    public void test5() {
        int i = 1 << 102;
        int j = 102 & i;
        System.out.println(j);
    }

    @org.junit.Test
    public void test() {
        String[] posNums = {"0", "1", "2", "3", "4", "8", "100", "102", "200", "300"};
        String[] negaNums = {"-1", "-2", "-3", "-4", "-8", "-100", "-102", "-200", "-300"};
        for (String str : negaNums
                ) {
            BigInteger integer = new BigInteger(str);
            int jdk = integer.bitLength();
            Bits bits = new Bits(str);
            int my = bits.bitLength();
            System.out.println(jdk == my);
        }

    }

    @org.junit.Test
    public void test1() {
        String str = "102";
        System.out.println(Integer.toBinaryString(Integer.valueOf(str)));
        BigInteger integer = new BigInteger(str);
        int jdk = integer.bitLength();
        System.out.println(jdk);
    }

    @org.junit.Test
    public void test2() {
        for (int i = 0; i > -50; i--) {
            System.out.println(i + ":" + Integer.toBinaryString(i & (-i)));
        }
    }
}
