package Spring.Framework;


import java.lang.reflect.InvocationTargetException;

import java.util.*;


import GraphProblems.NumberOfDistinctIsland;
import Trees.*;
import Trees.BinarySearchTrees.*;

public class Main {

    public static class pair
    {
        int r;
        int c;


        public pair(int x, int y)
        {
            r = x;
            c =y;
        }
    }
    int min = 0;
    public static int shortestBridge(int[][] grid) {
        int n = grid.length;
        int count = 0;
        boolean[][] visited = new boolean[n][n];
        Queue<pair> q = new LinkedList<>();
        for(int i = 0 ; i < n ; i++)
        {
            for(int j = 0; j < n ; j++)
            {
                if(grid[i][j] == 1)
                {
                    dfs(grid, i, j, n, visited,q);
                    break;
                }
            }

        }
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        int level = -1;
        while(!q.isEmpty())
        {
            level++;
            var size = q.size();
            System.out.println(size);
            for(int i = 0; i < size; i++)
            {
                var pair = q.poll();
                for(var v : directions)
                {

                    int nr = pair.r + v[0];
                    int nc = pair.c + v[1];

                    if( nr < 0 || nc < 0 || nr >= n || nc >= n  || visited[nr][nc])
                    {
                        continue;
                    }
                    visited[nr][nc] = true;
                    if(grid[nr][nc] == 1)
                    {
                        return level;
                    }
                    q.add(new pair(nr, nc));
                }
            }
        }

        return -1;

    }

    public static void dfs(int[][] grid, int i, int j , int n, boolean[][] visited,Queue<pair> q)
    {
        if( i < 0 || j < 0 || i >= n || j >= n || grid[i][j] == 0 || visited[i][j])
        {
            return;
        }
        visited[i][j] = true;
        q.add(new pair(i,j));
        dfs(grid, i +1, j, n, visited,q);
        dfs(grid, i-1, j, n, visited,q);
        dfs(grid, i, j+1, n, visited,q);
        dfs(grid, i, j-1, n, visited,q);
    }





    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        {

           Integer[] var = {5,3,6,2,4,null,7};
            int x = shortestBridge(new int[][]{{0,1},{1,0}});
            Tree xyz = new Tree(10);
            xyz.left = new Tree(8);
            xyz.right = new Tree(6);
            xyz.left.left = new Tree(2);
            xyz.left.right = new Tree(4);

            xyz.right.right = new Tree(7);

        }
    }
}








