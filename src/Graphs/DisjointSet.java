package Graphs;

public class DisjointSet {

    int[] rank = new int[10000];
    int[] parent = new int[10000];

    public DisjointSet()
    {
        for(int i = 0; i < 10000; i++)
        {
            parent[i] = i;
        }
    }

    public int getParent(int node)
    {
        if(node == parent[node]) return node;
        return parent[node] = getParent(parent[node]);
    }

    public void union(int u1 , int v1)
    {
        var u = getParent(u1);
        var v = getParent(v1);
        if(rank[u] > rank[v])
        {

            parent[v] = u;
        }
        else if(rank[v] > rank[u])
        {
            parent[u] = v;
        }
        else
        {
            parent[v] = u;
            rank[u]++;
        }
    }
}
