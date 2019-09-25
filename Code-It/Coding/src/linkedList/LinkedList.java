package linkedList;

public class LinkedList {
    static class Node{
        Node next;
        int data;

        Node(int d){
            this.data=d;
        }
    }

    Node head;

    public void insertAtHead(int d){
        Node node = new Node(d);
        if(head==null){
            head=node;
        }else{
            node.next=head;
            head=node;
        }
    }

    public void insertAtTail(int d){
        if(head==null)
            insertAtHead(d);
        else{
            Node node=new Node(d);
            Node  n=head;
            while(n.next!=null)
                n=n.next;
            n.next=node;
        }
    }

    public void deleteHead(){
        if(head==null)
            return;
        if(head.next==null)
            head=null;
        else{
            head.data=head.next.data;
            head.next=head.next.next;
        }
    }

    public void deleteTail(){
        if(head==null)
            return;
        if(head.next==null)
            head=null;
        else{
            Node n = head;
            while(n.next.next!=null)
                n=n.next;
            n.next=null;
        }
    }

    public void deleteNode(int d){
        if(head==null)
            return;
        if(head.data==d){
            if(head.next!=null) {
                head.data = head.next.data;
                head.next = head.next.next;
            }
            else
                head=null;
        }
        Node n=head;
        while(n.next!=null){
            if(n.next.data==d) {
                n.next = n.next.next;
                return;
            }
            n=n.next;
        }
    }

    public void reverse() {
        Node current = head;
        Node prev = null;
        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head=prev;
    }

    public Node createDummyList(){
        Node A=new Node(1);
        Node B=new Node(3);
        Node C=new Node(2);
        Node D=new Node(4);
        Node E=new Node(6);
        Node F=new Node(5);

        this.head=A;
        A.next=B;
        B.next=C;
        C.next=D;
        D.next=E;
        E.next=F;

        return this.head;
    }

    public void print(){
        if(head==null)
            return;
        Node node = head;
        while(node!=null){
            System.out.print(node.data+" ");
            node=node.next;
        }
        System.out.println();
        return;
    }
}
