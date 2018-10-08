package algorithms.math.fibonacci;

/**
 * @Author: shaohan
 * @Date: 2018/9/23 21:59
 * @Description:
 */
public class Test {
    @org.junit.Test
    public void test1() {
        Fibonacci f= new Fibonacci(46);
        f.calculate();
        int[] arr = f.getArr();
        for (int i : arr) {
            System.out.println(i);
        }
    }
    @org.junit.Test
    public void test() {
        Fibonacci f1 = new Fibonacci(1);
        Fibonacci f2 = new Fibonacci(50);
        for (int i = 0; i <= 5; i++) {
            System.out.println(f1.getFibonacci(i));
        }
        f2.calculate();
        int[] arr = f2.getArr();
        for (int i: arr) {
            System.out.println(i);
        }
    }
}
