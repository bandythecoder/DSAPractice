package Trees.BinarySearchTrees;

import Trees.Tree;

public class CeilInBST {

    public int ceil(Tree node, int key)
    {
        int ceil = -1;
        while(node != null)
        {
            if (node.data >= key)
            {
                ceil = node.data;
                node = node.left;
            }
            else
            {
                node = node.right;
            }

        }
        return ceil;
    }
}
