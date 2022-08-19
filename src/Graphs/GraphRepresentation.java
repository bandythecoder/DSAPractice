package Graphs;

import Stack.StackProblems;

import java.util.ArrayList;
import java.util.List;

public class GraphRepresentation {

    // Adjacency Matrix

    // Adjacency List

    public List<List<StackProblems.Pair>> graphList()
    {
        int n =5;

        List<List<StackProblems.Pair>> list = new ArrayList<>();

        for(int i = 0; i <= n; i++)
        {
            list.add(new ArrayList<StackProblems.Pair>());
        }

        // edge 1--2 wt 3

        list.get(1).add(new StackProblems.Pair(2,3));
        list.get(2).add(new StackProblems.Pair(1,3));


        // edge 2--3 wt 2

        list.get(2).add(new StackProblems.Pair(3,2));
        list.get(3).add(new StackProblems.Pair(2,2));

        // edge 3---1 wt 1

        list.get(3).add(new StackProblems.Pair(4,1));
        list.get(4).add(new StackProblems.Pair(3,1));


        list.get(4).add(new StackProblems.Pair(5,4));
        list.get(5).add(new StackProblems.Pair(4,4));

        return list;

    }

    public List<List<Integer>> graphListUnDirected()
    {
        int n = 8;
        List<List<Integer>> li = new ArrayList<>();
        for(int i = 0; i <= n; i++)
        {
            li.add( new ArrayList<Integer>());
        }
        li.get(0).add(1);
        li.get(1).add(0);
        li.get(0).add(2);
        li.get(2).add(0);
        li.get(1).add(2);
        li.get(2).add(1);
        li.get(1).add(3);
        li.get(3).add(1);
        li.get(2).add(6);
        li.get(6).add(2);
        li.get(3).add(4);
        li.get(4).add(3);
        li.get(4).add(5);
        li.get(5).add(4);
        li.get(5).add(6);
        li.get(6).add(5);
        li.get(6).add(7);
        li.get(7).add(6);
        li.get(6).add(8);
        li.get(8).add(6);
        li.get(7).add(8);
        li.get(8).add(7);
        return li;

    }
    public List<List<Integer>> graphListDirected()
    {
        int n =9;

        List<List<Integer>> list = new ArrayList<>();

        for(int i = 0; i <= n; i++)
        {
            list.add(new ArrayList<Integer>());
        }

        // edge 1--2 wt 3

        list.get(1).add(2);
        list.get(2).add(3);
        list.get(3).add(4);
        list.get(3).add(5);
        list.get(4).add(6);
        list.get(5).add(6);
        list.get(7).add(2);
        list.get(7).add(8);
        list.get(8).add(9);
        list.get(7).add(9);
        // edge 2--3 wt 2


        return list;

    }

    public List<List<Integer>> DAG()
    {
        int n = 5;
        List<List<Integer>> l = new ArrayList<>();
        for(int i = 0; i <= n ; i++)
        {
            l.add(new ArrayList<Integer>());
        }

        l.get(2).add(3);
        l.get(3).add(1);
        l.get(4).add(1);
        l.get(5).add(2);
l.get(4).add(0);
        l.get(5).add(0);
        return l;
    }
}
