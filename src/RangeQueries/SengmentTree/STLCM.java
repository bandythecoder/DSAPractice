package RangeQueries.SengmentTree;


public class STLCM {
    
    private int[] arr;
    private int[] tree;
    private int MAX;
    
    public STLCM(int[] arr)
    {
        int n = arr.length;
        MAX = n;
        this.arr = arr;
        tree = new int[4*n];
        buildTree(arr, 0, 0, n-1);
    }

    private void buildTree(int[] arr, int node, int start, int end)
    {
        if(start == end)
        {
            tree[node] = arr[start];
            return;
        }
        int mid = start + (end - start)/2;
        buildTree(arr, 2 * node + 1, start, mid);
        buildTree(arr, 2 * node +2, mid +1 , end);
        tree[node] = lcm(tree[node * 2 + 1], tree[node * 2 + 2]);
    }

    public int query(int l, int r)
    {
        int i = 0;
        int j = MAX -1;
        return query(i, j, l, r, 0);
    }

    public void update(int index, int value)
    {
        arr[index] = value;
        update(0, MAX-1, 0, index, value);
    }

    private void update(int start, int end,int node, int index, int value)
    {
        if(start > index || end < index)
        {
            return;
        }
        if(start == end)
        {
            tree[node] = value;
        }

        if(start != end)
        {
            int mid = start + (end - start)/2;
            update(start, mid, 2 * node + 1,index, value);
            update(mid+1, end, 2 * node + 2,index, value);
            tree[node] = lcm(tree[2 * node + 1], tree[2 * node + 2]);
        }

    }

    private int query(int start, int end, int l, int r, int node)
    {
        if(end < l || start > r)
        {
            return 1;
        }
        if(start >= l && end <= r)
        {
            return tree[node];
        }
        int mid = start + (end - start)/2;
        int left = query(start, mid, l , r, 2 * node + 1);
        int right = query(mid + 1, end, l , r, 2 * node + 2);
        return lcm(left, right);
    }

    private int lcm(int a , int b)
    {
        return (a * b)/gcd(a,b);
    }

    private int gcd(int a, int b)
    {
        if(b == 0) return a;
        return gcd(b, a%b);
    }
}
