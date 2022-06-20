package Arrays;

public class BinaryIndexTree {
    int[] array ;
    int[] BTree;
    int Length;
    public BinaryIndexTree(int[] array, int len)
    {
        this.array = array;
        this.Length = len;
    }

    public void constructBIndexTree()
    {
        BTree = new int[Length + 1];
        for(int i = 0; i < Length ; i++)
        {
            updateBTree(i, array[i]);
        }

    }

    public int getSum(int index)
    {
        int sum = 0;
        index = index+1;
        for(int i = index; i > 0 ; i -= (i) & (-i))
        {
            sum += BTree[i];
        }
        return sum;
    }


    private void updateBTree(int i, int value)
    {
        i = i +1;
        while(i < Length + 1)
        {
            BTree[i] += value;
            i += i & (-i);

        }

    }
}
