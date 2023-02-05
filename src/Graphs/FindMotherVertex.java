package Graphs;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class FindMotherVertex {

    public int findMotherVertex(List<List<Integer>> graph)
    {
        int n = graph.size();
        boolean[] visited = new boolean[n];
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < n ; i++)
        {
            if(!visited[i])
            {
                dfs(graph, i, visited, st);
            }
        }

        Arrays.fill(visited,false);
       var x = st.pop();
        dfs(graph, x, visited, st);

        for(var v : visited)
        {
            if(v == false)
            {
                return -1;
            }
        }

        return x;
    }

    private void dfs(List<List<Integer>> graph, int i, boolean[] visited, Stack<Integer> st)
    {
        visited[i] = true;
        for(var v : graph.get(i))
        {
            if(!visited[v])
            {
                dfs(graph, v, visited, st);
            }
        }
        st.push(i);
    }
}
