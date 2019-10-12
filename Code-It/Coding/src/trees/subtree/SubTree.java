package trees.subtree;

import trees.dataStructure.TreeNode.*;
import trees.dataStructure.Trees;
import trees.traversal.Traversal;

public class SubTree extends Trees {


    static private Node createBT1(){
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

    static private Node createBT2(){
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
        Trees tree = new Trees();

        Node T = createBT1();
        Node S =  createBT2();

        Traversal traversal = new Traversal();

        traversal.inOrder(T);
        System.out.println();
        traversal.inOrder(S);

        System.out.println("\n"+isSubTree(T,S));
    }

    public static boolean isSubTree(Node T, Node S) {

        return T!=null && (identical(T,S) || isSubTree(T.left, S) || isSubTree(T.right, S));

    }

        public static boolean identical(Node T, Node S){
        if(T==null && S==null)
            return true;

        if(T==null || S== null)
            return false;

        return (T.data==S.data && identical(T.left, S.left) && identical(T.right, S.right));
    }
}
