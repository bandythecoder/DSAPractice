package Graphs;

import java.util.List;

public class DetectCycleInDirectedGraphDFS
{
    public boolean detectCycle(List<List<Integer>> li)
    {
        int n  = li.size();
        boolean visited[] = new boolean[n];
        boolean dfsVisited[] = new boolean[n];
        for(int i = 0; i < n ;i++)
        {
            if(visited[i] == false)
            {
                var isCycle = dfs(li, visited,dfsVisited,i);
                if(isCycle) return true;
            }
        }
          return false;
    }

    private boolean dfs(List<List<Integer>> li, boolean[] visited, boolean[] dfsVisited, int i)
    {
        visited[i] = true;
        dfsVisited[i] = true;
        for(var val : li.get(i))
        {
            if(!visited[val])
            {
                if(dfs(li,visited,dfsVisited,val))
                {
                    return true;
                }
            }
            else
            {
                if(dfsVisited[val])
                {
                    return true;
                }
            }
        }
        dfsVisited[i] = false;
        return false;
    }
}
