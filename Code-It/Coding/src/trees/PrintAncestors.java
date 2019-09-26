package trees;

import trees.dataStructure.BinaryTree;
import trees.dataStructure.BinaryTree.*;
import trees.traversal.Traversal;

import java.util.Stack;

public class PrintAncestors {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        Traversal t = new Traversal();
        Node root = tree.create();
        t.inOrder(root);
        System.out.println();
        printAncestorsRecursive(root, 5);
    }

    public static boolean printAncestorsRecursive(Node node, int key){
        if(node==null)
            return false;
        if(node.data==key)
            return true;

        if(printAncestorsRecursive(node.left,key) || printAncestorsRecursive(node.right, key)){
            System.out.print(node.data+" ");
            return true;
        }

        return false;

    }

}
