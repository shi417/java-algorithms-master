package data_structure.tree.binary_tree;

/**
 * @Author: shaohan
 * @Date: 2018/11/20 21:05
 * @Description:二叉搜索树
 */
public class BinarySearchTree {

    private Node root;

    private int size;

    class Node {
        private Node left;
        private Node right;
        private int value;

        Node(int value) {
            this.value = value;
        }
    }

    public void insert(int value) {
        Node x = root;
        Node p = new Node(value);
        if (size == 0) {
            root = p;
            size++;
        } else {
            while (x != null) {
                if (x.value > value) {
                    if (x.left == null) {
                        x.left = p;
                        size++;
                        return;
                    }
                    x = x.left;
                } else {
                    if (x.right == null) {
                        x.right = p;
                        size++;
                        return;
                    }
                    x = x.left;
                }
            }
        }
    }

    public Node find(int value) {
        Node x = root;
        if (size == 0) {
            return null;
        }
        while (x != null && x.value != value) {
            if (x.value > value) {
                x = x.left;
            } else {
                x= x.right;
            }
        }
        return x;
    }
}
