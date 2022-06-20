package Arrays;

import java.security.PublicKey;

public class SegmentTree
{
     int[] tree = new int[2000];
     int[] Lazy = new int[2000];
     int arr[] = new int[500];

    public SegmentTree(int[] arr)
    {
        this.arr = arr;
    }

    public  void buildSegmentTree(int node, int start, int end)
    {
        if(start == end)
        {
            tree[node] = arr[start];
            return ;
        }
        int mid = (start + end)/2;
        buildSegmentTree(2 * node + 1, start, mid);
        buildSegmentTree(2 * node + 2, mid +1, end);
        int left_LCM = tree[2 * node + 1];
        int right_LCM = tree[2 * node + 2];
        tree[node] = LCM(left_LCM,right_LCM);

    }

    private static int LCM(int a, int b)
    {
        return  (a * b)/ g_cd(a,b);
    }

    private static int g_cd(int a, int b)
    {
        if(b==0) return a;
        return g_cd(b , a%b);
    }

    public void buildSegmentTreeSum(int node, int start, int end)
    {
        if(start == end)
        {
            tree[node] = arr[start];
            return;
        }
        int mid = (start + end)/2;
        buildSegmentTreeSum(2*node + 1,start, mid);
        buildSegmentTreeSum(2*node+2, mid+1, end);
        int left_Sum = tree[2 * node + 1];
        int right_Sum = tree[2* node +2];

        tree[node] = left_Sum + right_Sum;
    }

  public   int query(int node, int start, int end, int l, int r)
  {
      if(r < start || l > end )
      {
          return 0;
      }
      if(l <= start && r >= end)
      {
          return tree[node];
      }
      int mid = (start + end) /2;
      int leftSum = query(2 * node +1 , start, mid,l,r);
      int rightSum = query(2 * node +2 , mid + 1, end,l,r);
      return leftSum + rightSum;
  }

  public void BuildSegmentTreeLCM(int node, int start, int end)
  {
      if(start > end)
      {
          return;
      }
      if(end == start)
      {
          tree[node] = arr[start];
          return;
      }
      int mid = (start + end )/2;
       BuildSegmentTreeLCM(2 *node +1 , start, mid );
      BuildSegmentTreeLCM(2 *node +2 , mid +1, end );
      int LCM = LCM(tree[2* node +1], tree[2*node +2]);
      tree[node] = LCM;
  }
   public int queryLCM(int node, int start, int end , int l, int r)
   {
       if(l > end || r < start)
       {
           return 1;
       }
       if(l <= start && r >= end)
       {
           return tree[node];
       }
       int mid = (start + end )/2;
       int left_LCM = queryLCM(2 * node +1, start , mid, l, r);
       int Right = queryLCM(2 * node +2, mid + 1 , end, l, r);
       return LCM(left_LCM,Right);

   }

   public void buildSegmentTreeMinimum(int node, int start, int end)
   {
       if(start > end)
       {
           return;
       }
       if(start == end)
       {
           tree[node] = arr[start];
           return;
       }
       int mid = (start + end)/2;
       buildSegmentTreeMinimum(2* node +1, start, mid);
       buildSegmentTreeMinimum(2 * node +2 , mid +1, end);
       tree[node] = Math.min(tree[2*node +1], tree[2*node +2]);
   }

   public int queryMinimum(int node, int start, int end , int left, int right)
   {
       if(left > end || right < start)
       {
           return Integer.MAX_VALUE;
       }
       if(left <= start && right >= end)
       {
           return tree[node];
       }
       int mid = (start + end)/2;
       int left_min = queryMinimum(2 * node +1, 0, mid, left,right);
       int right_min = queryMinimum(2 * node +2, mid +1 , end,left, right);
       return Math.min(left_min,right_min);
   }

   public  void updateSegmentTreeSum(int nodetoUpdate, int updateValue,int start, int end, int node)
   {
       if(nodetoUpdate < start || nodetoUpdate > end) return;
        if(start == end)
        {
            tree[node] += updateValue;
            return;
        }



       if(start!=end) {
           int mid = (start+end)/2;
         updateSegmentTreeSum(nodetoUpdate, updateValue, start, mid, 2 * node +1 );
          updateSegmentTreeSum(nodetoUpdate, updateValue, mid + 1, end, 2*node+2);
       }
       tree[node] = tree[2* node + 1] + tree[2*node + 2];
   }


   public void updateSegmentLazy(int nodeUpdateStart, int nodeUpdateEnd, int updateValue, int start, int end , int node)
   {
       if(Lazy[node] != 0)
       {
           tree[node] += (end - start + 1) * Lazy[node];
           if(start != end)
           {
               Lazy[2 * node + 1] = updateValue;
               Lazy[2 * node + 2] = updateValue;
           }
       }
       if(start > end || nodeUpdateStart > end || nodeUpdateEnd < start)
           return;
       if(nodeUpdateStart <= start && nodeUpdateEnd >= end)
       {
           tree[node] += (end - start + 1) * updateValue;
           if(start != end)
           {
               Lazy[2 * node + 1] = updateValue;
               Lazy[2 * node + 2] = updateValue;
           }
           return;
       }
       int mid = (start+end)/2;
       updateSegmentLazy(nodeUpdateStart, nodeUpdateEnd,updateValue,start, mid, 2 * node +1);
       updateSegmentLazy(nodeUpdateStart, nodeUpdateEnd,updateValue,mid+1, end, 2 * node +2);

       tree[node] = tree[2 * node + 1] + tree[2 * node +2];
   }


   public void buildSegmentTreeMaxOccurance(int node, int start, int end)
   {
       if(start > end)
       {
           return;
       }
       if(start == end)
       {
           tree[node] = 1;
           return;
       }
       tree[node] = findFrequency(start,end);
       int mid = (start + end)/2;
       buildSegmentTreeMaxOccurance(2 * node +1, start, mid);
       buildSegmentTreeMaxOccurance(2 * node +2, mid + 1, end);

   }

    private int findFrequency(int start, int end)
    {
        int count = 1;
        int MaxCount = 1;
        if(arr[start] == arr[end])
        {
            count = end - start +1;
        }
        else {

            for (int i = start + 1; i <= end; i++)
            {
                if(arr[i -1] == arr[i])
                {
                    count ++;
                }
                else
                {
                    MaxCount = Math.max(count,MaxCount);
                    count = 1;
                }

            }

        }
        return Math.max(count,MaxCount);
    }

    public int Query(int node, int start, int end, int l , int r)
    {
       // No Overlap
        if(l > end || r < start)
        {
            return 0;
        }
        // Complete Overlap
        if(l <= start && r >= end)
        {
            return tree[node];
        }
        int mid = (start + end)/2;
        int left = query(2 * node + 1, start , mid, l ,r );
        int right = query(2 * node + 2, mid +1, end, l ,r );
        return  Math.max(left,right);
    }


}
