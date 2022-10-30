package Trees;

import java.util.*;

public class ZigZagTraversal {

    public List<Integer[]> zigzagTraversal(Tree node)
    {
        List<Integer[]> li = new ArrayList<>();
        Queue<Tree> q = new LinkedList<>();
        q.add(node);
        boolean leftToRight = true;
        while(!q.isEmpty())
        {
            var level = q.size();
            Integer[] l = new Integer[level];
            for(int i = 0; i < level; i++)
            {
                int index = leftToRight ? i : level -1 - i;
                l[index] = q.peek().data;
                if(q.peek().left != null) q.add(q.peek().left);
                if(q.peek().right != null) q.add(q.peek().right);
                q.poll();
            }

            leftToRight = !leftToRight;
            li.add(l);

        }
        return li;
    }
}
