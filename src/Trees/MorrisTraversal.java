package Trees;

import java.util.ArrayList;
import java.util.List;

public class MorrisTraversal {

    public List<Integer> Inorder(Tree curr)
    {
        List<Integer> inorder = new ArrayList<Integer>();
        while(curr != null)
        {
            if(curr.left == null)
            {
                inorder.add(curr.data);
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
                    prev.right = null;
                    inorder.add(curr.data);
                    curr = curr.right;
                }

            }

        }
        return inorder;
    }

    public List<Integer> preOrder(Tree curr)
    {
        List<Integer> inorder = new ArrayList<Integer>();
        while(curr != null)
        {
            if(curr.left == null)
            {
                inorder.add(curr.data);
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
                    inorder.add(curr.data);
                    curr = curr.left;
                }
                else
                {
                    prev.right = null;
                    curr = curr.right;
                }

            }

        }
        return inorder;
    }
}
