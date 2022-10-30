package Graphs;

import java.util.Comparator;
import java.util.List;

public class kruskalAlgo
{
    public void printMinSpanningTree(List<clsNode> li)
    {
        li.sort(Comparator.comparingInt(clsNode::getW));
        int n = li.size();
        int parent[] = new int[n];
        int rank[] = new int[n];
        for(int i = 0; i < n ; i++)
        {
            parent[i] =  i;
            rank[i] = 0;
        }
        int cost = 0;
        for(var value : li)
        {
            if(getParent(value.getU(), parent) != getParent(value.getV(), parent))
            {
                cost += value.getW();
                union(value.getU(),value.getV(),parent,rank);
            }
        }

        System.out.println(cost);
    }

    private void union(int u, int v, int[] parent, int[] rank)
    {
        int U = getParent(u,parent);
        int V = getParent(v,parent);
        if(rank[U] > rank[V])
        {
            parent[V] =U;
        }
        else if(rank[V] > rank[U])
        {
            parent[U] =V;
        }
        else
        {
            parent[U] =V;
            rank[V]++;
        }
    }

    private int getParent(int u, int[] parent)
    {
        if(u == parent[u]) return u;
        return parent[u] = getParent(parent[u],parent);
    }
}
