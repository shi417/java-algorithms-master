package test;

import data_structure.heap.Heap;
import data_structure.heap.MaxHeap;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class Test {
    @org.junit.Test
    public void test7() {
        Integer i = 1;
        //BigInteger j = new BigInteger(i);
        System.out.println(3 & ~(1 << 1));
    }

    @org.junit.Test
    public void test6() {
        Integer[] arr = {5,9,2};
        Heap<Integer> maxHeap = new MaxHeap<>(arr);
        System.out.println(maxHeap.toString());
        maxHeap.pool();
        System.out.println(maxHeap.toString());
    }
    @org.junit.Test
    public void test5() {
        Integer[] arr = {5,9,2,1,0,8,7};
        Heap<Integer> maxHeap = new MaxHeap<>(arr);
        System.out.println(maxHeap.toString());
        Integer[] arr1 = new Integer[7];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = maxHeap.pool();
        }
        System.out.println(Arrays.toString(arr1));
    }
    @org.junit.Test
    public void test4() {
        int[] arr = {1, 2, 3, 4};
        System.arraycopy(arr, 2, arr, 1, 2);
        print(arr);
    }

    @org.junit.Test
    public void test3() {
        int[] arr = {1, 2, 3, 4};
        print(arr);
        for (int i = arr.length - 1; i > 2; i--) {
            arr[i] = arr[i - 1];
        }
        arr[2] = 100;
        print(arr);
    }

    private void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
        System.out.println();
    }

    @org.junit.Test
    public void test2() {
        data_structure.double_linked_list.LinkedList<String> l = new data_structure.double_linked_list.LinkedList();
        l.addFrist("a");
        l.addFrist("b");
        l.addFrist("c");
        System.out.println(l.toString());
    }

    @org.junit.Test
    public void test() {
        List<String> list = new LinkedList<>();
        list.add("a");
        list.add("a");
        list.add("a");
        System.out.println(list.toString());
        //list.remove("a");
        //System.out.println(list.toString());
    }

    @org.junit.Test
    public void test1() {
        System.out.println(8 / 2);
        System.out.println(8 / 6);//1.3
        System.out.println(9 / 2);
        System.out.println(8 / 3);//2.6
    }
}
