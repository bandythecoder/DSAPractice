package Graphs;

import java.util.List;

public class DetectCycleUsingDFSUndirectedGraph
{
    public boolean detectCycle(List<List<Integer>> li)
    {
        int n = li.size();
        boolean visited[] = new boolean[n];
        for(int i = 1; i < n; i++)
        {
            if(!visited[i])
            {
               boolean isCycle = dfsCycleDetect(li, i,visited,-1);
               if(isCycle) return true;
            }

        }
             return false;
    }

    private boolean dfsCycleDetect(List<List<Integer>> li, int i, boolean[] visited, int i1)
    {
        visited[i] = true;
        for(var v : li.get(i))
        {
            if(!visited[v])
            {
                dfsCycleDetect(li, v, visited, i);
            }
            else
            {
                if(v != i1)
                {
                    return true;
                }
            }
        }
        return false;
    }
}
