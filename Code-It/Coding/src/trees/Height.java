package trees;

import trees.dataStructure.BinaryTree;
import trees.dataStructure.BinaryTree.Node;

public class Height {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        BinaryTree.Node root = bt.create();
        int height = height(root);
        System.out.println(height);
    }
    public static int height(Node root){
        if(root==null)
            return 0;
        if(root.left==null && root.right==null)
            return 1;

        int lheight = height(root.left);
        int rheight = height(root.right);

        return Math.max(lheight,rheight)+1;
    }
}
