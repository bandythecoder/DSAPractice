package Graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BipartiteGraphWithBFS
{
    public boolean isBipartite(List<List<Integer>> li)
    {
        int n = li.size();
        int[] color = new int[n];
        Arrays.fill(color,-1);
        for(int i = 0; i < n ; i++)
        {
            if(color[i] == -1)
            {
                boolean isBip = bfs(li, i, color);
                if(!isBip) return false;
            }
        }
        return true;
    }

    private boolean bfs(List<List<Integer>> li, int i, int[] color)
    {
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        color[i] = 1;
        while(!q.isEmpty())
        {
            var v = q.poll();

            for(var v1 : li.get(v))
            {
                if(color[v1] == -1)
                {
                    color[v1] = 1 - color[v];
                    q.add(v1);
                }
                else
                {
                    if(color[v] == color[v1])
                    {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
