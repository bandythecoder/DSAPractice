package Graphs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DetectCycleInDirectedGraphKhansAlgo {

    public boolean detectCycle(List<List<Integer>> li)
    {
        int n = li.size();
        int[] indegree = calculateInDegree(li,n);
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++)
        {
            if(indegree[i] == 0)
            {
                q.add(i);
            }
        }
        int count = 0;
        while(!q.isEmpty())
        {
            var v = q.poll();
            count++;
            for(var v1 : li.get(v))
            {
                indegree[v1]--;
                if(indegree[v1] == 0)
                {
                    q.add(v1);
                }
            }
        }

        if(count != n)
        {
            return true;
        }
        return false;
    }

    private int[] calculateInDegree(List<List<Integer>> li, int n)
    {

        int[] inDegree = new int[n];
       for(int i = 0; i < n ; i++)
       {
           for( var v : li.get(i))
           {
               inDegree[v]++;
           }
       }
        return inDegree;
    }
}
