package trees;

import trees.dataStructure.Trees;

public class PrintNodesAtKLevel extends Trees {
    public static void main(String[] args) {
        Trees tree = new Trees();
        Node root = tree.createBT();

        printNodesAtKLevel(root,2);
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
