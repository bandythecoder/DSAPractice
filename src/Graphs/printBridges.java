package Graphs;

import java.util.List;

public class printBridges
{
    public void printBridges(List<List<Integer>> ni)
    {
       int n = ni.size();
       boolean[] visited = new boolean[n];
       int[] timeInsertion = new int[n];
       int[] lowestInsertion = new int[n];

       for(int i = 0; i < n ; i++)
       {
           if(!visited[i])
           {
               dfs(ni,i,visited, timeInsertion, lowestInsertion, -1, 1);
           }
       }
    }

    private void dfs(List<List<Integer>> ni, int element, boolean[] visited, int[] timeInsertion, int[] lowestInsertion, int parent, int time)
    {
        visited[element] = true;
        timeInsertion[element] = lowestInsertion[element] = time++;
        for(var v : ni.get(element))
        {
            if(v == parent) continue;
            if(!visited[v])
            {
                dfs(ni,v,visited, timeInsertion, lowestInsertion, element, time);
                lowestInsertion[element] = Math.min(lowestInsertion[element], lowestInsertion[v]);
                if(lowestInsertion[v] > timeInsertion[element])
                {
                    System.out.println(element + " " + v);
                }
            }
            else
            {
                lowestInsertion[element] = Math.min(lowestInsertion[element], timeInsertion[v]);
            }
        }
    }
}
