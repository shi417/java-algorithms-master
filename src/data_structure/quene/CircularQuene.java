package data_structure.quene;

import java.util.NoSuchElementException;

/**
 * @Author: shaohan
 * @Date: 2018/11/15 19:58
 * @Description: 基于数组的循环队列
 */
public class CircularQuene {
    private int[] element;
    private int capacity;
    private int frist = 0;
    private int last = 0;
    public CircularQuene(int capacity) {
        element = new int[capacity];
        this.capacity = capacity;
    }
    public void enQuene(int come) {
        if ((last + 1) % capacity == frist) {
            throw new ArrayIndexOutOfBoundsException();
        }
        element[last++] = come;
    }
    public int deQuene() {
        if (frist == last) {
            throw new NoSuchElementException();
        }
        return element[frist++];
    }
}
