package Arrays;

import java.lang.module.FindException;
import java.security.PublicKey;
import java.util.Arrays;
import java.util.function.BiPredicate;

public class ArrayRotation {
    public static void RotateArray(int[] array, int d, int size) {/*
        // brute Method
        int[] arr = new int[2];
        for (int i = 0 ; i <d ; i++)
        {
            arr[i] = array[i];
        }
        for(int i = 0; i < size-d ; i++)
        {
            if(i < size -d)
            array[i] = array[i+d];

        }
        for(int i =0; i < d ; i++)
        {
            array[size-d +i]= arr[i] ;
        }*/
// Time complexity = 0(N) Space Complexity = 0(d)
        // RotateByOne
     /*  int temp = array[d];
       while (array[0] != temp)
        {
            int temp1 = array[0];
            for(int j = 0 ; j < size -1  ; j++)
            {
                array[j] = array[j+1];
            }
            array[size -1] = temp1;
        }*/

        // Space complexity 0(1) and Time complexity 0 (n * d)

        d = d % size;
        int gcd = RotationHelper.gcd(d, size);
        for (int i = 0; i < gcd; i++) {
            int temp = array[i];
            int j = i;
            while (true) {
                int k = j + d;
                if (k >= size)
                    k = k - size;
                if (k == i)
                    break;
                array[j] = array[k];
                j = k;

            }
            array[j] = temp;
        }

        //Time Complexity 0(n) space complexity O(1)
    }

    // Ratate Array using reversal
    public static void RotateArrayusingReversalMethod(int[] arr, int d, int size) {
        RotationHelper.ReverseArray(arr, 0, d);
        RotationHelper.ReverseArray(arr, d + 1, size);
        RotationHelper.ReverseArray(arr, 0, size);
    }

    public static void RotateArrayusingBlockSwap(int[] arr, int d, int size) {
        d = d % size;

        RotateArray(arr, 0, d, size);
    }

