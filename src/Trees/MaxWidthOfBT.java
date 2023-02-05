package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class MaxWidthOfBT {

    public int maxWidthBT(Tree tree)
    {
        Queue<treeWithIndex> q = new LinkedList<>();
        q.add(new treeWithIndex(tree,0));
        int first = 0, last = 0;
        while(!q.isEmpty())
        {
            int size = q.size();
           int min = q.peek().index;
            for(int i = 0; i < size; i++)
            {

                var item = q.poll();
                int  index = item.index-min;
                if(i == 0) first = index;
                if(i== size -1) last = index;
                if(item.node.left!= null) q.add(new treeWithIndex(item.node.left,2*index+1));
                if(item.node.right!= null) q.add(new treeWithIndex(item.node.right,2*index+2));
            }

        }
        return last-first+1;
    }

    class treeWithIndex
    {
        Tree node;
        int index;

        public treeWithIndex(Tree node, int index) {
            this.node = node;
            this.index = index;
        }
    }
}
