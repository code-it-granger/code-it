package trees.dataStructure;

public class BinarySearchTree {
    public static class Node {
        public int data;
        public BinaryTree.Node left;
        public BinaryTree.Node right;

        Node(int d) {
            this.data = d;
            right = left = null;
        }
    }

    public BinaryTree.Node root;

    public BinaryTree.Node create() {
        BinaryTree.Node one = new BinaryTree.Node(6);
        BinaryTree.Node left1 = new BinaryTree.Node(4);
        BinaryTree.Node right1 = new BinaryTree.Node(7);
        BinaryTree.Node left11 = new BinaryTree.Node(3);
        BinaryTree.Node right11 = new BinaryTree.Node(5);
        BinaryTree.Node left12 = new BinaryTree.Node(2);

        root = one;
        one.left = left1;
        one.right = right1;

        left1.left = left11;
        left1.right = right11;

        left11.left = left12;

        return root;
    }
}
