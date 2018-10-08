package data_structure.heap;

/**
 * @Author: shaohan
 * @Date: 2018/9/19 11:22
 * @Description:
 */
public class MinHeap<E extends Comparable> extends Heap<E> {
    public MinHeap() {
        super();
    }
    public MinHeap(int initialCapacity) {
        super(initialCapacity);
    }
    public MinHeap(Object[] o) {
        super(o);
    }

    @Override
    protected boolean compareTo(Object e, Object e1) {
        return (compare(e, e1) < 0);
    }


    @Override
    public int compare(Object o1, Object o2) {
        E e1 = (E) o1;
        E e2 = (E) o2;
        return e1.compareTo(e2);
    }
}
