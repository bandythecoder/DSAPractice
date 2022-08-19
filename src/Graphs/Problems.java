package Graphs;

import Stack.StackProblems;

import javax.swing.*;
import java.util.*;

public class Problems {

    public static class Pair
    {
        int v;
        int weight;

        public Pair(int v, int weight)
        {
            this.v = v;
            this.weight = weight;
        }
    }

    public boolean cycleDetectionUsingBFS(List<List<StackProblems.Pair>> adjacencyMatrix) {
        boolean[] visited = new boolean[adjacencyMatrix.size() ];
        for (int i = 1; i < adjacencyMatrix.size(); i++) {
            if (!visited[i]) {
                Queue<StackProblems.Pair> q = new LinkedList<>();
                q.add(new StackProblems.Pair(i, -1));
                StackProblems.Pair previous;
                while (!q.isEmpty()) {
                    previous = q.poll();
                    visited[i] = true;
                    for (var v : adjacencyMatrix.get(previous.getKey())) {
                        if (!visited[v.getKey()]) {
                            q.add(new StackProblems.Pair(v.getKey(), previous.getKey()));
                            visited[v.getKey()] = true;
                        } else {
                            if (v.getKey() != previous.getValue()) {
                                return true;
                            }


                        }
                    }

                }
            }
        }
        return false;

    }

    public boolean cycleDetectionUsingDFS(List<List<StackProblems.Pair>> adjacencyMatrix) {
      boolean[] visited = new boolean[adjacencyMatrix.size()];
      for(int i = 1; i < adjacencyMatrix.size() ; i++)
      {
          if(!visited[i])
          {
              if(dfsCycleDetect(adjacencyMatrix,i,-1,visited)) return true;

          }
      }
return false;
    }

