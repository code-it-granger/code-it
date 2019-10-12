package trees.subtree;

import trees.dataStructure.TreeNode.Node;
import trees.dataStructure.Trees;
import trees.traversal.Traversal;


public class SubTreeOptimal {

    static Node createBT1(){
        Node A = new Node("A");
        Node B = new Node("B");
        Node C = new Node("C");
        Node D = new Node("D");
        Node E = new Node("E");
        Node F = new Node("F");

        A.left=B;
        A.right=C;
        B.left=D;
        D.left=E;
        C.left=F;

        return A;
    }

   static public Node createBT2(){
       Node P = new Node("A");
       Node Q = new Node("B");
       Node R = new Node("C");
       Node S = new Node("D");
       Node T = new Node("E");
       Node U = new Node("F");

       Q.left=S;
       S.left=T;
       R.left=U;

       return Q;
    }

    public static void main(String[] args) {
        Node T = createBT1();
        Node S = createBT2();

        boolean subtree = isSubTree(T, S);

        System.out.println(subtree);

    }

    private static boolean isSubTree(Node T, Node S) {
        String inT = inOrder(T);
        String preT = preOrder(T);
        String inS = inOrder(S);
        String preS = preOrder(S);

        System.out.println(inT+"\n"+inS);
        System.out.println();
        System.out.println(preT+"\n"+preS);

        return inT.contains(inS) && preT.contains(preS);


    }

    private static String inOrder(Node root) {
        if (root == null)
            return "$";

        return inOrder(root.left) + " " + root.data + " " + inOrder(root.right);

    }


    private static String preOrder(Node root) {
        if (root == null)
            return "$";
        return root.data + " " + preOrder(root.left) + " " + preOrder(root.right);
    }
}
