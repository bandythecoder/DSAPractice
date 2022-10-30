package Trees;

public class CheckIfATreeIsBalanced {

    // Naive
     public boolean checkBalancedTree(Tree node)
     {
         if (node == null)
         {
             return true;
         }

         var lh = maxDepth(node.left);
         var rh = maxDepth(node.right);
         if(Math.abs(lh-rh) > 1) return false;

        var checkLeft = checkBalancedTree(node.left);
        var checkRight = checkBalancedTree(node.right);
        if(!checkLeft && !checkRight) return false;
        return true;

     }

    public int maxDepth(Tree node)
    {
        if (node == null)
        {
            return 0;
        }
        return 1 + Math.max(maxDepth(node.left), maxDepth(node.right));
    }


    // Smart Way

    public int checkIfBalancedTree(Tree node)
    {
        if(node == null) return 0;

        var lh = checkIfBalancedTree(node.left);
        var rh = checkIfBalancedTree(node.right);
        if(Math.abs(lh-rh) > 1) return -1;
        if(lh == -1 && rh == -1) return -1;
        return 1 + Math.max(lh,rh);

    }

}