    private boolean dfsCycleDetect(List<List<StackProblems.Pair>> adjacencyMatrix, int i, int i1, boolean[] visited)
    {
        visited[i] = true;
        for(var v : adjacencyMatrix.get(i))
        {
            if(!visited[v.getKey()])
            if(dfsCycleDetect(adjacencyMatrix,v.getKey(),i,visited))
            {
                return true;
            }
            else
            {
                if(i1 != v.getKey())
                {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkIfIsBipartiteGraph(List<List<StackProblems.Pair>> adjacencyList)
    {
        int[] arr = new int[adjacencyList.size()];

        Arrays.fill(arr,-1);
        for(int i = 0; i < adjacencyList.size(); i++)
        {
            if(arr[i] == -1)
            {
               if(bfsCheck(adjacencyList,arr, i))
               {
                   return true;
               }
            }
        }
        return false;
    }

    private boolean bfsCheck(List<List<StackProblems.Pair>> adjacencyList, int[] arr, int i)
    {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        arr[i] = 1;

        while(!queue.isEmpty())
        {
            var x = queue.poll();
            for(var v : adjacencyList.get(x))
            {
                if(arr[v.getKey()] == -1)
                {
                    arr[v.getKey()] = arr[x] - 1;
                    queue.add(v.getKey());
                }
                else
                {
                    if(arr[v.getKey()]  == arr[x])
                    {
                        return false;
                    }
                }
            }
        }
       return true;
    }


    public boolean checkIfIsBipartiteGraphDFS(List<List<StackProblems.Pair>> adjacencyList)
    {
        int[] arr = new int[adjacencyList.size()];

        Arrays.fill(arr,-1);
        for(int i = 1; i < adjacencyList.size(); i++)
        {
            if(arr[i] == -1)
            {
                if(!dfsCheck(adjacencyList,arr, i))
                {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean dfsCheck(List<List<StackProblems.Pair>> adjacencyList, int[] arr, int i)
    {
        if(arr[i] == -1) arr[i] =1;
        for( var v : adjacencyList.get(i))
        {
            if(arr[v.getKey()] == -1)
            {
                arr[v.getKey()] = arr[i] -1;
               if(!dfsCheck(adjacencyList,arr,v.getKey()))
                {
                    return false;
                }
            }
            else
            {
                if(arr[i] == arr[v.getKey()])
                {
                    return false;
                }
            }
        }
        return true    ;
    }

    public boolean cycleDetectionInDirectedGraph(List<List<Integer>> adjacencyList)
    {
        boolean  visited[]= new boolean[adjacencyList.size()];
        boolean  dfsVisited[]= new boolean[adjacencyList.size()];
        for(int i = 1; i < adjacencyList.size(); i++)
        {
            if(visited[i] != true) {
                if (isCycleDetected(adjacencyList, i, visited, dfsVisited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isCycleDetected(List<List<Integer>> adjacencyList, int i, boolean[] visited, boolean[] dfsVisited) {
        visited[i] = true;
        dfsVisited[i] = true;
        for(var v : adjacencyList.get(i))
        {
            if(visited[v] != true )
            {
                if((isCycleDetected(adjacencyList,v,visited,dfsVisited)))
                {
                    return true;
                }
            }
            else
            {
                if(dfsVisited[v] == true)
                {
                    return true;
                }

            }
        }
        dfsVisited[i] = false;
        return false;
    }

    public void printTopoSort(List<List<Integer>> l)
    {
        int n = l.size();
        boolean[] visited = new boolean[n];
        Stack<Integer> st = new Stack<>();
        for(int i = 0 ; i < n ; i++)
        {
            if(visited[i] != true)
            {
                dfsTopo(l,st, visited,i);
            }
        }

        while (!st.isEmpty())
        {
            System.out.println(st.pop());
        }

    }

    private void dfsTopo(List<List<Integer>> l, Stack<Integer> st, boolean[] visited,int i)
    {
        visited[i] = true;
        for(var v : l.get(i))
        {
            if(!visited[v])
            dfsTopo(l,st,visited, v);
        }
        st.push(i);

    }

    public void printTopoSortBFS(List<List<Integer>> l)
    {
        int n = l.size();
        int[] indegree = new int[n];
        for(int i = 0; i < n; i++)
        {
            for(int j : l.get(i))
            {
                indegree[j]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++)
        {
            if(indegree[i] == 0)
            {
                q.add(i);
            }
        }

        while(!q.isEmpty())
        {
            var v = q.poll();
            System.out.println(v);
            for(var v1 : l.get(v))
            {
                indegree[v1]--;
                if(indegree[v1] == 0)
                {
                    q.add(v1);
                }
            }
        }

    }

    public boolean isDirectedCyclicGraph(List<List<Integer>> l)
    {
        int n  = l.size();
       int indegreeArray[] = new int[n];
        for(int i = 0; i < n ; i++)
        {
            for(var v : l.get(i))
            {
                indegreeArray[v]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n ; i++)
        {
            if(indegreeArray[i] == 0)
            {
                q.add(i);
            }
        }

        int count = 0;
        while(!q.isEmpty())
        {
            var v = q.poll();
            count++;
            for(var v1: l.get(v))
            {
                indegreeArray[v1]--;
                if(indegreeArray[v1] == 0)
                {
                    q.add(v1);
                }
            }
        }
        return count == n ? false : true;
    }

    public int shortestDistanceFromSourceNodeUnDirectedGraphBFS(List<List<Integer>> ls, int source, int destination)
    {
        int n = ls.size();
        int[] distance = new int[n];
        Queue<Integer> qe = new LinkedList<>();
        Arrays.fill(distance, Integer.MAX_VALUE);
        qe.add((source));
        distance[source] = 0;
        while(!qe.isEmpty())
        {
            var v = qe.poll();
            for(var v1: ls.get(v))
            {
                if(distance[v] + 1 < distance[v1])
                {
                    distance[v1] = distance[v] + 1;
                    qe.add(v1);
                }
            }
        }
        return distance[destination];
    }

    public int shortestDistanceFromSourceNodeDirectedGraph(List<List<Pair>> ls, int source, int destination)
    {
        int n = ls.size();
        boolean[] visited = new boolean[n];
         Stack<Integer> st = new Stack<>();
        for(int i = 0; i < n; i++)
        {
            if(!visited[i])
            {
                topoSort(ls,st,visited,i);
            }

        }
        int distance[] = new int[n];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[source] = 0;
        while(!st.isEmpty())
        {
           int node = st.pop();
           for(var v : ls.get(node))
           {
               if(distance[v.v] > distance[node] + v.weight)
               {
                   distance[v.v] = distance[node] + v.weight;
               }
           }
        }
        return distance[destination];
    }

    private void topoSort(List<List<Pair>> ls, Stack<Integer> st, boolean[] visited, int i)
    {
        visited[i] = true;
        for(var v : ls.get(i))
        {
            if(!visited[v.v])
            {
                topoSort(ls, st, visited,v.v);
            }

        }
        st.push(i);

    }

    public int findshortedPathUsingDijkstra(List<List<Pair>> ls, int start, int des)
    {
        int n = ls.size(); // first step is to take size
        int distance[] = new int[n];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[start] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.weight));
        pq.add(new Pair(start,0));
        while(!pq.isEmpty())
        {
            var v = pq.poll();
            for(var v1 : ls.get(v.v))
            {
                if(distance[v1.v] > distance[v.v] + v1.weight)
                {
                    distance[v1.v] = distance[v.v] + v1.weight;
                    pq.add(new Pair(v1.v,distance[v1.v]));
                }
            }
        }
        return distance[des];
    }

    public int[] minSpanningTree(List<List<Pair>> ls)
    {
        int n = ls.size();
        int[] key = new int[n];
        boolean[] MST = new boolean[n];
        int[] parent = new int[n];

        for(int i = 0; i < n; i++)
        {
            key[i] = Integer.MAX_VALUE;
            parent[i] = -1;
        }

        key[0] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.weight - b.weight);
        pq.add(new Pair(0,key[0]));
        for(int i = 0; i < n-1; i++ )
        {
            int min = Integer.MAX_VALUE;

            int u = 0;
//            for(int j = 0; j < n; j++)
//            {
//                if(MST[j] == false && key[j] < min)
//                {
//                    min = key[j];
//                    u = j;
//                }
//            }

            u = pq.poll().v;

            MST[u] = true;

            for(var v : ls.get(u))
            {
                if(MST[v.v] == false && key[v.v] > v.weight)
                {
                    key[v.v] = v.weight;
                    parent[v.v] = u;
                    pq.add(new Pair(v.v,  key[v.v]));
                }
            }
        }
         return parent;
    }
}
