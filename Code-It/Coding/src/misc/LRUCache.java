package misc;

import java.util.HashMap;
import java.util.Map;

public class LRUCache extends ListNode {
    HashMap<String, Node> cache = new HashMap<>();
    int maxCapacity;
    int itemsInCache;
    Node head, tail;


    LRUCache(int maxCapacity) {
        itemsInCache = 0;
        this.maxCapacity = maxCapacity;

        head = new Node();
        tail = new Node();

        head.prev = null;
        head.next = tail;
        tail.prev = head;
        tail.next = null;

    }

    public String get(String key) {
        Node node = cache.get(key);
        boolean contains = node != null;

        if (!contains) {
            return "Does not Contain";
        }
        moveToHead(node);
        return node.data;
    }

    public void put(String key, String value){
        Node node = cache.get(key);
        boolean found = node!=null;

        if(!found){
            Node newNode = new Node(key,value);
            cache.put(key,newNode);
            addToHead(newNode);

            itemsInCache++;

            if(itemsInCache > maxCapacity){
                removeLRU();
            }
        }else{
            node.data=value;
            moveToHead(node);
        }
    }

    private void removeLRU(){
        Node prev = tail.prev;
        cache.remove(prev.key);
        removeNode(prev);
        --itemsInCache;
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }

    private void removeNode(Node node) {
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    private void addToHead(Node node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(4);
        cache.put("Swetha","First");
        cache.put("Varsha","Second");
        cache.put("Veda","Wife");
        cache.put("Srini","Husband");

        cache.put("Kittu","Cousin");

        System.out.println(cache.get("Swetha"));

        cache.put("Swetha","First");
        System.out.println(cache.get("Kittu"));
        System.out.println(cache.get("Swetha"));
        System.out.println(cache.get("Varsha"));



    }
}
