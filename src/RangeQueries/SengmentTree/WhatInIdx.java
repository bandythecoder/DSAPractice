package RangeQueries.SengmentTree;

public class WhatInIdx {
    private int[] tree;
    private int[] arr;
    private int MAX;

    public WhatInIdx(int[] arr)
    {
        int n = arr.length;
        tree = new int[4 * n];
        this.arr = arr;
        MAX = n;
        build(0, n-1, 0);
    }

    private void build(int start, int end, int node)
    {
        if(start == end)
        {
            tree[node] = arr[start];
        }
        else
        {
            int mid = start + (end - start)/2;
            build(start, mid, 2 * node + 1);
            build(mid + 1, end, 2* node +2);
        }
    }

    public void update(int L, int R , int value)
    {
        int start = 0;
        int end = MAX-1;
        update(start, end, L, R, 0,  value);
    }

    private void update(int start, int end, int l, int r, int node, int value)
    {
        if(start > r || end < l) return;
        if(start == end)
        {
            tree[node] += value;
        }
        else if(start >= l && end <= r)
        {
            tree[node] += value;
        }
        else
        {
            int mid = start + (end-start)/2;
            update(start,mid, l, r, 2 * node + 1, value);
            update(mid+1,end, l, r, 2 * node + 2, value);
        }
    }
    
    public int query(int idx)
    {
        int start = 0;
        int end = MAX-1;
        return query(start, end, idx, 0);
        
    }

    private int query(int start, int end, int idx, int node)
    {
        propogate(node,start, end);
        if(start == end)
        {
            return tree[node];
        }
        else
        {
            int mid = start + (end- start)/2;
            if(start <= idx && mid >= idx)
            {
                return query(start, mid, idx, 2* node+1);
            }
            else
            {
                return query(mid+1,end, idx, 2* node+2);
            }
        }
    }

    private void propogate(int node, int start, int end)
    {
        if(start == end ) return;
        tree[2* node+1 ] += tree[node];
        tree[2* node+2 ] += tree[node];
        tree[node] = 0;
    }
}
