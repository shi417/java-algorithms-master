package data_structure.hash_table;

/**
 * @Author: shaohan
 * @Date: 2018/9/18 10:40
 * @Description: 哈希表的实现类
 */
public class HashTable<K,V> {
    /**
     * 装载因子
     */
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;
    /**
     * 初始大小
     */
    private static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;
    /**
     * 内部数组
     */
    private Node<K,V>[] table;

    class Node<K,V> {
        K key;
        V value;
        Node<K,V> next;
        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }



}
