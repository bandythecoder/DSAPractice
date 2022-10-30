package GraphProblems;

import java.util.ArrayList;
import java.util.List;

public class NumberOfIceland2 {
    int[] parent;
    int[] rank;

    public void setup(int length)
    {
        parent = new int[length-1];
        rank = new int[length-1];
        for(int i = 0; i < length-1; i++)
        {
            parent[i] = -1;
            rank[i] = 0;
        }
    }

    public int union(int x , int y)
    {
        int x1 = getParent(x);
        int x2 = getParent(y);
        if(x1 == x2)
        {
            return 0;
        }

        if(rank[x] > rank[y])
        {
            parent[y] = x;
            rank[x]++;
        }
        else if(rank[y] > rank[x])
        {
            parent[x] = y;
            rank[y]++;
        }
        else
        {
            parent[y] = x;
            rank[x]++;
        }
        return 1;

    }

    private int getParent(int x) {
        if(x == parent[x]) return x;
        return parent[x] = getParent(parent[x]);
    }

    public List<Integer> numberOfIceland(int m , int n, int[][] queries)
    {
        List<Integer> li = new ArrayList<>();
        setup(m*n);
        int count = 0;
        for(int i = 0;i < queries.length; i++)
        {
            int row = queries[i][0];
            int col = queries[i][1];
            int cellNumber = row * n + col;
            parent[cellNumber] = cellNumber;
            rank[cellNumber] = 1;
count++;
            int[][] directions = {{0,1},{1,0},{-1,0},{0,-1}};

            for(var v : directions)
            {
              var  newCell = ((row + v[0]) * n) + (col+v[1]);
              if(newCell <0 || newCell > m*n || parent[newCell] == -1)
              {
                  continue;
              }
             count = count - union(newCell,cellNumber);

            }
li.add(count);
        }
        return li;
    }
}
