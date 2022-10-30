package Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrderTraversal {

    public void printTreeRecursion(Tree node)
    {
        if (node == null)
        {
            return;
        }
        printTreeRecursion(node.left);
        printTreeRecursion(node.right);
        System.out.println(node.data);
    }

    public List<Integer> postOrderTraversal(Tree node)
    {
        List<Integer> li = new ArrayList<>();
        Stack<Tree> st = new Stack<>();
        var curr = node;
        while(curr != null || !st.isEmpty())
        {
            if(curr!=null)
            {
                st.push(curr);
                curr = curr.left;

            }
            else
            {
                var temp = st.peek().right;
                if(temp == null)
                {
                     temp = st.pop();
                    li.add(temp.data);
                    while(!st.isEmpty() && temp == st.peek().right)
                    {
                        temp = st.pop();
                        li.add(temp.data);
                    }

                }
                else
                {
                    curr = temp;
                }
            }

        }
        return li;
    }

}
