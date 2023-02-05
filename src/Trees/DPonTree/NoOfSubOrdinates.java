package Trees.DPonTree;

import java.util.List;
import java.util.Map;

public class NoOfSubOrdinates {

    public int[] returnAns(Map<Integer, List<Integer>> map, int n, int src)
    {
        int[] ans = new int[n + 1];
        numOfSubordinates(map,n,src,ans);
        return ans;
    }

    public int numOfSubordinates(Map<Integer, List<Integer>> map, int n, int src,int[] ans)
    {
        int value = 0;
        ans[src] = value;
       return value;
    }
}