    public static void cyclicallyRotateAnArray(int[] arr, int d, int size) {
        int temp = arr[size - 1];
        // shift all the elements
        for (int i = size - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = temp;
    }


    static void RotateArray(int[] arr, int i, int d, int size) {
        d = d % size;
        if (size - d == d) {
            RotationHelper.Swap(arr, i, i + d, d);
            return;
        }
        if (size - d > d) {
            RotationHelper.Swap(arr, i, size - d + i, d);
            RotateArray(arr, i, d, size - d);
        } else {
            RotationHelper.Swap(arr, i, d, size - d);
            RotateArray(arr, size - d + i, 2 * d - size, d);
        }

    }


    public static int FindandElementinSortedArraywhichisRorated(int[] arr, int size, int key) {
       int pivot = findPivot(arr, 0 , size -1);
       if(arr[pivot] == key) return pivot;

        if (pivot == -1)
            return BinarySearch(arr, 0, size - 1, key);
       if(arr[0] > key && arr[pivot] > key) return BinarySearch(arr,pivot +1, size-1,key);
       return BinarySearch(arr, 0, pivot -1 , key);
    }
    private static int search(int[] arr, int l, int h, int key)
    {
        if (l > h)
            return -1;

        int mid = (l + h) / 2;
        if (arr[mid] == key)
            return mid;
        if (arr[l] <= arr[mid]) {
            /* As this subarray is sorted, we
               can quickly check if key lies in  34567812
               half or other half */
            if (key >= arr[l] && key <= arr[mid])
                return search(arr, l, mid - 1, key);
            /*If key not lies in first half subarray,
           Divide other half  into two subarrays,
           such that we can quickly check if key lies 56789321
           in other half */
            return search(arr, mid + 1, h, key);
        }

        /* If arr[l..mid] first subarray is not sorted,
           then arr[mid... h] must be sorted subarry*/
        if (key >= arr[mid] && key <= arr[h])
            return search(arr, mid + 1, h, key);

        return search(arr, l, mid - 1, key);



    }


    private static int findPivot(int[] arr, int low, int high)
    {
        if(high < low ) return -1;
        if(high == low ) return low;
        int mid = (low + high) /2;
        if(mid < high && arr[mid] > arr[mid +1]) return mid;
        if(mid > low && arr[mid] < arr[mid-1]) return mid -1;
        if(arr[low] > arr[mid]) return findPivot(arr,low, mid -1);
      return   findPivot(arr, mid +1, high );

    }
    private static int BinarySearch(int[] arr, int low, int high, int key)
    {
        if(high < low ) return -1;

        int mid = (low + high) /2;

        if(arr[mid] == key) return mid;
        if(arr[mid] > key) return BinarySearch(arr, low , mid -1,key);
        return BinarySearch(arr,mid+1,high,key);


    }

    public static int NumberOfRotationTofindMaxSum(int[] arr, int size)
    {
        int curValue = 0, maxValue = 0;
        int arrSum = 0;
        for(int i =0; i < size ; i++)
        {
            arrSum =  arrSum + arr[i];
            curValue = curValue + i * arr[i];
        }

        maxValue = curValue;
        for (int i = 1; i < size  ; i++)
        {
            curValue = curValue + arrSum - (size * arr[size - i]);
            if(curValue > maxValue) maxValue = curValue;
        }
        return maxValue;

    }

    //Input : arr[] = {15, 18, 2, 3, 6, 12}

    public static int FindNumberofRotations(int[] arr, int size)
    {
        return SearchNumberOfRotations(arr,0, size-1) + 1;

    }

static int SearchNumberOfRotations(int[] arr, int l , int h)
{
    if(l > h) return -1;
    int mid =  (l + h) /2;
    if(mid < h && arr[mid] > arr[mid +1]) return mid ;
    if(l < mid && arr[mid - 1] > arr[mid]) return mid -1;
    if(arr[l] > arr[mid]) return SearchNumberOfRotations(arr, l, mid -1 );
    else return SearchNumberOfRotations(arr, mid + 1, h);

}

  public  static int maxHamming(int arr[], int n)
    {
        // arr[] to brr[] two times so that
        // we can traverse through all rotations.
        int brr[]=new int[2 *n + 1];
        for (int i = 0; i < n; i++)
            brr[i] = arr[i];
        for (int i = 0; i < n; i++)
            brr[n+i] = arr[i];

        // We know hamming distance with
        // 0 rotation would be 0.
        int maxHam = 0;

        // We try other rotations one by one
        // and compute Hamming distance
        // of every rotation
        for (int i = 1; i < n; i++)
        {
            int currHam = 0;
            for (int j = i, k=0; j < (i + n); j++,
                    k++)
                if (brr[j] != arr[k])
                    currHam++;

            // We can never get more than n.
            if (currHam == n)
                return n;

            maxHam = Math.max(maxHam, currHam);
        }

        return maxHam;
    }

    //11,15,6,7,89
    public static boolean FindPairSum(int[] arr, int size,int Sum)
    {
        int pivot = findPivot(arr, 0, size);
        int Left = pivot +1;
        int Right = pivot;
        return FindPairSum(arr, size, Sum, Left, Right);

    }

    public static Boolean FindPairSumUnsortedArray(int[] arr, int size,int Sum)
    {
        Arrays.sort(arr);
        return FindPairSum(arr, size, Sum, 0, size-1);
    }

    // This is called 2 pointer Technique
    private static boolean FindPairSum(int[] arr, int size, int Sum, int left, int right) {
        while(left != right)
        {
            if(arr[left] + arr[right] == Sum) return true;
            if(arr[left] + arr[right] > Sum) right = (size + right - 1) % size;
            if(arr[left] + arr[right] < Sum) left = (left + 1) % size;

        }
        return false;
    }

    // Sling Window
    public static int FindMaxSumtillKthElement(int[] a , int size, int k)
    {
        int windowSum = 0;
        int maxSum = 0;
        for(int i = 0 ; i < k ; i++)
        {
            windowSum = windowSum + a[i];
        }
        maxSum = windowSum;

        for(int index = 1; index <= size - k; index++)
        {
            windowSum = windowSum + a[size - k + 1] - a[index -1];
            maxSum = Math.max(windowSum,maxSum);
        }
        return maxSum;
    }
    public static int longestOnes(int[] nums, int k) {
        int windowsize = 0;
        int value = 0;
        int TotelonesincurrentWinow = 0;
        int maxones = 0;
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 0) value++;

            windowsize++;
            if (value == k) break;

        }
        maxones = windowsize;
        for (int i = 0, j = windowsize; j < nums.length; ++i, ++j) {
            if (nums[i] > 0) windowsize--;
            if (nums[j] > 0) windowsize++;
            maxones = Math.max(maxones, windowsize);
        }
        return maxones;

    }
//6123
    //

}




