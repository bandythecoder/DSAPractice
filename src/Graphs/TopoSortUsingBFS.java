package Graphs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopoSortUsingBFS
{
    public void printTopoSort(List<List<Integer>> li)
    {
        int n = li.size();
        var inDegreeArray = calculateInDegreeArray(li);
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++)
        {
            if(inDegreeArray[i] == 0)
            {
                q.add(i);
            }
        }

        while(!q.isEmpty())
        {
            var v = q.poll();
            System.out.println(v);
            for(var v1 : li.get(v))
            {
                inDegreeArray[v1]--;
                if(inDegreeArray[v1] == 0)
                {
                    q.add(v1);
                }
            }

        }

    }

    private int[] calculateInDegreeArray(List<List<Integer>> li)
    {
        int n = li.size();
        int[] inDegree = new int[n];
        for(int i = 0; i < n ; i++)
        {
            for(var v : li.get(i))
            {
                inDegree[v]++;
            }
        }

        return inDegree;
    }
}
