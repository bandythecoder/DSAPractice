package Graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortedPathinUndirectedGraphUsingBFS {

    public int shortedPath(List<List<Integer>> li, int source, int dest)
    {
        int n = li.size();
        int[] distance = new int[n];

        Arrays.fill(distance, Integer.MAX_VALUE);
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        distance[source] = 0;
        while(!q.isEmpty())
        {
            int value = q.poll();
            for(var v : li.get(value))
            {
                if(distance[v] > distance[value] + 1)
                {
                    distance[v] = distance[value] + 1;
                    q.add(v);
                }
            }

        }
        return distance[dest];
    }
}
