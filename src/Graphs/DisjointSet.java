package Graphs;

public class DisjointSet {
    int[] rank = new int[1000];
    int[] parent = new int[1000];

    public DisjointSet()
    {
        for(int i = 0; i < 1000; i++)
        {
            rank[i] = 0;
            parent[i] = i;
        }
    }

    public int getParent(int u)
    {
       if(u == parent[u])
       {
           return u;
       }

       return parent[u] = getParent(parent[u]);
    }

    public void union(int u , int v)
    {
        int j = parent[u];
        int k = parent[v];

        if(rank[j] < rank[k])
        {
            parent[j] = k;
        }
        else if(rank[k] < rank[j])
        {
            parent[k] = j;
        }
        else
        {
            parent[k] = j;
            rank[j]++;
        }

    }
}
