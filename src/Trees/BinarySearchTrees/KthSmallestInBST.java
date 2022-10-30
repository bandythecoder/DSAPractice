package Trees.BinarySearchTrees;

import Trees.Tree;

public class KthSmallestInBST {

    public int findKthSmallest(Tree node, int k)
    {
        var curr = node;
        int count = 0;
        while(curr != null)
        {
            if(curr.left == null)
            {
                count++;
                curr = curr.right;
            }
            else
            {
                var prev = curr.left;
                while(prev.right != null && prev.right != curr)
                {
                    prev = prev.right;
                }
                if(prev.right == null)
                {
                    prev.right = curr;
                    curr = curr.left;
                }
                else
                {
                    count++;
                    curr = prev.right;
                }
            }
            if(count == k)
            {
                return curr.data;
            }
        }
        return -1;
    }
}
