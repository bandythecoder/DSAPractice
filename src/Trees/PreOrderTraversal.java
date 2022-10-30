package Trees;

import java.util.Stack;

public class PreOrderTraversal
{
    public void printTree(Tree node)
    {
        if(node == null)
        {
            return;
        }
        System.out.println(node.data);
        printTree(node.left);
        printTree(node.right);
    }

    public void printTreeIterative(Tree node)
    {
        Stack<Tree> st = new Stack<>();
        st.push(node);
        while(!st.isEmpty())
        {
            var v = st.pop();
            System.out.println(v.data);
           if(v.right != null) st.push(v.right);
            if(v.left != null) st.push(v.left);
        }
    }
}
