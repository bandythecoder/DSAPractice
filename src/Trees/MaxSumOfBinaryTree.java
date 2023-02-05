package Trees;

public class MaxSumOfBinaryTree {
    int max = Integer.MIN_VALUE;
    public int maxSum(Tree root)
    {
        if(root == null)
        {
            return 0;
        }
        int lmax  = Math.max(maxSum(root.left),0);
        int rmax = Math.max(maxSum(root.right),0);

        max = Math.max(max, root.data + lmax + rmax);
        return Math.max(root.data + lmax, root.data + rmax);
    }
    public int maxPathSum(Tree root) {
        maxSum(root);
        return max;
    }
}
