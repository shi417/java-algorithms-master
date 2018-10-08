package data_structure.array;

import java.util.Arrays;

/**
 * @Author: shaohan
 * @Date: 2018/9/15 15:29
 * @Description: 动态数组XXx
 */
public class ArrayList<E> {
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
     * 动态数组-实际数组
     */
    private Object[] elementData;
    /**
     * 动态数组的长度（添加了几个元素）
     */
    private int size;

    /**
     * 指定内部数组的生产力的构造函数
     *
     * @param initialCapacity
     */
    public ArrayList(int initialCapacity) {
        if (initialCapacity == 0) {
            this.elementData = EMPTY_ELEMENTDATA;
        } else if (initialCapacity > 0) {
            this.elementData = new Object[initialCapacity];
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * 空参构造器
     */
    public ArrayList() {
        elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    /**
     * 统一内部数组长度与元素个数
     */
    public void trimToSize() {
        if (elementData.length > size) {
            elementData = (size == 0) ? EMPTY_ELEMENTDATA
                    : Arrays.copyOf(elementData, size);
        }
    }

    /**
     * 返回元素个数
     *
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * 该容器是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 在尾部添加元素
     *
     * @param e
     * @return
     */
    public boolean add(E e) {
        ensureCapacityInternal(size + 1);
        elementData[size++] = e;
        return true;
    }

    /**
     * 指定位置插入元素
     *
     * @param index
     * @param e
     * @return
     */
    public void add(int index, E e) {
        rangeCheckForAdd(index);
        ensureCapacityInternal(size + 1);
        for (int i = elementData.length - 1; i > index; i--) {
            elementData[i] = elementData[i - 1];
        }
        elementData[index] = e;
        size++;
    }

    /**
     * 更改指定位置的值
     *
     * @param index
     * @param e
     * @return
     */
    public E set(int index, E e) {
        rangeCheck(index);
        E oldValue = (E) elementData[index];
        elementData[index] = e;
        return oldValue;
    }

    /**
     * 获取指定位置的值
     *
     * @param index
     * @return
     */
    public E get(int index) {
        rangeCheck(index);
        return (E) elementData[index];
    }

    /**
     * 移除指定位置元素
     *
     * @param index
     * @return
     */
    public E remove(int index) {
        rangeCheck(index);
        E oldValue = (E) elementData[index];
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elementData, index + 1, elementData, index, numMoved);
        }
        elementData[--size] = null;
        return oldValue;
    }

    /**
     * 移除特定元素
     * @param o
     * @return
     */
    public boolean remove(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (elementData[i] == null) {
                    fastRemove(i);
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(elementData[i])) {
                    fastRemove(i);
                }
            }
        }
        return false;
    }

    /**
     * 移除操作
     * @param i
     */
    private void fastRemove(int i) {
        int numMoved = size - 1 - i;
        if (numMoved > 0) {
            System.arraycopy(elementData, i + 1, elementData, i, numMoved);
        }
        elementData[--size] = null;
    }

    /**
     * 清空
     */
    public void clear() {
        for (Object o : elementData) {
            o = null;
        }
        size = 0;
    }

    /**
     * o第一次出现的位置
     * @param o
     * @return
     */
    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (elementData[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(elementData[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * o最后一次出现的位置
     * @param o
     * @return
     */
    public int lastIndexOf(Object o) {
        if (o == null) {
            for (int i = size - 1; i >= 0; i--) {
                if (elementData[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = size - 1; i >= 0; i--) {
                if (o.equals(elementData[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * 转换为数组
     * @return
     */
    public Object[] toArray() {
        return Arrays.copyOf(elementData, size);
    }

    /**
     * 检查下标
     *
     * @param index
     */
    private void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * 添加元素是判断是否下标越界
     *
     * @param index
     */
    private void rangeCheckForAdd(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * 保证足够的生产力
     *
     * @param minCapacity
     */
    private void ensureCapacityInternal(int minCapacity) {
        ensureExplicitCapacity(calculateCapacity(elementData, minCapacity));
    }

    /**
     * 明确生产力
     *
     * @param minCapacity
     */
    private void ensureExplicitCapacity(int minCapacity) {
        if (minCapacity > elementData.length) {
            grow(minCapacity);
        }
    }

    /**
     * 大约1.5倍增长
     *
     * @param minCapacity
     */
    private void grow(int minCapacity) {
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity < minCapacity) {
            newCapacity = minCapacity;
        }
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    /**
     * 默认的生产力为10
     * 根据需求判断实际返回的生产力
     * 内置数组是否为空、所需生产力是否大于10
     *
     * @param elementData
     * @param minCapacity
     * @return
     */
    private static int calculateCapacity(Object[] elementData, int minCapacity) {
        if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
            return Math.max(minCapacity, DEFAULT_CAPACITY);
        }
        return minCapacity;
    }
}
