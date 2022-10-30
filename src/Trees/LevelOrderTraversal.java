package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {

    public List<List<Integer>> printNodeBFS(Tree node)
    {
        Queue<Tree> q = new LinkedList<>();
        q.add(node);
        List<List<Integer>> l = new ArrayList<>();
        while(!q.isEmpty())
        {
            int level = q.size();
            List<Integer> l1 = new ArrayList<>()
;            for(int i = 0; i < level; i++) {
                if (q.peek().left != null) q.add(q.peek().left );
                if (q.peek().right != null) q.add(q.peek().right );
                l1.add(q.poll().data);
            }
            l.add(l1);
        }
        return l;
    }
}
