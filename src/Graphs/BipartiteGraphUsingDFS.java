package Graphs;

import java.util.Arrays;
import java.util.List;

public class BipartiteGraphUsingDFS
{

    public boolean isBipartite(List<List<Integer>> li)
    {
        int n = li.size();
        int[] color = new int[n];
        Arrays.fill(color,-1);
        for(int i = 1; i < n ; i++)
        {
            if(color[i] == -1)
            {
               var v = dfs(li, i,color);
               if(!v) return false;
            }
        }
           return true;
    }

    private boolean dfs(List<List<Integer>> li, int i, int[] color)
    {
       if(color[i] == -1) color[i] =1;
       for(var v : li.get(i))
       {
           if(color[v] == -1)
           {
               color[v] = 1 - color[i];
              if(!dfs(li, v, color))
              {
                  return false;
              }
           }
           else
           {
               if(color[v] == color[i]) return false;
           }
       }
       return true;
    }
}
