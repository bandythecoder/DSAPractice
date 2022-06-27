package Spring.Framework;

import Algoritham.BackTrackingProblems;
import Algoritham.DynamicProgramming_Knapsack01;

import java.lang.reflect.InvocationTargetException;
import java.nio.file.LinkPermission;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.*;

public class Main {

    public static int maxLength(List<String> arr) {
        List<String> ls = new ArrayList<>();
        solve(arr,ls,"",arr.size(),0);
        int max = 0;
        for(var v : ls)
        {
            max = Math.max(v.length(),max);
        }
        return max;
    }

    public static void  solve(List<String> arr, List<String> output, String outputValue, int size, int n)
    {

        if(isValid(outputValue) && n == size-1)
        {
            String value = outputValue;
            output.add(value);
        }

        for(int i = n; i < arr.size(); i++)
        {
            String value = outputValue;
            outputValue = outputValue + arr.get(i);

            solve(arr,output,outputValue, size, n+1);

            outputValue = value;
        }
    }

    private static boolean isValid(String s)
    {
        Set<Character> s1 = new HashSet<>();
        for(int i = 0; i < s.length(); i++)
        {
            s1.add(s.charAt(i));
        }
        return s1.size() == s.length();
    }
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        {
           BackTrackingProblems b = new BackTrackingProblems();
           int[][] maze = {{1,0,0,0},{1,1,0,1},{0,1,0,0},{1,1,1,1}};
           var v = b.solveKT();
           System.out.println("I am back");
        }
        }
    }








