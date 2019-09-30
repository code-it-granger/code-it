package trees.dataStructure;

public class Trees extends TreeNode {
    public Node A = new Node("A");
    public Node B = new Node("B");
    public Node C = new Node("C");
    public Node D = new Node("D");
    public Node E = new Node("E");
    public Node F = new Node("F");

    public Node createBT(){
        A.left=B;
        A.right=C;
        B.left=D;
        D.left=E;
        C.left=F;

        return A;
    }

    public Node createBST(){
        D.left=B;
        D.right=F;
        B.left=A;
        B.right=C;
        F.left=E;

        return D;
    }
}
