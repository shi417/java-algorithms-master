package data_structure.quene;

import data_structure.double_linked_list.LinkedList;

import java.util.NoSuchElementException;

/**
 * @Author: shaohan
 * @Date: 2018/9/17 19:29
 * @Description: 队列的实现类
 */
public class Quene<E> extends LinkedList<E>{
    /**
     * 是否是空队列
     * @return
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * 读取队列头部元素
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
     * 进队列
     * @param e
     */
    public void enQuene (E e) {
        addLast(e);
    }

    /**
     * 出队列
     * @return
     */
    public E deQuene() {
        try{
            return removeFirst();
        }catch (NoSuchElementException e) {
            return null;
        }
    }
}
