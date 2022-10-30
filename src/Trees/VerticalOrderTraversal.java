package Trees;

import java.util.*;

public class VerticalOrderTraversal {


    public List<List<Integer>> verticalOrderTraversal(Tree node)
    {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> tm = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(node,0,0));

        while(!q.isEmpty())
        {
            var v = q.poll();
            var node1 = v.node;
            var x = v.row;
            var y = v.column;
            if(!tm.containsKey(x))
            {
                tm.put(x, new TreeMap<>());
            }
            if(!tm.get(x).containsKey(y))
            {
                tm.get(x).put(y, new PriorityQueue<>());
            }
            tm.get(x).get(y).add(v.node.data);
            if(v.node.left !=null)
            {
                q.add(new Tuple(v.node.left, x-1,y+1));
            }
            if(v.node.right !=null)
            {
                q.add(new Tuple(v.node.right, x+1,y+1));
            }
        }
        List<List<Integer>> li = new ArrayList<>();
        for(TreeMap<Integer,PriorityQueue<Integer>> v : tm.values())
        {
            li.add(new ArrayList<>());
            for(var v1 : v.values())
            {
                while (!v1.isEmpty())
                {
                   li.get(li.size()-1).add(v1.poll());
                }

            }
        }
return li;
    }


    public void verticalOrderTraversalDFS(Tree node, int x, int y, TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> tm)
    {
        if(node == null)
        {
            return ;
        }
        if(!tm.containsKey(x))
        {
            tm.put(x, new TreeMap<>());
        }
        if(!tm.get(x).containsKey(y))
        {
            tm.get(x).put(y, new PriorityQueue<>());
        }
        tm.get(x).get(y).add(node.data);

        verticalOrderTraversalDFS(node.left,x-1,y+1,tm);
        verticalOrderTraversalDFS(node.right,x+1,y+1,tm);
    }


   public class Tuple
    {
        Tree node;
        int row;
        int column;

        public Tuple(Tree node, int row, int column) {
            this.node = node;
            this.row = row;
            this.column = column;
        }
    }
}
