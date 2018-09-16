package data_structure.linked_list;

/**
 * @Author: shaohan
 * @Date: 2018/9/14 17:19
 * @Description: 链表的结点类
 */
public class Node<E> {
    E value;
    Node<E> next;

    public Node(E value, Node<E> next) {
        this.value = value;
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}
