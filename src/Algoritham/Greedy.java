package Algoritham;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Greedy {

    public double fractionalKnapsack(int[] value, int[] wt, int capacity)
    {
        int n = value.length;
        item[] items = new item[n];
        for(int i = 0; i <n ;i++)
        {
            items[i] = new item(wt[i],value[i]);
        }

        Arrays.sort(items, (o1,o2) -> o2.cost.compareTo(o1.cost));

        double totalProfit = 0.0;

        for(var item: items)
        {
            if(capacity >= item.wt)
            {
                totalProfit += item.value;
                capacity -= item.wt;

            }
            else if(capacity < item.wt && capacity != 0)
            {
                totalProfit += item.value *(capacity/item.wt*(1.0));
                capacity =0;
            }
            else
            {
                break;
            }
        }

        return totalProfit;

    }

    public int jobScheduleProblem(String[] ids,int[] hrs , int[] profits, int totalJob)
    {
        int n = ids.length;
        Job[] jobs = new Job[n];
        for(int i = 0; i < n; i++)
        {
            jobs[i] = new Job(ids[i], hrs[i], profits[i]);
        }

        Arrays.sort(jobs,(o1,o2) -> Integer.compare(o2.profit,o1.profit));
        int[] totalProfit = new int[totalJob];
        for(int i =0 ; i <n ; i++)
        {
            for(int j = jobs[i].hr -1 ; j >= 0 ; j--)
            {
                if(totalProfit[j] == 0)
                {
                    totalProfit[j] = jobs[i].profit;
                    break;
                }
            }
        }
       var profit = 0;
        for(int i = 0; i < totalProfit.length; i++)
        {
            profit += totalProfit[i];
        }
        return profit;

    }


    public void printHuffmanNodes(String s)
    {
        int n = s.length();

        HashMap<Character, Integer> hs = new HashMap<>();

        for(int i = 0; i < n;i++)
        {
            hs.put(s.charAt(i), hs.getOrDefault(s.charAt(i), 0) + 1);
        }
        PriorityQueue<HuffmanTree> pq = new PriorityQueue<>((o1,o2) -> o1.frequency - o2.frequency);

        for(var v : hs.entrySet())
        {
            pq.add(new HuffmanTree(v.getValue(), v.getKey()));
        }

        while(pq.size() > 1)
        {
            var node1 = pq.poll();
            var node2 = pq.poll();
            var node3 = new HuffmanTree(node1.frequency + node2.frequency, '-');
            node3.left = node1;
            node3.right = node2;
            pq.add(node3);

        }
        
        printHuffman(pq.poll(), "");
    }

    private void printHuffman(HuffmanTree node, String s)
    {
        if(node.left == null && node.right == null)
        {
            System.out.println(node.c + " - " + s);
            return;
        }
        printHuffman(node.left,s + "0");
        printHuffman(node.right, s + "1");
    }


    class HuffmanTree
    {
        int frequency;
        Character c;
        HuffmanTree left;
        HuffmanTree right;

        public HuffmanTree(int frequency, Character c)
        {
            this.frequency = frequency;
            this.c = c;
        }
    }

    class Job
    {
        String id;
        int hr;
        int profit;

        public Job(String id, int hr, int profit)
        {
            this.id = id;
            this.hr = hr;
            this.profit = profit;
        }
    }
    class item
    {
        double wt;
        double value;
        Double cost;

        public item(int wt, int value)
        {
            this.wt = wt;
            this.value = value;
            this.cost =   new Double((double)value/(double)wt);

        }
    }
}
