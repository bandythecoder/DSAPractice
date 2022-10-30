package Graphs;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class PrimsAlgo {

    public int minSpanningTreeWeight(List<List<PairMin>> li)
    {
        int n = li.size();
        int[] key = new int[n];
        boolean[] MST = new boolean[n];
        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        Arrays.fill(key, Integer.MAX_VALUE);
        key[0] = 0;
        PriorityQueue<PairMin> pq = new PriorityQueue<>((a,b) -> a.weight - b.weight);
        pq.add(new PairMin(0,0));
        for(int i = 0; i < n-1; i++)
        {
            int min = Integer.MAX_VALUE;
            int u = 0;
//            for(int v =0 ; v < n ; v++)
//            {
//                if(MST[v] == false && min > key[v])
//                {
//                    min = key[v];
//                    u =v;
//                }
//            }
            u = pq.poll().edge;

            MST[u] = true;
            for(var v : li.get(u))
            {
                if(MST[v.edge] == false && key[v.edge] > v.weight)
                {
                    key[v.edge] = v.weight;
                    parent[v.edge] = u;
                    pq.add(new PairMin(v.edge, v.weight));
                }
            }
        }
        int total = 0;
        for(int i = 0 ; i < n ; i++)
        {
            total += key[i];
        }
        return total;
    }

    public static class PairMin
    {
        int edge;
        int weight;

        public PairMin(int edge, int weight) {
            this.edge = edge;
            this.weight = weight;
        }
    }
}
