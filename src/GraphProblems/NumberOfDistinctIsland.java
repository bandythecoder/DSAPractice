package GraphProblems;

import Graphs.Problems;
import Spring.Framework.Pair;
import Trees.BinarySearchTrees.InorderSuccessor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberOfDistinctIsland {

    public int countDistinctIsland(int[][] grid)
    {
        int count = 0;
        int r = grid.length;
        int c = grid[0].length;
        Set<List<String>> set = new HashSet<>();
        for(int i = 0; i < r ; i++)
        {
            for(int j = 0; j < c ; j++)
            {
                if(grid[i][j] == 1)
                {
                    var li = new ArrayList<String>();
                    dfs(grid, i, j, r,c,i,j,li);
                   set.add(li);
                }
            }
        }
        return set.size();
    }

    public void dfs(int[][] grid, int i , int j, int r , int c, int r0, int r1, List<String> li)
    {
        if(i < 0 || j < 0 || i > r-1 || j > c-1 || grid[i][j] == 0)
        {
            return;
        }
        li.add((i - r0) + " " + (j-r1));

        grid[i][j] = 0;
        int[][] directions = {{1,0}, {-1,0}, {0, 1}, {0, -1}};
        for(var v : directions)
        {
           int newR = i  + v[0];
           int newC = j + v[1];
           dfs(grid,newR,newC,r,c,r0,r1,li);
        }
    }
}
