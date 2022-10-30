package Trees.BinarySearchTrees;

import Trees.Tree;

public class LowestCommonAncestor {
    public Tree lowestCommonAncestor(Tree root, Tree p, Tree q)
    {
        if(root == null) return root;
        if(root.data < p. data && root.data < q.data)
        {
            return lowestCommonAncestor(root.left, p,q);
        }
        else if(root.data > p. data && root.data > q.data)
        {
            return lowestCommonAncestor(root.right, p,q);
        }
        else
        {
            return root;
        }


    }
}
