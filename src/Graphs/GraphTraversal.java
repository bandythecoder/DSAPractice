package Graphs;

import Stack.StackProblems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphTraversal {

    public int bfs(List<List<StackProblems.Pair>> adjacencyList, int n)
    {
       List<Integer> weights = new ArrayList<>();

        boolean[] visited = new boolean[n+1];

        for(int i = 1; i <= n; i++)
        {
            if(!visited[i])
            {
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);

                while(!queue.isEmpty())
                {
                    int value = queue.poll();
                    visited[value] = true;
                    weights.add(value);
                    for(var v: adjacencyList.get(i))
                    {
                        if(visited[v.getKey()] == false)
                        {
                            visited[v.getKey()] = true;

                            queue.add(v.getKey());

                        }
                    }
                }
            }

        }
        int totalweight = 0;
        for(int value : weights)
        {
            totalweight += value;
        }
        return totalweight;
    }

    public List<Integer> dfs(List<List<StackProblems.Pair>> adjacencyList, int n)
    {
        boolean[] visited = new boolean[n+1];
        List<Integer> dfs = new ArrayList<>();
        for(int i = 1; i < n +1; i++)
        {
            if(visited[i]) continue;
             dfsTravesal(adjacencyList,i,visited,dfs);
        }
        return dfs;
    }

    private void dfsTravesal(List<List<StackProblems.Pair>> adjacencyList, int i, boolean[] visited, List<Integer> dfs)
    {
        dfs.add(i);
        visited[i] = true;
        for(var v : adjacencyList.get(i))
        {
            if(visited[v.getKey()]) return;
            dfsTravesal(adjacencyList,v.getKey(),visited,dfs);
        }

    }
}
