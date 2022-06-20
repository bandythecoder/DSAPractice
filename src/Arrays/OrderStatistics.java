package Arrays;

import java.util.*;

public class OrderStatistics {
    // Find Kth Largest bruteForce
// using Heap
    public int KthSmallest(int[] arr, int n, int k) {
        // Build a heap of kth element
        MaxHeap m = new MaxHeap(arr, k);
        for (int i = k; i < n; i++) {
            if (arr[i] < m.getMax()) m.replaceMax(i);

        }

        return m.getMax();

    }


    public int KthLargest(int[] arr, int n, int k) {
        // Build a heap of kth element
        minHeap m = new minHeap(arr, k);
        for (int i = k; i < n; i++) {
            if (arr[i] > m.getMin()) {
                m.replaceMin(i);
            }

        }
return m.getMin();
    }
    class minHeap
    {
        int[] harr;
        int heap_size;
        int parent(int i)
        {
            return (i - 1)/2;
        }

        int left(int i)
        {
            return (2 * i ) +1;
        }
        int right(int i)
        {
            return (2 * i ) +2;
        }

        int getMin()
        {
            return harr[0];
        }

        void replaceMin(int i)
        {
            harr[0] = harr[i];
            heapify(0);
        }

     public    minHeap(int[] arr, int size)
        {
            harr = arr;
            heap_size = size;

            for (int i =0 ; i < size/2; i++)
                    heapify(i);
        }

        private void heapify(int i)
        {
          int smallest = i;
          int left = left(i);
          int right = right(i);

          if(left < heap_size && harr[left] < harr[i])
          {
             i = left;
          }
            if(right < heap_size && harr[right] < harr[i])
            {
                i = right;
            }
            if(smallest != i)
            {
                var temp = harr[smallest];
                harr[smallest] = harr[i];
                harr[i] = temp;
                heapify(i);
            }
        }

    }
    class MaxHeap {
        int[] harr;
        int heap_size;

        int parent(int i) {
            return (i - 1) / 2;
        }

        int left(int i) {
            return (2 * i) + 1;
        }

        int right(int i) {
            return (2 * i) + 2;
        }

        int getMax() {
            return harr[0];
        }

        void replaceMax(int i) {
            harr[0] = i;
            heapify(0);
        }

        MaxHeap(int[] arr, int n) {
            heap_size = n;
            harr = arr;
            int i = n / 2 - 1;
            while (i >= 0) {
                heapify(i);
                i--;
            }

        }

        void heapify(int root) {
            int largest = root;
            int left = left(root);
            int right = right(root);
            if (left < heap_size && harr[largest] < harr[left]) {
                largest = left;
            }
            if (right < heap_size && harr[largest] < harr[right]) {
                largest = right;
            }
            if (largest != root) {
                int temp = harr[largest];
                harr[largest] = harr[root];
                harr[root] = temp;
                heapify(largest);
            }

        }


    }

    public static int kthSmallest(int[] arr, int l,
                                  int r, int k) {
        // If k is smaller than number of elements
        // in array
        if (k > 0 && k <= r - l + 1) {

            int pos = partition(arr, l, r);

            if (pos - l == k - 1)
                return arr[pos];

            if (pos - l > k - 1)
                return kthSmallest(arr, l, pos - 1, k);

            // Else recur for right subarray
            return kthSmallest(arr, pos + 1, r, k - pos + l - 1);
        }
        return Integer.MAX_VALUE;
    }
        public static int partition(int[] arr, int l, int r)
        {
            int x = arr[r], i = l;
            for (int j = l; j <= r - 1; j++) {
                if (arr[j] <= x) {
                    // Swapping arr[i] and arr[j]
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;

                    i++;
                }
            }

            // Swapping arr[i] and arr[r]
            int temp = arr[i];
            arr[i] = arr[r];
            arr[r] = temp;

            return i;
        }


        public static int FindLargest(int[] arr, int length)
        {
            int max = arr[0];
            for(int i = 1; i < length; i++)
            {
                if(arr[i] > max)
                {
                    max = Math.max(arr[i], max);
                }

            }
            return max;
        }

    public static int find2ndLargest(int[] arr, int length)
    {
       int first = Integer.MIN_VALUE;
       int Second = Integer.MAX_VALUE;
        for(int i = 0; i < length; i++)
        {
           if(arr[i] > first)
           {
               Second = first;
               first = arr[i];
           }
           if(arr[i] > Second)
           {
               Second = arr[i];
           }

        }
        return Second;
    }

