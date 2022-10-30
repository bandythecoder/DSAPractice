package Trees;

public class ChildSum {

    public void createChildSum(Tree node)
    {
        if(node == null)
        {
            return;
        }
        int left = node.left == null ? 0 : node.left.data;
        int right = node.right == null ? 0 : node.right.data;
        if(node.data > left + right)
        {
         if(node.left !=null)   node.left.data = node.data;
            if(node.right !=null)  node.right.data = node.data;
        }
        createChildSum(node.left);
        createChildSum(node.right);
        int left1 = node.left == null ? 0 : node.left.data;
        int right1 = node.right == null ? 0 : node.right.data;
if(node.left != null || node.right != null)
           node.data = left1 + right1;

    }
}
