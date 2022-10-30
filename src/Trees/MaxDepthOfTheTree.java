package Trees;

public class MaxDepthOfTheTree {

    public int maxDepth(Tree node)
    {
        if (node == null)
        {
            return 0;
        }
       return 1 + Math.max(maxDepth(node.left), maxDepth(node.right));
    }
}
