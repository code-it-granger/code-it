package linkedList;

public class RemovekthNodeCircularLinkedList {
    static class Node {
        int data;
        Node next;

        public Node(int d) {
            this.data = d;
            next = null;
        }
    }

    public static void main(String[] args) {
        Node a0 = new Node(0);
        Node a1 = new Node(1);
        Node a2 = new Node(2);
        Node a3 = new Node(3);
        Node a4 = new Node(4);
        Node a5 = new Node(5);
        Node a6 = new Node(6);
        Node a7 = new Node(7);
        Node a8 = new Node(8);
        Node a9 = new Node(9);
        Node a10 = new Node(10);


        a0.next = a1;
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;
        a5.next = a6;
        a6.next = a7;
        a7.next = a8;
        a8.next = a9;
        a9.next = a10;
        a10.next = a1;

        print(a1);
        removeKth(a1, 2);
    }

    private static void removeKth(Node head, int k) {
        if (head == null)
            return;

        Node curr = head, prev = head;

        while (true) {
            //Case with only one element left in the list
            if (curr.next == head && curr == head) {
                print(head);
                break;
            }
            //Advancing k steps forward in the list. i starts from 1 because the current element counts as first element
            //if not, we can change i to start from 0
            for (int i = 0; i < k; i++) {
                prev = curr;
                curr = curr.next;
            }

            //if head element is to be deleted
            if (curr == head) {
                curr = curr.next;
                head = curr;
            }

            //if tail element is to be deleted
            else if (curr.next == head) {
                curr = curr.next;
            } else {
                curr = curr.next;
            }
            prev.next = curr;

            print(head);

        }

    }

    private static void print(Node head) {
        if (head == null)
            return;
        Node node = head;
        System.out.println();
        if (node != null) {
            do {
                System.out.print(node.data + " ");
                node = node.next;
            } while (node != head);
        }
    }
}
