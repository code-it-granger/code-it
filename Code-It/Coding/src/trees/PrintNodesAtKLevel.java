package trees;

import trees.dataStructure.BinaryTree.Node;
import trees.dataStructure.BinaryTree;

public class PrintNodesAtKLevel {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        Node root = tree.create();

        printNodesAtKLevel(root,0);
    }

    public static void printNodesAtKLevel(Node node, int k){
        if(node==null)
            return;
        if(k==0)
        {
            System.out.println(node.data+" ");
            return;
        }
        else{
            printNodesAtKLevel(node.left,k-1);
            printNodesAtKLevel(node.right, k-1);
        }
        return;
    }
}
