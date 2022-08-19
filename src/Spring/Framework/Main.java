package Spring.Framework;




import Algoritham.BackTrackingProblems;
import Algoritham.DynamicProgramming_Knapsack01;

import java.lang.reflect.InvocationTargetException;
import java.nio.file.LinkPermission;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.*;

import Algoritham.Greedy;
import Graphs.GraphRepresentation;
import Graphs.GraphTraversal;
import Graphs.Problems;
import HeapProblems.HeapProblems;
import LinkedList.*;

public class Main {




    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        {
          List<List<Problems.Pair>> ls = new ArrayList<>();
          int n = 5;
          for(int i = 0; i < n ; i++)
          {
              ls.add(new ArrayList<Problems.Pair>());
          }

            ls.get(0).add(new Problems.Pair(1,2));
            ls.get(0).add(new Problems.Pair(3,6));

            ls.get(1).add(new Problems.Pair(0,2));
            ls.get(1).add(new Problems.Pair(4,5));
            ls.get(1).add(new Problems.Pair(2,3));
            ls.get(1).add(new Problems.Pair(3,8));

            ls.get(2).add(new Problems.Pair(1,3));
            ls.get(2).add(new Problems.Pair(4,7));

            ls.get(3).add(new Problems.Pair(0,6));
            ls.get(3).add(new Problems.Pair(1,8));
            ls.get(4).add(new Problems.Pair(1,5));
            ls.get(4).add(new Problems.Pair(2,7));




           Problems p = new Problems();
          var v = p.minSpanningTree(ls);
          System.out.println(v);
        }
        }
    }








