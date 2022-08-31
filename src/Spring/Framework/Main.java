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
import Graphs.*;
import HeapProblems.HeapProblems;
import LinkedList.*;

public class Main {


    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        {


             List<List<Integer>> graph = new ArrayList<>();

             for(int i = 0; i <= 5; i++)
             {
                 graph.add(new ArrayList<Integer>());
             }
             graph.get(1).add(2);
              graph.get(2).add(1);
             graph.get(2).add(3);
            graph.get(3).add(2);
             graph.get(3).add(4);
             graph.get(4).add(3);
            graph.get(1).add(4);
            graph.get(4).add(1);
             graph.get(4).add(5);
            graph.get(5).add(4);
            BipartiteGraphWithBFS p = new BipartiteGraphWithBFS();
        var v = p.isBipartite(graph);

            String s = "abc";



            List l = new ArrayList();
        }
    }
}








