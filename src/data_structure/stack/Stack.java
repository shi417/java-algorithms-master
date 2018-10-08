package data_structure.stack;

import data_structure.double_linked_list.LinkedList;

import java.util.NoSuchElementException;

/**
 * @Author: shaohan
 * @Date: 2018/9/17 19:57
 * @Description: 栈的实现类
 */
public class Stack<E> extends LinkedList<E> {
    /**
     * 是否是空栈
     * @return
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * 读取栈列元素
     * @return
     */
    public E peek() {
        try{
            return getFrist();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    /**
     * 出栈
     * @return
     */
    public E pop() {
        try{
            return removeFirst();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    /**
     * 入栈
     */
    public void push(E e) {
        addFrist(e);
    }
}
