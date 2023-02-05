package Trees.DPonTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MaxNumberOfMatchingTree {
    public int[][] dp = new int[100000][2];
    public void MatchingTree(Map<Integer, List<Integer>> tree, int n, int src)
    {
        List<Integer> prefix = new ArrayList<>();
        List<Integer> suffix = new ArrayList<>();
        dp[src][0] = dp[src][1] = 0;
        boolean leaf = true;
        for(var v : tree.get(src))
        {
            leaf = false;
            MatchingTree(tree, n, v);
        }

        if(leaf) return;
        for(var v : tree.get(src))
        {
            prefix.add( Math.max(dp[v][0],dp[v][1]));
            suffix.add( Math.max(dp[v][0],dp[v][1]));
        }

        for(int i = 1; i < prefix.size(); i++)
        {
            prefix.set(i, prefix.get(i) + prefix.get(i-1));
        }

        for(int i = suffix.size() -2 ; i >= 0 ; i--)
        {
            suffix.set(i, suffix.get(i) + suffix.get(i+1));
        }
        dp[src][0] = suffix.get(0);
        int count = 0;
        for(var v : tree.get(src))
        {
          int left = count == 0 ? 0 : prefix.get(v-1);
          int right = count==n-1 ? 0 : suffix.get(v+1);
          dp[src][1] = Math.max(dp[src][1], 1 + left + right + dp[v][0]);
        }

    }
}
