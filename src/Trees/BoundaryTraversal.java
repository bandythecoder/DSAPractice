package Trees;

import java.util.ArrayList;
import java.util.List;

public class BoundaryTraversal {
    public List<Integer> printBoundaryTraversal(Tree Node)
    {
        List<Integer> li = new ArrayList<>();
        if(!isLeafNode(Node))
        {
            li.add(Node.data);
        }

        leftBoundry(Node, li);
        addLeaves(Node, li);
        RightBoundary(Node,li);
        return li;
    }

    private void addLeaves(Tree node, List<Integer> li) {
        if(isLeafNode(node))
        {
            li.add(node.data);
        }
        if(node.left != null) addLeaves(node.left,li);
        if(node.right != null) addLeaves(node.right,li);
    }

    private void leftBoundry(Tree node, List<Integer> li)
    {
        var curr = node.left;
        while(curr != null)
        {
            if(!isLeafNode(curr)) li.add(curr.data);
            if(curr.left != null) curr= curr.left;
            else curr = curr.right;
        }
    }

    private void RightBoundary(Tree node, List<Integer> li)
    {
        var curr = node.right;
        var temp = new ArrayList<Integer>();
        while(curr != null)
        {
            if(!isLeafNode(curr)) temp.add(curr.data);
            if(curr.right != null) curr= curr.right;
            else curr = curr.left;
        }
        for(int i = temp.size() -1 ; i >= 0 ; i--)
        {
            li.add(temp.get(i));
        }
    }

    private boolean isLeafNode(Tree node) {
        return (node.left == null) && (node.right == null);
    }
}
