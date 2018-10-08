package data_structure.heap;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: shaohan
 * @Date: 2018/9/18 19:32
 * @Description: 堆的实现类
 */
public abstract class Heap<E extends Comparable> implements Comparator {
    /**
     * 默认的生产力
     */
    private static final int DEFAULT_CAPACITY = 10;
    /**
     * 空数组
     */
    private static final Object[] EMPTY_ELEMENTDATA = {};
    /**
     * 构造函数使用的空数组
     */
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

    /**
     * 内部数组
     */
    private Object[] elementDate;
    /**
     * 元素个数
     */
    private int size;

    public Heap() {
        elementDate = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    public Heap(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException();
        } else if (initialCapacity == 0) {
            elementDate = EMPTY_ELEMENTDATA;
        } else {
            elementDate = new Object[initialCapacity];
        }
    }

    public Heap(Object[] o) {
        elementDate = o;
        size = o.length;
        for (int i = size / 2; i >= 0; i--) {
            downTree(i);
        }
    }

    public int size() {
        return size;
    }

    /**
     * 返回左子树下标
     *
     * @param index
     * @return
     */
    public int getLeftChildIndex(int index) {
        return (index << 1) + 1;
    }

    /**
     * 返回右子树下标
     *
     * @param index
     * @return
     */
    public int getRightChildIndex(int index) {
        return (index << 1) + 2;
    }

    /**
     * 返回父节点下标
     *
     * @param index
     * @return
     */
    public int getParentIndex(int index) {
        if (index == 0) {
            throw new IllegalArgumentException();
        }
        return (index - 1) / 2;
    }

    /**
     * 是否有父节点
     *
     * @param index
     * @return
     */
    public boolean hasParent(int index) {
        return index > 0;
    }

    /**
     * 是否有左子树
     *
     * @param index
     * @return
     */
    public boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < size;
    }

    /**
     * 是否有右子树
     *
     * @param index
     * @return
     */
    public boolean hasRightChild(int index) {
        return getRightChildIndex(index) < size;
    }

    /**
     * 返回左子树的值
     *
     * @param index
     * @return
     */
    public E leftChild(int index) {
        if (!hasLeftChild(index)) {
            throw new IllegalArgumentException();
        }
        return (E) elementDate[getLeftChildIndex(index)];
    }

    /**
     * 返回右子树的值
     *
     * @param index
     * @return
     */
    public E rightChild(int index) {
        if (!hasRightChild(index)) {
            throw new IllegalArgumentException();
        }
        return (E) elementDate[getRightChildIndex(index)];
    }

    /**
     * 返回父节点的值
     *
     * @param index
     * @return
     */
    public E parent(int index) {
        if (!hasParent(index)) {
            throw new IllegalArgumentException();
        }
        return (E) elementDate[getParentIndex(index)];
    }

    /**
     * 交换值
     *
     * @param i
     * @param j
     */
    public void swap(int i, int j) {
        Object o;
        o = elementDate[i];
        elementDate[i] = elementDate[j];
        elementDate[j] = o;
    }

    /**
     * 返回堆顶元素
     *
     * @return
     */
    public E peek() {
        if (size == 0) {
            throw new NullPointerException();
        }
        return (E) elementDate[0];
    }

    /**
     * 移除堆顶元素
     *
     * @return
     */
    public E pool() {
        if (size == 0) {
            return null;
        }
        E e = (E) elementDate[0];
        elementDate[0] = elementDate[size - 1];
        elementDate[size - 1] = null;
        size--;
        downTreeForRemove(0);
        return e;
    }


    /**
     * 有移除操作时，调整完全二叉树
     *
     * @param currentIndex
     */
    public void downTreeForRemove(int currentIndex) {
        int nextIndex;
        while (hasLeftChild(currentIndex)) {
            if (hasRightChild(currentIndex) && compareTo(rightChild(currentIndex), leftChild(currentIndex))) {
                nextIndex = getRightChildIndex(currentIndex);
            } else {
                nextIndex = getLeftChildIndex(currentIndex);
            }
            if (compareTo(elementDate[currentIndex], elementDate[nextIndex])) {
                break;
            }
            swap(currentIndex, nextIndex);
            currentIndex = nextIndex;
        }
    }

    public void downTree(int currentIndex) {
        E e = (E) elementDate[0];
        elementDate[0] = elementDate[currentIndex];
        elementDate[currentIndex] = e;
        currentIndex = 0;
        int nextIndex;
        while (hasLeftChild(currentIndex)) {
            if (hasRightChild(currentIndex) && compareTo(rightChild(currentIndex), leftChild(currentIndex))) {
                nextIndex = getRightChildIndex(currentIndex);
            } else {
                nextIndex = getLeftChildIndex(currentIndex);
            }
            if (compareTo(elementDate[currentIndex], elementDate[nextIndex])) {
                break;
            }
            swap(currentIndex, nextIndex);
            currentIndex = nextIndex;
        }
    }


    /**
     * 堆的插入操作
     *
     * @param e
     */
    public void add(E e) {
        ensureCapacity(size + 1);
        elementDate[++size] = e;
        upTree(size);
    }

    /**
     * 有insert操作时，调整完全二叉树
     *
     * @param index
     */
    public void upTree(int index) {
        while (hasParent(index)) {
            if (compareTo(elementDate[index], parent(index))) {
                break;
            }
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    protected void ensureCapacity(int i) {
        ensureExplicitCapacity(calculateCapacity(elementDate, i));
    }

    private void ensureExplicitCapacity(int i) {
        if (i > elementDate.length) {
            grow(i);
        }
    }

    private void grow(int i) {
        int oldCapacity = elementDate.length;
        int newCapacity = oldCapacity + oldCapacity >> 1;
        if (newCapacity < i) {
            newCapacity = i;
        }
        Arrays.copyOf(elementDate, newCapacity);
    }

    private int calculateCapacity(Object[] elementDate, int i) {
        if (elementDate == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
            return Math.max(DEFAULT_CAPACITY, i);
        }
        return i;
    }

    @Override
    public String toString() {
        return "Heap{" +
                "elementDate=" + Arrays.toString(elementDate) +
                ", size=" + size +
                '}';
    }

    protected abstract boolean compareTo(Object e, Object e1);
}
