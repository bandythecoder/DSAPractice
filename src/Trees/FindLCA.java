package Trees;

import javax.swing.tree.TreeNode;

public class FindLCA {

    public Tree findLCA(Tree node, Tree x, Tree y)
    {

        if(node == null || node == x || node == y)
        {
            return  node;
        }
        Tree x1  = findLCA(node.left,x,y) ;
        Tree y1 =findLCA(node.right,x,y) ;
       if(x1 == null)
       {
           return y1;
       }
       else if(y1 == null)
       {
           return x1;
       }
       else
       {
           return node;
       }

    }
}
