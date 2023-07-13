package RangeQueries.SengmentTree;

public class BasicST {
    private int[] tree;
    private int[] arr;
    private int max;

    public BasicST(int[] arr, int n)
    {
        this.arr =arr;
        this.max = n;
        tree = new int[4*max];
        buildTree(0, 0,n-1);
    }

    public void buildTree(int node, int start, int end)
    {
        if(start == end)
        {
            tree[node] = arr[start];
            return;
        }
        int mid = start + (end - start)/2;
        buildTree(2 * node + 1, start, mid);
        buildTree(2 * node + 2, mid +1, end);
        tree[node] = tree[2*node+1] + tree[2*node+2];
    }

    public int query(int l, int r)
    {
        return query(0, 0, max -1, l, r);
    }

    private int query(int node, int start, int end, int l, int r)
    {
        if(end < l || start > r)
        {
            return 0;
        }
        if(l >= start && r <= end)
        {
            return tree[node];
        }
        int mid = start + (end - start)/2;
        int leftSum = query(2 * node + 1, start, mid , l, r);
        int rightSum = query(2 * node +2, mid + 1, end , l, r);
        return leftSum + rightSum;

    }


    public void update(int node, int value)
    {
       update(node, 0, value, 0, max-1);
    }

    private void update(int node, int node1, int value, int start, int end)
    {
        if(start > node || end < node)
        {
            return;
        }
            tree[node1] += value;

        if(start != end )
        {
            int mid = start + (end - start) / 2;
            update(node, 2 * node1 + 1, value, start, mid);
            update(node, 2 * node1 + 2, value, mid + 1, end);
        }

    }


}
