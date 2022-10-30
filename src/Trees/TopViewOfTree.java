package Trees;

import LinkedList.Node;

import java.util.*;

public class TopViewOfTree {

    public List<Integer> printTopView(Tree Node)
    {
        TreeMap<Integer,Integer> tm = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(Node, 0));
        while(!q.isEmpty())
        {
            var v = q.poll();
            if(tm.get(v.x) == null)
            {
                tm.put(v.x,v.node.data);
            }
            else
            {

            }
            if(v.node.left != null)
            {
                q.add(new Pair(v.node.left, v.x-1));
            }
            if(v.node.right != null)
            {
                q.add(new Pair(v.node.right, v.x+1));
            }
        }

        List<Integer> li = new ArrayList<>();

        for(var v : tm.values())
        {
            li.add(v);
        }
return li;
    }



    class Pair
    {
        Tree node;
        int x;

        public Pair(Tree node, int x) {
            this.node = node;
            this.x = x;
        }
    }
}
