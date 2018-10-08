package algorithms.math.factorial;

/**
 * @Author: shaohan
 * @Date: 2018/9/23 21:26
 * @Description:
 */
public class Test {
    Factorial f = new Factorial();
    @org.junit.Test
    public void test() {
        for (int i = 1; i < 10; i++) {
            System.out.println(f.calculate(i));
        }
    }
}
