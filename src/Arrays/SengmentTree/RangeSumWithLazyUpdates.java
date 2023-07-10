package Arrays.SengmentTree;

public class RangeSumWithLazyUpdates {
    private  int[] lazy;
    private int[] tree;
    private int[] input;
    private int MAX;

    public RangeSumWithLazyUpdates(int[] arr)
    {
        input = arr;
        MAX = arr.length;
        tree = new int[4 * MAX];
        lazy = new int[4* MAX];
        build(0, MAX-1, 0);
    }

    private void build(int start, int end, int node)
    {
        if(start == end)
        {
            tree[node] = input[start];
        }
        else
        {
            int mid = start + (end-start)/2;
            build(start, mid, 2 * node+1);
            build(mid+1,end , 2* node+2);
            tree[node] = tree[2* node+1] + tree[2*node+2];
        }
    }

    public void update(int left, int right, int value)
    {
        update(0,MAX-1,left,right,0,value);
    }
    public int RangeSum(int left, int right)
    {
      return query(0, MAX-1, left, right, 0);
    }
    private int query(int start, int end , int L , int R, int node)
    {
        propogate(node, start, end);
        if(start > R || end < L)
        {

            return 0 ;
        }
        if(start == end)
        {
            return tree[node];
        }
        else if(start >= L && end <= R)
        {
            return tree[node];
        }
        else
        {
            int mid = start + (end-start)/2;
            int left  = query(start, mid, L, R, 2 * node +1);
            int right = query(mid+1, end, L, R, 2 * node +2);
            return left + right;
        }
    }

    private void update(int start, int end, int L, int R, int node, int value)
    {
        if(start > R || end < L)
        {
            propogate(node, start, end);
            return;
        }
        if(start == end)
        {
            lazy[node] += value;

        }
        else if(start >= L && end <= R)
        {
            lazy[node] += value;
            propogate(node, start, end);
        }
        else
        {
            int mid = start + (end-start)/2;
            update(start, mid,L,R, 2 * node+1,value);
            update(mid+1,end ,L,R, 2* node+2,value);
            tree[node] = tree[2* node+1] + tree[node+2];
        }
    }

    private void propogate(int node, int start, int end)
    {
        if(start == end)
        {
            tree[node] += lazy[node];
        }
        else
        {
            tree[node] += (end - start + 1) * lazy[node];
            lazy[2* node +1] += lazy[node];
            lazy[2* node +2] += lazy[node];
            lazy[node] = 0;
        }
    }
}
