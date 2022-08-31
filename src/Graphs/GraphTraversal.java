package Graphs;

import Stack.StackProblems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphTraversal {

    public void printNodesUsingBfs(List<List<Integer>> adjacencyList)
    {
        int n = adjacencyList.size();
        boolean visited[] = new boolean[n];
        for(int i = 0; i < n ; i++)
        {
            if(!visited[i])
            bfs(visited, i, adjacencyList);
        }
    }

    private void bfs(boolean[] visited, int i, List<List<Integer>> adjacencyList)
    {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);

        while(!queue.isEmpty())
        {
            var v = queue.poll();
            visited[v] = true;
            System.out.println(v);
            for(var v1 : adjacencyList.get(v))
            {
                if(!visited[v1]) {
                    visited[v1] = true;
                    queue.add(v1);
                }
            }

        }
    }
    public void printNodesUsingDfs(List<List<Integer>> adjacencyList)
    {
        int n = adjacencyList.size();
        boolean visited[] = new boolean[n];
        for(int i = 0; i < n ; i++)
        {
            if(!visited[i])
                dfs(visited, i, adjacencyList);
        }
    }

    private void dfs(boolean[] visited, int i, List<List<Integer>> adjacencyList)
    {
        visited[i] = true;
        System.out.println(i);
        for(var v : adjacencyList.get(i))
        {
            if(!visited[v])
            {
                dfs(visited,v,adjacencyList);
            }
        }
    }

}
