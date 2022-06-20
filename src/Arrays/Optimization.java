package Arrays;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
 import java.util.Arrays;
import java.util.List;

public class Optimization
{
    public int findMaximumSum(int[] arr)
    {
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++)
        {
            sum += arr[i];
            if(maxSum < sum)
            {
                maxSum = sum;
            }
            if(sum < 0)
            {
                sum = 0;
            }
        }
        return maxSum;
    }

    public int findLeastAvg(int[] arr, int k)
    {
        int sum = 0;
        int min = Integer.MIN_VALUE;
        int index = 0;
        for(int i = 0; i < k; i++)
        {
            min += arr[i];


        }
        for(int i = 1; i + k < arr.length; i++)
        {
            sum = min - arr[i-1] + arr[i+k];
            if(sum < min)
            {
                min = sum;
                index = i;
            }

        }
        return index;
    }

    public int findMinimumDistance(int[] arr, int x, int y)
    {
        int prev = -1;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i] == x || arr[i] == y)
            {
                if(prev != -1 && arr[prev] != arr[i])
                {
                    min = Math.min(i - prev,min);
                }
                prev = i;
            }

        }
        return min;
    }

    public int findSmallestSubArray(int[] array, int x)
    {
        int start = 0; int end = 0;
        int length = array.length;
        int subArrayLength = Integer.MAX_VALUE;
        int sum = 0;
        while(end < length)
        {
            if(sum <= x )
            {
                sum += array[end++];
            }
           else
            {
                subArrayLength = Math.min(subArrayLength,end-start);
                sum -=array[start++];
            }

        }
        return subArrayLength;
    }

    public int findNumberofOperations(int[] targetArray)
    {
        int zeroCount = 0;
        int numberofSteps = 0;
        int i = 0;

        while(true)
        {
            for( i = 0; i < targetArray.length; i ++)
            {
                if(targetArray[i] % 2 != 0)
                {
                    break;
                }
                if(targetArray[i] == 0)
                {
                    zeroCount++;
                }
            }
            if(i == targetArray.length && zeroCount != targetArray.length)
            {
                for(int j  = 0; j < targetArray.length ;  j++ )
                {
                    targetArray[j] = targetArray[j] /2;

                }
                numberofSteps++;
            }
            if(zeroCount == targetArray.length)
            {
                break;
            }
            if(i != targetArray.length) {
                for (int j = i; j < targetArray.length; j++) {
                        if(targetArray[j] % 2 != 0)
                        {
                            targetArray[j] = targetArray[j] - 1;
                            numberofSteps++;
                        }
                }
            }
        }
return numberofSteps;
    }

    public int findMinDistance(int[] arr, int x , int y)
    {
       int prev = -1;
       int min = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i] == x || arr[i] == y)
            {
                if(prev != -1 && arr[prev] != arr[i])

                {
                 min = Math.min(min, i - prev);
                }
              prev = i;
                }
            }
        return min;
        }

   public int minimumOperation(int[] arr, int i, int j, int numberOfOperation)
   {
       if(j < i) return numberOfOperation;
       if(arr[i] == arr[j])
       {
        return    minimumOperation(arr, i+1, j-1, numberOfOperation);
       }
       else
       {
           if(arr[i] > arr[j])
           {
               arr[j-1] = arr[j] + arr[j-1];
               return minimumOperation(arr,i,j-1,numberOfOperation + 1);
           }
           else
           {
               arr[i] = arr[i] + arr[i+1];
               return minimumOperation(arr,i+1,j,numberOfOperation + 1);
           }
       }




   }
    public int findProductLessThanK(int[] arr,int product)
    {
        int ans = 0;
        int i = 0;
        Arrays.sort(arr);
        for( i = 0; i < arr.length ; i++)
        {
            if(arr[i] < product)
            {
                ans++;
            }
        }
        int j = 0;
        int mid = (i)/2;
        List<Double> Half = new ArrayList<>();
        List<Double> SecondHalf = new ArrayList<>();

        while (j < mid)
        {
            int k = 0;
            for(k = j+1; k < i; k++)
            {
                Half.add((double) (arr[j] * arr[k]));

            }
            j++;
        }

        while (j <= i)
        {
            int k = 0;
            for(k = j+1; k < i; k++)
            {

                    SecondHalf.add((double) (arr[j] * arr[k]));


            }
            j++;
        }
         return ans;
    }

    public void minJumps(int[] arr, int[] jump, int n)
    {

        if(arr[0] == 0) return ;


        for(int i = 1; i <= n ; i++)
        {
            for(int j = 0; j < i ; j++)

                if(arr[j] + j >= i)
                {
                    jump[i] = jump[j] +1;

                    break;
                }

            }

            return ;
        }

        public int longestLargestSequence(int[] arr, int n)
        {
            int[] DP = new int[n +1];
            if(n == 0) return arr[0];
            DP[0] = arr[0];
            int overAllMax = 0;
            for(int i  = 0; i <= n ; i++)
            {
                int max = 0;
                for(int j = 0 ; j < i ; j++)
                {
                    if(arr[j] < arr[i])
                    {
                        max = Math.max(DP[j] + arr[i] , max);
                        DP[i] = max;
                    }
                }
                overAllMax = Math.max(overAllMax, DP[i]);
            }
            return overAllMax;
        }
 }



