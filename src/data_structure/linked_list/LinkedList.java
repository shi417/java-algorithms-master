package data_structure.linked_list;

/**
 * @Author: shaohan
 * @Date: 2018/9/14 17:24
 * @Description: 链表实现类
 */
public class LinkedList<E> {

    private Node<E> head;

    private Node<E> tail;

    private int size;

    public LinkedList() {
    }

    public int size() {
        return size;
    }

    public int indexOf(Object o) {
        int index = 0;
        if (o == null) {
            for (Node<E> x = head; x != null; x = x.next) {
                if (x.value == null)
                    return index;
                index++;
            }
        } else {
            for (Node<E> x = head; x != null; x = x.next) {
                if (o.equals(x.value))
                    return index;
                index++;
            }
        }
        return -1;
    }

    /**
     * make e as head
     * @param e
     */
    public void prepend (E e) {
        Node<E> node = new Node<>(e,this.head);
        this.head = node;
        //if there is no tail,make this new node as tail
        if (this.tail == null) {
            this.tail = node;
        }
        size++;
    }

    /**
     * make e as tail
     * @param e
     */
    public void append(E e) {
        Node<E> node = new Node<>(e,null);
        //if there is no head,make this new node as head
        if (this.head == null) {
            this.head = node;
            this.tail = node;
        } else {
            this.tail.next = node;
            this.tail = node;
        }
        size++;
    }

    /**
     * 根据指定引用删除
     * @param o
     * @return
     */
    public boolean remove(Object o) {
        if (o == null) {
            for (Node<E> node = head; head != null; node = head.next) {
                if (node.value == null) {
                    unlink(node);
                    return true;
                }
            }
        } else {
            for (Node<E> node = head; node != null; node = head.next) {
                if (o.equals(node.value)) {
                    unlink(node);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 去掉一个元素
     * @param node
     */
    private void unlink(Node<E> node) {
        if (node == this.head) {
            this.head = node.next;
            node.next = null;
        }

        Node<E> preNode = head;
        while (preNode.next != node) {
            preNode = head.next;
        }
        if (node != tail) {
            preNode.next = node.next;
            node.next = null;
        } else {
            preNode.next = node.next;
            this.tail = preNode;
        }
        size--;
    }

    /**
     * 删除尾元素
     * @return
     */
    public int deleteTail() {
        unlink(this.tail);
        return 0;
    }


}
