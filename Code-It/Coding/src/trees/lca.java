package trees;

import trees.dataStructure.Trees;

public class lca extends Trees {
    public static void main(String[] args) {
        Trees trees = new Trees();
        Node root = trees.createBST();
        Node D = trees.D;
        Node node1 = trees.A;
        Node node2= trees.E;
        Node lca = lca(D, node1, node2);
        if(lca!=null)
        System.out.println(lca.data);
        else
            System.out.println("No LCA");
    }

    private static Node lca(Node root, Node node1, Node node2){
        if(node1==null && node2==null)
            return null;
        if(node1==null)
            return node2;
        if(node2==null)
            return node1;

        if((node1.data).compareTo(root.data)>0 && (node2.data).compareTo(root.data)>0)
            return lca(root.right,node1,node2);
        else if((node1.data).compareTo(root.data)<0 && (node2.data).compareTo(root.data)<0)
            return lca(root.left, node1, node2);
        else
            return root;
    }
}
