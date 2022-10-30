package Trees.BinarySearchTrees;

import Trees.Tree;

public class SearchInBST {

    public Tree search(Tree root, int val ) {
        if (root == null)
            return null;
        if (root.data == val) return root;
        if (val < root.data) {
            return search(root.left, val);
        } else {
            return search(root.right, val);
        }
    }

    public Tree SearchIterative(Tree root, int val)
    {
        while(root != null && root.data != val)
        {
            root = root.data < val ? root.right : root.left;
        }
        return root;
    }
}
