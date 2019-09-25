package linkedList.singleLinkedList;

import linkedList.singleLinkedList.LinkedList.*;

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.head = linkedList.createDummyList();
        linkedList.print();
  //      kthLastElement(linkedList.head, 4);
        middleElement(linkedList.head);
    }

    public static void kthLastElement(Node head, int k) {
        if(head==null || k<=0)
            return;
        Node slow = head, fast = head;
        for (int i = 0; i < k; i++)
            if (fast != null)
                fast = fast.next;
            else
                return;

        while(slow!=null && fast!=null){
            slow=slow.next;
            fast=fast.next;
        }
        System.out.println(slow.data);
    }

    public static void middleElement(Node head){
        if(head==null)
            return;
        Node slow=head, fast=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        System.out.println(slow.data);
    }
}
