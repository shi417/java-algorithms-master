package data_structure.linked_list;

/**
 * @Author: shaohan
 * @Date: 2018/11/19 09:56
 * @Description:
 */
public class Test {
    @org.junit.Test
    public void test() {
        LRUCache<String, String> cache = new LRUCache<>(4);
        cache.put("1", "1s");
        cache.put("2", "2s");
        cache.put("3", "3s");
        cache.get("2");
        cache.put("4", "4s");
        System.out.println(cache.toString());
        cache.put("5", "5s");
        System.out.println(cache.toString());
    }
}
