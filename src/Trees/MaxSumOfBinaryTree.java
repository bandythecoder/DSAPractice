package Trees;

public class MaxSumOfBinaryTree {

    public int maximum = 0;

    public int findMaxSum(Tree node)
    {
        if(node == null)
        {
            return 0;
        }

        int lmax = findMaxSum(node.left);
        int rmax = findMaxSum(node.right);
        maximum = Math.max(maximum , node.data + lmax + rmax);
        return node.data + lmax + rmax;
    }
}
