package Arrays;

import java.lang.reflect.Array;
import java.util.*;

public class ABC {
    public static void swap(int[] arr, int i, int j) {
        var temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

   public int KthMaxSumOfContegiousArray(int[] arr, int k) {
        //5,5,10,100,10,5
         int inc = arr[0];
         int exc = 0;

         for(int i = 1; i < arr.length; i++)
         {
             int incPrev = inc;
             inc = exc + arr[i];

             exc = Math.max(exc,incPrev);

         }

         return Math.max(inc,exc);
   }
   }








