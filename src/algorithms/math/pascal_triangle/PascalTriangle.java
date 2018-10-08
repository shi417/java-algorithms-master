package algorithms.math.pascal_triangle;

/**
 * @Author: shaohan
 * @Date: 2018/9/25 19:18
 * @Description: 杨辉三角
 */
public class PascalTriangle {
    public static void main(String[] args) {
        pascalTriangle();
    }

    private static void pascalTriangle() {
        int[][] tri = new int[30][];
        for (int i = 0; i < tri.length; i++) {
            tri[i] = new int[i + 1];
            for (int j = 0; j < tri[i].length; j++) {
                if (i == 0 || j ==0 || j == tri[i].length -1) {
                    tri[i][j] = 1;
                } else {
                    tri[i][j] = tri[i - 1][j - 1] + tri[i - 1][j];
                }
                System.out.print(tri[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
