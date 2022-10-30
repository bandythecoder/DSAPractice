package Graphs;

import java.util.Arrays;
import java.util.List;

public class BellManFordAlgo {

    public boolean isNegativeCycle(List<clsNode> graph, int n)
    {

        int[] distance = new int[n];

        Arrays.fill(distance, 10000);
        distance[0] = 0;
        for(int i = 0; i < n-1; i++)
        {
            for(int j = 0; j < n ; j++)
            {
                int u = graph.get(j).getU();
                int v = graph.get(j).getV();
                int w =graph.get(j).getW();
                if(distance[u] + w < distance[v])
                {
                    distance[v] = distance[u] + w;
                }
            }
        }

        for(int j = 0; j < n ; j++)
        {
            int u = graph.get(j).getU();
            int v = graph.get(j).getV();
            int w =graph.get(j).getW();
            if(distance[u] + w < distance[v])
            {
                return true;
            }
        }

        return false;

    }
}
