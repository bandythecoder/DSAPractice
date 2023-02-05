package Spring.Framework;


import Algoritham.DynamicProgramming_LCS;
import Graphs.Problems;

import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.stream.Collectors;


public class Main {

    public static int fib(int n)
    {
        if(n == 0 || n ==1)
        {
            return 1;
        }

        return fib(n-1) + fib(n-2);
    }
    public  static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        int[][] value = new int[][]{{25,50},{50,25}};
      System.out.println(fib(5));

    }

    }







