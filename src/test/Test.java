package test;

import java.util.LinkedList;
import java.util.List;

public class Test {
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
