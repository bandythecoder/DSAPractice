package RangeQueries.FenWickTree;

public class FenWickTree {

    private int[] arr;
    private int[] Btree;
    private int n;

    public FenWickTree(int[] arr)
    {
        int n = arr.length;
        Btree = new int[n + 1];
        this.arr = arr;
        this.n =n;
        constructBtree();
    }

    private void constructBtree()
    {
        for(int i = 0; i < n ; i++)
        {
            updateTree(i, arr[i]);
        }
    }

    public int getSumRange(int l , int r)
    {
        return getSum(r) - getSum(l-1);
    }

    private int getSum(int i) {
        int sum = 0;
        while(i > 0)
        {
            sum += Btree[i];
            i -= (i & (-i));
        }
        return sum;
    }

    private void updateTree(int i, int value)
    {
        i = i + 1;
        while(i <= n)
        {
            Btree[i] += value;
            i += (i & (-i));
        }
    }
}
