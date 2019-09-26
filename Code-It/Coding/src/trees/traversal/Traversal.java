package trees.traversal;

import trees.dataStructure.BinarySearchTree;
import trees.dataStructure.BinaryTree;
import trees.dataStructure.BinaryTree.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/*
                    1
            2                3
        4       5
    6
*/

public class Traversal {
    public static void main(String[] args) {
        BinarySearchTree bt = new BinarySearchTree();
        Traversal traversal = new Traversal();
        Node root = bt.create();
        traversal.inOrder(root);
        System.out.println();
        traversal.preOrder(root);
        System.out.println();
        traversal.postOrder(root);

        traversal.levelOrder(root);
    }

    public void inOrder(Node root){
        if(root==null)
            return;
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }

    public void preOrder(Node root){
        if(root==null)
            return;
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public void postOrder(Node root){
        if(root==null)
            return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+" ");
    }

    public void levelOrder(Node root){
        if(root==null)
            return;
        List<Node> queue = new ArrayList<>();

        queue.add(root);
    }
}
