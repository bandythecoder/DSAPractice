package RangeQueries.SparseTable;

public class RangeSum {

    private int[][] st;
    int n;

    public void construct(int[] arr)
    {
        int n = arr.length;
        this.n = n;
        int k = (int)Math.ceil(Math.log(n)) + 1;
        st = new int[n][k];

        for(int i = 0; i < n ; i++)
        {
            st[i][0] = arr[i];
        }

        for(int i = 1 ; (1 << i) <= n ; i++)
        {
            for(int j = 0; j + (1 << i) -1 < n ; j++)
            {
                st[j][i] = st[j][i-1] + st[j + (1 << i-1)][i-1];
            }
        }
    }

    public int query(int l, int r)
    {
        int log = (int)Math.ceil(Math.log(r-l+1));
        int ans = 0;
        while(log >= 0 && l < r)
        {
            ans += st[l][log];
            l += (1<<log);
            log--;
        }
        return ans;
    }
}
