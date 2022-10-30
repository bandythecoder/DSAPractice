package Graphs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class DjikshraAlgo
{
    public int shortestPath(List<List<PairDJ>> adjacencyMatrix , int source, int destination)
    {
        int n = adjacencyMatrix.size();
        int[] distance = new int[n];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[source] = 0;

        PriorityQueue<PairDJ> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x.weight));
        pq.add(new PairDJ(source,0));
        while(!pq.isEmpty())
        {
            var x = pq.poll();

            for(var v : adjacencyMatrix.get(x.edge))
            {
                if(distance[v.edge] > distance[x.edge] + v.weight)
                {
                    distance[v.edge] = distance[x.edge] + v.weight;
                    pq.add(new PairDJ(v.edge,distance[v.edge]));

                }
            }

        }

        return distance[destination];

    }


    public static class PairDJ
    {
        int edge;
        int weight;

        public PairDJ(int edge, int weight) {
            this.edge = edge;
            this.weight = weight;
        }
    }
}
