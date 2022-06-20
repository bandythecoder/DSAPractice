package Arrays;

import javax.swing.plaf.IconUIResource;
import java.util.HashMap;
import java.util.Map;

public class SearchingProblems
{
    public boolean findNumber(int[] arr, int num)
    {
      int value =    binarySearchX(arr, 0, arr.length -1 , num);
      return value == 1 ? true : false;
    }

    private int binarySearchX(int[] arr, int l, int r, int num)
    {
        if( l <= r)
        {
            int mid  = (l + r)/2;
            if(arr[mid] == num) return 1;
            if(arr[mid] > num)
            {
                return binarySearchX(arr, l, mid-1, num);
            }
            return binarySearchX(arr, mid +1, r, num);
        }

     return 0;
    }

    public int findMaxSumContagiousArrAY(int[] arr1, int arr[])
    {
        Map<Integer,Integer> value = new HashMap<>();
        for(int i = 0; i < arr.length; i++)
        {
            value.put(arr[i], 1);
        }
        int max_so_far = 0;
        int max = Integer.MIN_VALUE;
        for(int i =0 ; i < arr1.length; i++)
        {
            max_so_far += arr1[i];

            if(max < max_so_far && value.get(arr1[i]) == null )
            {
                max = max_so_far;
            }
            if(max_so_far < 0 || value.get(arr1[i]) != null )
            {
                max_so_far = 0;
            }
        }
  return max;
    }

    // Find MajorityElement Using Moore's voting algo

    public void FindMajorityElement(int[] arr)
    {
        int value = findCandidate( arr);
        int count = 0;
        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i] == value) count++;
        }
        if( count > arr.length /2)
        {
            System.out.println(value);
        }
        else
        {
            System.out.println("No majority Element");
        }
    }

    private int findCandidate(int[] arr)
    {
        int count  = 1;
        int candidate = arr[0];
        for(int i = 1; i < arr.length ; i++)
        {
         if(arr[i] == candidate) count++;
         else
         {
             count--;
             if(count == 0)
             {
                 candidate = arr[i];
                 count++;
             }

         }

        }
        return candidate;
    }

    public int findFixedPoint(int[] arr)
    {
        int value = binarySearchFixedPoint(arr, 0 , arr.length-1);
        return value;
    }

    private int binarySearchFixedPoint(int[] arr, int low, int high)
    {
        if(low > high) return -1;
        int result = -1;
        int mid = (low + high)/2;
        if(arr[mid] == mid) return mid;
        if(mid + 1 <= arr[high])
        {
             result = binarySearchFixedPoint(arr, mid + 1, high);
        }
        if(result != -1) return result;
        if(mid -1 >= arr[low])
        {
            result = binarySearchFixedPoint(arr, low, mid-1);
        }
        return result;
    }
}
