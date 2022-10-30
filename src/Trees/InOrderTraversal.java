package Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderTraversal {

    public void printTreeRecursion(Tree node)
    {
        if(node == null) return;
        printTreeRecursion(node.left);
        System.out.println(node.data);
        printTreeRecursion(node.right);

    }

    public List<Integer> InorderTraversalIterative(Tree node)
    {
        List<Integer> inOrder = new ArrayList<>();
        Stack<Tree> n = new Stack<>();

        while(true)
        {
            if(node != null)
            {
                n.push(node);
               if (node != null) node = node.left;
            }
            else
            {
                if(n.isEmpty())
                {
                    break;
                }
                var v = n.pop();
                inOrder.add(v.data);
               node = v.right;
            }

        }
        return inOrder;
    }
}
