package RangeQueries.SparseTable;

public class minSum {

     int st[][];

    public  void constructST(int arr[], int n)
    {
        // Add your code here
        int k = (int)(Math.ceil(Math.log(n))) + 1;

        st = new int[n][k];

        for(int i = 0; i < n ; i++)
        {
            st[i][0] = arr[i];
        }

        for(int i = 1 ; (1 << i) <= n ; i++)
        {
            for(int j = 0; j + (1 << i) -1 < n ; j++)
            {
                st[j][i] = Math.min( st[j][i-1], st[j + (1 << i-1)][i-1]);
            }
        }
    }


    public int  RMQ(int l, int r)
    {
         int log = (int)Math.log(r-l+1);
         return Math.min(st[l][log], st[r - (1 << log) +1 ][log]);
    }

}
