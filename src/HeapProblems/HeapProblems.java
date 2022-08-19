package HeapProblems;

import java.util.*;

public class HeapProblems {

    public int jobScheduling(int[] deadline, int[] profits)
    {
        int n = deadline.length;
        Job[] jobs = new Job[n];
        for(int i = 0; i < n ; i++)
        {
            jobs[i] = new Job(deadline[i], profits[i]);
        }

        Arrays.sort(jobs, Comparator.comparingInt(o -> o.deadLine));

        PriorityQueue<Job> pq = new PriorityQueue<>(((o1, o2) -> o2.profit - o1.profit));
        List<Integer> li = new ArrayList<>();


        int slotAvailable = 0;
        for(int i = n-1; i >= 0 ; i--)
        {
            if(i == 0)
            {
                slotAvailable = jobs[i].deadLine;
            }
            else
            {
                slotAvailable = deadline[i] - deadline[i-1];
            }
            pq.add(jobs[i]);
            if(slotAvailable > 0)
            {
               var value = pq.remove();
               li.add(value.profit);
            }

        }

        int maxProfit = 0;
        for(var v : li)
        {
            maxProfit += v;
        }
            return maxProfit;
    }

    class Job
    {
        int deadLine;
        int profit;

        public Job(int deadline, int profit)
        {
            this.deadLine = deadline;
            this.profit = profit;
        }
    }
}
