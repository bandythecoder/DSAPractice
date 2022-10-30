package Trees;

public class CountNumberOfNodeInBT
{
    public int countNodes(Tree node)
    {
        if(node == null)
        {
            return 0;
        }

        int leftHeight= getleftHeight(node);
        int rightHeight = getRightheight(node);
        if(leftHeight == rightHeight )
        {
            return (int) (Math.pow(2,leftHeight) -1);
        }
        else
        {
            return 1 + countNodes(node.left) + countNodes(node.right);
        }
    }

    private int getRightheight(Tree right) {
        if(right == null) return 0;
        return 1+ getleftHeight(right.right);
    }

    private int getleftHeight(Tree left) {
        if(left == null) return 0;
        return 1+ getleftHeight(left.left);
    }
}
