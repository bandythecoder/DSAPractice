package Graphs;

import java.util.List;
import java.util.Stack;

public class TopoSortUsingDFS
{
    public void printTopoSort(List<List<Integer>> li)
    {
        int n = li.size();
        boolean visited[] = new boolean[n];
        Stack<Integer> st = new Stack<>();
        for(int i =0; i < n; i++)
        {
            dfs(li, i, st, visited);
        }
     while(!st.isEmpty())
     {
         System.out.println(st.pop());
     }

    }

    private void dfs(List<List<Integer>> li, int i, Stack<Integer> st, boolean[] visited)
    {
        visited[i] = true;
        for(var val : li.get(i))
        {
            if(!visited[i])
            dfs(li,val,st,visited);
        }
        st.push(i);
    }
}
