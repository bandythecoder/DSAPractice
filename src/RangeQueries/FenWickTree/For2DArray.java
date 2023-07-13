package RangeQueries.FenWickTree;

public class For2DArray {

    private int[][] arr;
    private int[][] bArray;
    int row;
    int column;

    public For2DArray(int[][] arr)
    {
        this.row = arr.length;
        this.column = arr[0].length;
        bArray = new int[row+1][column+1];
        this.arr = arr;
        constrctBtree();
       var x = rangeSum(3,3) - rangeSum(1,3) - rangeSum(3,1) + rangeSum(1,1);

    }

    private void constrctBtree()
    {
        for(int i = 0; i < row; i++)
        {
            for(int j = 0; j < column; j++)
            {
                updateTree(i, j, arr[i][j]);
            }
        }
    }

    public int rangeSum(int i, int j, int i1, int j1)
    {
        return rangeSum(i1,j1) - rangeSum(i1, j-1) - rangeSum(i, j-1) + rangeSum(i-1,j-1);
    }

    private int rangeSum(int i, int j)
    {
        int sum = 0;
        while(i > 0)
        {
            int j1 = j;
            while(j1 > 0)
            {
                sum += bArray[i][j1];
                j1 -= (j1 & (-j1));
            }
            i -= (i & (-i));
        }
        return sum;
    }

    private void updateTree(int i, int j, int value)
    {
        i = i+1;
        j = j+1;
        while(i <= row)
        {
            int j1 = j;
            while(j1 <= column)
            {
                bArray[i][j1] += value;
                j1 += (j1 & (-j1));
            }
            i += (i & (-i));
        }
    }
}
