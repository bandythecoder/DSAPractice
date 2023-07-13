package RangeQueries.SQRTDecompositionTecnique;

import java.util.Arrays;

public class RangeSum {

    private int[] arr;
    private  int[] sqrtArr;
    private int rootN;
    private int N;

    public RangeSum(int[] arr)
    {
        this.arr = arr;
        this.N = arr.length;

        this.rootN = (int) Math.ceil(Math.sqrt(this.N));
        this.sqrtArr = new int[this.rootN];
        buildSQRTArray();
    }

    private void buildSQRTArray()
    {
        for(int i = 0; i < N ; i++)
        {
            sqrtArr[i/rootN] += arr[i];
        }
    }

    public int findSum(int L, int R)
    {
        return getSum(L,R);
    }

    private int getSum(int l, int r)
    {
        int ans = 0;
        while(l<=r)
        {
            if(l%rootN == 0 && l + rootN -1 <= r)
            {
                ans += sqrtArr[l/rootN];
                l += rootN;
            }
            else
            {
                ans += arr[l];
                l++;
            }
        }
        return ans;
    }
}
