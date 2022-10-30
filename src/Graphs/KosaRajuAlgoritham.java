package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class KosaRajuAlgoritham
{
    public void printSCC(List<List<Integer>> li)
    {
        int n = li.size();
        Stack<Integer> st = new Stack<>();
        boolean[] visited = new boolean[n];
        for(int i = 0; i < n; i++)
        {
            if(!visited[i])
            {
                dfsTopo(li, st, visited,  i);
            }
        }
        List<List<Integer>> transpose = new ArrayList<>();
        transposeList(transpose,li, n);
        Arrays.fill(visited, false);
        while(!st.isEmpty()) {
            var i = st.pop();
            System.out.println("SCC -");
            if(!visited[i])
            DFSPrintSCC(transpose, visited, i);
        }

    }

    private void DFSPrintSCC(List<List<Integer>> transpose, boolean[] visited, Integer i)
    {
        System.out.println(i);
        visited[i] = true;
        for(var v : transpose.get(i))
        {
            if(!visited[v])
            {
                DFSPrintSCC(transpose, visited, v);
            }
        }
    }

    private void transposeList(List<List<Integer>> transpose, List<List<Integer>> li, int n)
    {
        for(int i = 0; i < n ; i++)
        {
            transpose.add(new ArrayList<>());
        }
        for(int i = 0; i < n ; i++)
        {
            for(var v : li.get(i))
            {
                transpose.get(v).add(i);
            }
        }
    }

    private void dfsTopo(List<List<Integer>> li, Stack<Integer> st, boolean[] visited, int i)
    {
        visited[i] = true;
        for(var v : li.get(i))
        {
            if(!visited[v])
            dfsTopo(li, st, visited,  v);
        }
        st.push(i);
    }
}
