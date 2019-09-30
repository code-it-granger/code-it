package misc;

public class ListNode {
    static class Node{
        String data;
        String key;
        Node prev, next;

        Node(String key, String data){
            this.key=key;
            this.data=data;
            prev=next=null;
        }

        Node(){

        }
    }
}
