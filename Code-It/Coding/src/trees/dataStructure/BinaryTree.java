package trees.dataStructure;

public class BinaryTree {
    public static class Node{
        public int data;
        public Node left;
        public Node right;

        Node(int d){
            this.data=d;
            right=left=null;
        }
    }

    public Node root;

    public Node create(){
        Node one = new Node(1);
        Node left1 = new Node(2);
        Node right1 = new Node(3);
        Node left11 = new Node(4);
        Node right11 = new Node(5);
        Node left12= new Node(6);

        root=one;
        one.left=left1;
        one.right=right1;

        left1.left=left11;
        left1.right=right11;

        left11.left=left12;

        return root;
    }
}
