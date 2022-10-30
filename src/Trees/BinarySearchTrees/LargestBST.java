package Trees.BinarySearchTrees;

import Trees.Tree;

public class LargestBST {

    public int LargestBST(Tree node)
    {
       bst value = postOrder(node);
       return value.size;
    }

    private bst postOrder(Tree root) {
        if (root == null) {
            return new bst(  0,Integer.MAX_VALUE,Integer.MIN_VALUE);
        }

        // Get values from left and right subtree of current tree.
        var left = postOrder(root.left);
        var right = postOrder(root.right);

        // Current node is greater than max in left AND smaller than min in right, it is a BST.
        if (left.max < root.data && root.data < right.min) {
            // It is a BST.
            return new bst(
                    left.size + right.size + 1,Math.min(root.data, left.min), Math.max(root.data, right.max));
        }

        // Otherwise, return [-inf, inf] so that parent can't be valid BST
        return new bst(Math.max(left.size, right.size),Integer.MIN_VALUE, Integer.MAX_VALUE);
    }


    public class bst
    {
        int size;
        int min;
        int max;
        public bst(int x, int y, int z)
        {
            size  = x;
            min = y;
            max = z;
        }
    }
}
