package Algoritham;

import java.util.ArrayList;
import java.util.List;

public class BackTrackingProblems
{
    public int subset_sum(int list[], int sum, int starting_index, int target_sum, int subset_count)
    {
        if( target_sum == sum )
        {
            subset_count++;
            if(starting_index < list.length)
                subset_sum(list, sum - list[starting_index-1], starting_index, target_sum, subset_count);
        }
        else
        {
            for( int i = starting_index; i < list.length; i++ )
            {
                subset_sum(list, sum + list[i], i + 1, target_sum,subset_count);
            }
        }
        return subset_count;
    }


    public void printPermutation(String input, String output)
    {

        if(input.equals(""))
        {
          System.out.println(output);
        }

        for(int i = 0; i < input.length(); i++)
        {
           String output1 = output + input.charAt(i);
            String input1 = input.substring(0,i) + input.substring(i+1,input.length());
            printPermutation(input1,output1);
        }
    }


    // N queen problem

    public List<List<Integer>> NQueenProblem(int n)
    {
        List<List<Integer>> li = new ArrayList<>();
        Solve(n, new ArrayList<Integer>(), li, 0);
        return li;
    }

    private void Solve(int n, ArrayList<Integer> integers, List<List<Integer>> li, int i)
    {
        // Base Case
        if( i == n)
        {
            li.add(new ArrayList<>(integers));
        }
        for(int i1 = 0 ; i1 < n;i1++)
        {
            integers.add(i1);
            if(isValidInput(integers))
            {
                Solve(n,integers,li, i+1);
            }
            integers.remove(integers.size()-1);
        }
    }

    private boolean isValidInput(List<Integer> i1)
    {
        int row = i1.size() -1;
        for(int i = 0 ; i < row; i++)
        {
            int diff = Math.abs(i1.get(i) - i1.get(row));
            if(diff == 0 || diff == row - i)
            {
                return false;
            }
        }
        return true;
    }

    public int[][] RatInMaze(int[][] maze)
    {
        int row = maze.length;
        int[][] solution = new int[row][row];
        List<int[][]> res = new ArrayList<>();
        solveMaze(row, 0,0, maze,solution,res);
        return res.get(0);
    }

    private void solveMaze(int size,int row, int column, int[][] maze, int[][] solution,List<int[][]> res)
    {
        // Goal
        if(row == size-1 && column == size-1 && maze[row][column] == 1 )
        {
            solution[row][column] = 1;
            int[][] resArray = new int[size][size];
            for(int i = 0; i < size; i++)
            {
                for(int j = 0; j < size; j++)
                {
                    resArray[i][j] = solution[i][j];
                }
            }
            res.add(resArray);
            return;
        }
        if(isSafe(row,column,size, maze))
        {
            if(solution[row][column] == 1) return;
        }
        else
        {
            return;
        }
        // Action
        solution[row][column] = 1;
        solveMaze(size, row+1,column,maze,solution,res);
        solveMaze(size,row,column+1,maze,solution,res);
        //BackTrack
        solution[row][column] = 0;
    }

    private boolean isSafe(int row, int column, int size, int[][] maze) {
        if(row < 0 || row >= size || column <0 || column >= size || maze[row][column] == 0 )
        {
            return false;
        }
        return true;
    }








}
