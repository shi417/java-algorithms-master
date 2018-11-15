package data_structure.linked_list;

/**
 * @Author: shaohan
 * @Date: 2018/11/15 17:02
 * @Description: 使用单链表实现LRU缓存淘汰策略
 */
public class LRU<E> {
    private LinkedList<E> lru = new LinkedList<>();

    //缓存最近使用的20条记录
    public void addCache(E e) {
        if (lru.indexOf(e) != -1) {
            lru.remove(e);
            lru.prepend(e);
        } else if (lru.size() == 20) {
            lru.deleteTail();
            lru.prepend(e);
        } else {
            lru.prepend(e);
        }
    }
}