    public static int MinProductofKinteger(int[] arr, int length, int k)
    {
       int l = 0;
       int r = arr.length -1;
       int pos = MinProduct(arr, l, r,  k);
        return pos;
    }

    private static int MinProduct(int[] arr, int l, int r, int k)
    {
        if(k > 0 && k <= r - l + 1 )
        {
            int pos = ParitionNew(arr, l ,r );
            if(pos - l == k -1 )
            {
                int product = 1;
                int number = arr[pos];
                for(int i = 0 ; i < arr.length ; i++)
                {
                    if(arr[i] <= number) product *= arr[i];

                }
                return product;
            }
            if(pos - l > k -1 )
              return   MinProduct(arr, l, pos -1 , k );
            else
              return   MinProduct(arr, pos +1, r, k - pos +l -1 );
        }
        return 0;

    }

    private static int ParitionNew(int[] arr, int l, int r)
    {
        int x = l -1;
        int pivot = arr[r];
        for(int i  = l ; i <= r ; i ++)
        {
          if (arr[i] <= pivot)
          {
              x++;
              int temp = arr[x];
              arr[x] = arr[i];
              arr[i] = temp;
          }

        }
        return x;
    }

    public static int findMaxContegiousSum(int[] arr, int length, int k)
    {
       // First Create Sum array w

        int[] sum = new int[length + 1];
        sum[0] = 0;
        sum[1] = arr[0];
        for(int i = 2; i <= length ; i ++ )
        {
            sum[i ] = sum[i-1] + arr[i-1];
        }
        PriorityQueue<Integer> q = new PriorityQueue<Integer>();
        for(int i = 1; i <= length; i++ )
        {
            for(int j = i; j <=length; j++)
            {
                int x = sum[j] - sum[i-1];
                if(q.size() < k)
                {
                    q.add(x);
                }
                else if (q.peek() < x)
                {
                    q.poll();
                    q.add(x);
                }

            }
        }
        return q.poll();

    }

    public static PriorityQueue<Integer> findMaxSumofTwoArrays(int[] arr,int[] arr1, int k)
    {
       PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
       for(int i =0; i < arr.length; i++)
       {
           for(int j = 0 ; j < arr1.length; j++)
           {
            var   x = arr[i] + arr1[j];
               if (queue.size() < k)
               {
                   queue.add(x);
               }
               else if (queue.peek() < x)
               {
                   queue.poll();
                   queue.add(x);
               }
           }
       }
       return queue;
    }

    public static int LargestSumOfContageousArray(int[] arr, int length)
    {
        int max_sum = Integer.MIN_VALUE, max_sumsofar = 0;
        int start = 0; int end =0; int s = 0;
        for(int i = 0; i < length ; i++)
        {
            max_sumsofar += arr[i];
        if(max_sum < max_sumsofar)
        {
            max_sum = max_sumsofar;
            start = s;
            end   = i;
        }
        if(max_sumsofar < 0)
        {
            max_sumsofar = 0;
            s= s+i;
        }
        }

        return max_sum;

    }

    public static void printSmall(int arr[], int n, int k)
    {
        // For each arr[i] find whether
        // it is a part of n-smallest
        // with insertion sort concept
        for (int i = k; i < n; ++i) {
            // Find largest from top n-element
            int max_var = arr[k - 1];
            int pos = k - 1;
            for (int j = k - 2; j >= 0; j--) {
                if (arr[j] > max_var) {
                    max_var = arr[j];
                    pos = j;
                }
            }

            // If largest is greater than arr[i]
            // shift all element one place left
            if (max_var > arr[i]) {
                int j = pos;
                while (j < k - 1) {
                    arr[j] = arr[j + 1];
                    j++;
                }
                // make arr[k-1] = arr[i]
                arr[k - 1] = arr[i];
            }
        }
        // print result
        for (int i = 0; i < k; i++)
            System.out.print(arr[i] + " ");
    }

    public static int  Find2ndLargest(int[] arr, int x)
    {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < x ; i++)
        {
            if(arr[i] > max)
            {
                max = arr[i];
            }
            if(arr[i] < min)
            {
                min = arr[i];
            }
        }
        return max;
    }

    public static int  MaxSumexcludingAdjusent(int[] arr, int x)
    {
        int inc = arr[0];
        int exc = 0;
        int exc_new ;
        for(int i = 1; i < x ; i ++)
        {
            exc_new = inc > exc ? inc : exc;
            inc = arr[i] + exc;
            exc = exc_new;
        }
        return Math.max(inc,exc);
    }
}