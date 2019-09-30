package trees;

import trees.dataStructure.Trees;
import trees.traversal.Traversal;

public class PrintAncestors extends Trees {

    public static void main(String[] args) {
        Trees tree = new Trees();
        Traversal t = new Traversal();
        Node root = tree.createBT();
        printAncestorsRecursive(root, "F");
    }

    public static boolean printAncestorsRecursive(Node node, String key){
        if(node==null)
            return false;
        if(node.data.equalsIgnoreCase(key))
            return true;

        if(printAncestorsRecursive(node.left,key) || printAncestorsRecursive(node.right, key)){
            System.out.print(node.data+" ");
            return true;
        }

        return false;

    }

}
