package RangeQueries.SQRTDecompositionTecnique;

import java.util.Arrays;

public class SQRTDecompositionMin {
    private int[] arr;
    private  int[] sqrtArr;
    private int rootN;
    private int N;

    public SQRTDecompositionMin(int[] arr)
    {
       this.arr = arr;
       this.N = arr.length;

       this.rootN = (int) Math.ceil(Math.sqrt(this.N));
        this.sqrtArr = new int[this.rootN];
       buildSQRTArray();
    }

    private void buildSQRTArray()
    {
        Arrays.fill(sqrtArr, Integer.MAX_VALUE);
        for(int i = 0; i < N ; i++)
        {
            sqrtArr[i/rootN] = Math.min(arr[i/rootN], arr[i]);
        }
    }

    public int findMin(int L, int R)
    {
        return getMin(L,R);
    }

    private int getMin(int l, int r)
    {
        int ans = Integer.MAX_VALUE;
        while(l<=r)
        {
            if(l%rootN == 0 && l + rootN -1 <= r)
            {
                ans = Math.min(ans, sqrtArr[l/rootN]);
                l += rootN;
            }
            else
            {
                ans = Math.min(ans, arr[l]);
                l++;
            }
        }
        return ans;
    }

}
