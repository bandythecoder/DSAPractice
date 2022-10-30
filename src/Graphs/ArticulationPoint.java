package Graphs;

import java.util.List;

public class ArticulationPoint
{
    public void printArticulationPoints(List<List<Integer>> li)
    {
        int n = li.size();

        boolean[] visited = new boolean[n];
        int[] timeInsertion = new int[n];
        int[] lowestTimeInsertion = new int[n];

        for(int i = 1; i < n ; i++)
        {
            if(!visited[i])
            {
                dfs(li, visited, timeInsertion, lowestTimeInsertion, i, -1,1);
            }
        }
    }

    private void dfs(List<List<Integer>> li, boolean[] visited, int[] timeInsertion, int[] lowestTimeInsertion, int i, int i1, int time)
    {
        visited[i] = true;
        lowestTimeInsertion[i] = timeInsertion[i] = time++;
        int child = 0;
        for(var item : li.get(i))
        {
            if(item == i1) continue;
            if(!visited[item])
            {
                dfs(li, visited, timeInsertion, lowestTimeInsertion, item, i,time);
                lowestTimeInsertion[i] = Math.min(lowestTimeInsertion[i],lowestTimeInsertion[item] );
                if(i1 != -1 && lowestTimeInsertion[item] >= timeInsertion[i])
                {
                    System.out.println(i);
                }
                child++;

            }
            else
            {
                lowestTimeInsertion[i] = Math.min(lowestTimeInsertion[i],timeInsertion[item] );
            }
            if(i1 == -1 && child > 1)
            {
                System.out.println(i);
            }
        }
    }
}
