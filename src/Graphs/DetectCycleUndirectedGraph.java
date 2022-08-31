package Graphs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DetectCycleUndirectedGraph
{
    public boolean detectCycle(List<List<Integer>> li)
    {
        int n = li.size();
        boolean visited[] = new boolean[n];

        for(int i = 1; i < n ; i++)
        {
            if(!visited[i]) {
              var v =  bfsCycleDetect(li, i, visited);
              if(v == true) return true;
            }
        }
        return false;
    }

    private boolean bfsCycleDetect(List<List<Integer>> li, int i, boolean[] visited)
    {
        Queue<PairCycleDetect> q = new LinkedList<>();
        q.add(new PairCycleDetect(i,-1));
        while (!q.isEmpty())
        {
            var value = q.poll();
            int i1 = value.value1;
            int i2 = value.value2;
            visited[i1] = true;
            for(var v : li.get(i1))
            {
                if(!visited[v])
                {
                    visited[v] = true;
                    q.add(new PairCycleDetect(v,i1));
                }
                else
                {
                    if(v != i2)
                    {
                        return true;
                    }
                }
            }

        }

     return false;
    }

    public class PairCycleDetect
    {
        int value1;
        int value2;

        public PairCycleDetect(int a, int b)
        {
            value1 = a;
            value2 = b;
        }

    }
}
