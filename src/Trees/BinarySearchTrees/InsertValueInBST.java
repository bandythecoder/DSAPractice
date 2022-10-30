package Trees.BinarySearchTrees;

import Trees.Tree;

public class InsertValueInBST {

    public Tree insertNodes(Tree root, int n)
    {
        Tree x = new Tree(n);
        if(root == null) return x;
        var curr = root;
        while(true)
        {
            if(curr.data > n)
            {
                if(curr!= null)curr = curr.right;
                else {
                    curr.right = x;
                    break;
                }
            }
            else
            {
                if(curr!= null)curr = curr.left;
                else {
                    curr.left = x;
                    break;
                }
            }
        }
        return root;
    }
}
