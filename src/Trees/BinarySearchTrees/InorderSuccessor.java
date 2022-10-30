package Trees.BinarySearchTrees;

import Trees.Tree;

public class InorderSuccessor {


    public int inorderSuccessor(Tree xyz, int x)
    {
        Tree x1 = null;
        while(xyz != null)
        {
            if(xyz.data > x)
            {
                x1 = xyz;
                xyz = xyz.left;
            }
            else if (xyz.data < x)
            {
                xyz = xyz.right;
                x1 = xyz.right;

            }
            else
            {
                break;
            }
        }
        return x1 == null? -1 : x1.data;
    }
}
