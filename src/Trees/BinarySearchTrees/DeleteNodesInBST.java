package Trees.BinarySearchTrees;

import Trees.Tree;

public class DeleteNodesInBST {
    public Tree deleteNode(Tree root, int key) {
        if(root == null) return root;
        var node = root;
        if(root.data == key)
        {
            return helper(root);
        }
        while(root != null)
        {
            if(root.data > key)
            {
                if(root.left != null && root.left.data == key)
                {
                    root.left = helper(root.left);
                    break;
                }
                else
                {
                    root = root.left;
                }
            }
            else
            {
                if(root.right != null && root.right.data == key)
                {
                    root.right = helper(root.right);
                    break;
                }
                else
                {
                    root = root.right;
                }
            }
        }
        return node;
    }

    Tree helper(Tree root)
    {
        if(root.left == null && root.right  == null) return null;
        if(root.left == null) return root.right;
        if(root.right == null) return root.left;
        var prev = root.left;
        var x = root.left;
        while(prev.right != null)
        {
            prev = prev.right;
        }
        prev.right = root.right;
        return x;

    }
}
