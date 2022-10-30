package Trees;

import java.util.ArrayList;
import java.util.List;

public class LeftRightViewOfTree {
    public List<Integer> left = new ArrayList<>();
    public List<Integer> right = new ArrayList<>();
    public void leftViewOfTheTree(Tree Node, int level)
    {
        if(Node==null) return;

        if(level == left.size())
        {
            left.add(Node.data);
        }
        leftViewOfTheTree(Node.left, level+1);
        leftViewOfTheTree(Node.right,level+1);
    }

    public void RightViewOfTheTree(Tree Node, int level)
    {
        if(Node==null) return;

        if(level == right.size())
        {
            right.add(Node.data);
        }
        RightViewOfTheTree(Node.right, level+1);
        RightViewOfTheTree(Node.left,level+1);
    }
}
