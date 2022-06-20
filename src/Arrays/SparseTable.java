package Arrays;

public class SparseTable {

    public int[][] buildSparseTable(int[] array, int n)
    {

        int k = (int) Math.ceil( Math.log(n)) + 1;
        int[][] sparseTable = new int[n][k] ;
        for(int i = 0; i < n ; i++)
        {
            sparseTable[i][0] = array[i];
        }

        for(int j  = 1; (1 << j) < n ; j++)
        {
            for(int i = 0; i + ( 1 << j) -1 < n ; i++ )
            {
                sparseTable[i][j] =  gcd(sparseTable[i][j-1] ,sparseTable[(1 << j-1) + i][j-1] );
            }
        }
        return sparseTable;

    }

    int gcd(int a , int b)
    {
        if(b == 0) return a;
        return gcd(b, a %b);
    }

public int gcd(int[][] sparse, int l, int r)
{
    int k = (int) (Math.log(r -l +1 ));
    return  gcd(sparse[l][k], sparse[r-(1<<k) + 1][k]);
}
}
