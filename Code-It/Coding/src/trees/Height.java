package trees;

import trees.dataStructure.Trees;

public class Height extends Trees {
    public static void main(String[] args) {
        Trees trees = new Trees();
        Node root = trees.createBT();
        int height = height(root);
        System.out.println(height);
    }

    public static int height(Node root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;

        int lheight = height(root.left);
        int rheight = height(root.right);

        return Math.max(lheight, rheight) + 1;
    }
}
