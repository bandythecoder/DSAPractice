package Graphs;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ShortedPathInDirectedAcylicGraph
{

    public int shortedPath(List<List<Pair>> li, int source, int destination)
    {
        int n = li.size();
        Stack<Integer> st = new Stack<>();
        boolean[] visited = new boolean[n];
        for(int i = 0 ; i < n; i++)
        {
            topoSort(li,visited,st, i);
        }
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;
        while(!st.isEmpty())
        {
            int x = st.pop();
            if(distance[x] != Integer.MAX_VALUE)
            {
                for(var v : li.get(x))
                {
                    if(distance[v.edge] > distance[x] + v.weight)
                    {
                        distance[v.edge] = distance[x] + v.weight;
                    }
                }
            }

        }

        return distance[destination];
    }

    private void topoSort(List<List<Pair>> li,boolean[] visited, Stack<Integer> st, int i)
    {
        visited[i] = true;
        for(var v : li.get(i))
        {
            if(!visited[v.edge])
            {
                topoSort(li,visited,st, v.edge);
            }
        }
        st.push(i);
    }


    public static class Pair
    {
        int edge;
        int weight;

        public Pair(int edge, int weight) {
            this.edge = edge;
            this.weight = weight;
        }
    }


}
