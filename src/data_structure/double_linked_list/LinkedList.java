package data_structure.double_linked_list;

import java.lang.reflect.Array;
import java.util.NoSuchElementException;


/**
 * @Author: shaohan
 * @Date: 2018/9/15 15:28
 * @Description: 双向链表实现类
 */
public class LinkedList<E> {
    /**
     * 记录链表中的元素个数
     */
    private int size;
    /**
     * 链表的头
     */
    private Node<E> frist;
    /**
     * 链表的尾
     */
    private Node<E> last;

    public LinkedList() {

    }

    /**
     * 链表的结点类
     *
     * @param <E>
     */
    class Node<E> {
        E value;
        Node<E> next;
        Node<E> prev;

        Node(E value, Node<E> next, Node<E> prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }

    /**
     * insert e at the end of list
     *
     * @param e
     * @return
     */
    public boolean add(E e) {
        linkLast(e);
        return true;
    }

    /**
     * insert e at the beginning of list
     *
     * @param e
     */
    public void addFrist(E e) {
        linkFrist(e);
    }

    /**
     * link e as first element
     *
     * @param e
     */
    private void linkFrist(E e) {
        final Node<E> newNode = new Node<>(e, this.frist, null);
        final Node<E> f = this.frist;
        this.frist = newNode;
        if (f == null) {
            this.last = newNode;
        } else {
            f.prev = newNode;
            this.frist.prev = newNode;
        }
        size++;
    }

    /**
     * insert e at the end of list
     *
     * @param e
     */
    public void addLast(E e) {
        linkLast(e);
    }

    /**
     * link e as last element
     *
     * @param e
     */
    private void linkLast(E e) {
        final Node<E> newNode = new Node<>(e, null, last);
        final Node<E> l = last;
        last = newNode;
        if (l == null) {
            frist = newNode;
        } else {
            l.next = newNode;
        }
        size++;
    }

    /**
     * add e to index
     *
     * @param index
     * @param e
     */
    public void add(int index, E e) {
        checkElementIndex(index);
        if (index == 0) {
            linkFrist(e);
            size++;
        } else {
            Node<E> currentNode = node(index);
            Node<E> newNode = new Node<>(e, currentNode, currentNode.prev);
            currentNode.prev.next = newNode;
            currentNode.prev = newNode;
            size++;
        }
    }

    /**
     * remove a node based on specified element
     * if this linkedlist has not only one same element, this method only remove the first one
     *
     * @param o
     * @return
     */
    public boolean remove(Object o) {
        if (o == null) {
            for (Node<E> x = frist; x != null; x = frist.next) {
                if (x.value == null) {
                    unlink(x);
                    return true;
                }
            }
        } else {
            for (Node<E> x = frist; x != null; x = frist.next) {
                if (o.equals(x.value)) {
                    unlink(x);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @return
     */
    public E remove() {
        return removeFirst();
    }

    /**
     * @param index
     * @return
     */
    public E remove(int index) {
        checkElementIndex(index);
        return unlink(node(index));
    }

    public E removeFirst() {
        if (this.frist == null) {
            throw new NoSuchElementException();
        }
        unlink(this.frist);
        return this.frist.value;
    }

    /**
     * remove last element
     *
     * @return
     */
    public E removeLast() {
        if (this.last == null) {
            throw new NoSuchElementException();
        }
        unlink(this.last);
        return this.last.value;
    }

    /**
     * remove a node
     *
     * @param x
     * @return
     */
    private E unlink(Node<E> x) {
        final E element = x.value;
        if (frist == last) {
            frist = null;
            last = null;
        } else if (x.prev == null) {
            x.next.prev = null;
            frist = x.next;
            x.next = null;
        } else if (x.next == null) {
            x.prev.next = null;
            last = x.prev;
            x.prev = null;
        } else {
            x.prev.next = x.next;
            x.next.prev = x.prev;
        }
        size--;
        x.value = null;
        return element;
    }

    /**
     * get the first element
     *
     * @return
     */
    public E getFrist() {
        if (frist == null) {
            throw new NoSuchElementException();
        }
        return frist.value;
    }

    /**
     * get the last element
     *
     * @return
     */
    public E getLast() {
        if (last == null) {
            throw new NoSuchElementException();
        }
        return last.value;
    }

    /**
     * get specific element
     *
     * @param i
     * @return
     */
    public E get(int i) {
        checkElementIndex(i);
        return node(i).value;
    }

    /**
     * use index to find element
     *
     * @param i
     * @return
     */
    private Node<E> node(int i) {
        if (i <= (size >> 1)) {
            Node<E> x = this.frist;
            for (int k = 0; k <= i; k++) {
                x = x.next;
            }
            return x;
        } else {
            Node<E> x = this.last;
            for (int k = size - 1; k >= i; k--) {
                x = x.prev;
            }
            return x;
        }

    }

    /**
     * check index
     *
     * @param i
     */
    private void checkElementIndex(int i) {
        if (!isElementIndex(i)) {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * index 0 to size-1
     *
     * @param i
     * @return
     */
    private boolean isElementIndex(int i) {
        return i >= 0 && i < size;
    }

    /**
     * to a Object[]
     *
     * @return
     */
    public Object[] toArray() {
        Object[] result = new Object[size];
        Node<E> f = frist;
        for (int i = 0; i < size; i++) {
            result[i] = f.value;
            f = f.next;
        }
        return result;
    }

    /**
     * to a T[]
     *
     * @param t
     * @param <T>
     * @return
     */
    public <T> T[] toArray(T[] t) {
        if (t.length < size) {
            t = (T[]) Array.newInstance(t.getClass().getComponentType(), size);
        }
        int i = 0;
        Object[] result = t;
        for (Node<E> f = frist; f != null; f = f.next) {
            result[i++] = f.value;
        }
        if (t.length > size) {
            result[size] = null;
        }
        return t;
    }

    /**
     * change a node value
     *
     * @param index
     * @param e
     */
    public void set(int index, E e) {
        checkElementIndex(index);
        node(index).value = e;
    }

    /**
     * clear
     */
    public void clear() {
        for (Node<E> f = frist; f != null; f = f.next) {
            f.value = null;
            f.prev = null;
            f.next = null;
        }
        size = 0;
        frist = last = null;
    }

    /**
     * get size
     *
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * o 's index
     *
     * @param o
     * @return
     */
    public int indexOf(Object o) {
        int index = 0;
        if (o == null) {
            for (Node<E> f = frist; f != null; f = f.next) {
                if (f.value == null) {
                    return index;
                }
                index++;
            }
        } else {
            for (Node<E> f = frist; f != null; f = f.next) {
                if (f.value.equals(o)) {
                    return index;
                }
                index++;
            }
        }
        return -1;
    }

    /**
     * o 's last index
     *
     * @param o
     * @return
     */
    public int lastIndexOf(Object o) {
        int index = size - 1;
        if (o == null) {
            for (Node<E> f = last; f != null; f = f.prev) {
                if (f.value == null) {
                    return index;
                }
                index--;
            }
        } else {
            for (Node<E> f = last; f != null; f = f.prev) {
                if (f.value.equals(o)) {
                    return index;
                }
                index--;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (size == 0) {
            return "[]";
        }
        sb.append("[");
        for (Node<E> f = frist; f != null; f = f.next) {
            sb.append(f.value + ",");
            if (f == last) {
                sb.deleteCharAt(sb.length() - 1).append("]");
            }
        }
        return sb.toString();
    }
}