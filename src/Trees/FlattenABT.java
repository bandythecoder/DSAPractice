package Trees;

import java.util.Stack;

public class FlattenABT
{
    Tree prev = null;
    public void flattenBT(Tree node)
    {
        if(node == null) return;
        flattenBT(node.right);
        flattenBT(node.left);
        var v = node.right;
        node.right = prev;
        node.left = null;
        prev = node;
    }

    public void flattenBTIterative(Tree node)
    {
        Stack<Tree> st = new Stack<Tree>();
        st.push(node);
        while(!st.isEmpty())
        {
            var curr = st.pop();
            if(curr.right != null)
            {
                st.push(curr.right);
            }
            if(curr.left != null)
            {
                st.push(curr.left);
            }
            if(!st.isEmpty())
            curr.right = curr.left;
            curr.left = null;
        }
    }

    public void flattenBTIterativeWithoutSpace(Tree node)
    {
        var curr = node;
        while(curr != null)
        {
            if(curr.left != null)
            {
                var prev = curr.left;
                while(prev.right != null)
                {
                    prev = prev.right;
                }
                prev.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;

        }
    }
}
