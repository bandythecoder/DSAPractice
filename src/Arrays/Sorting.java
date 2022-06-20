package Arrays;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Sorting
{
    public void alternateSorting(int[] arr)
    {
        Arrays.sort(arr);
        int start = 0;
        int end = arr.length - 1;
        Boolean flag = true;
        while (start < end)
        {
            if(flag)
            {
                System.out.println(arr[end]);
                end--;
                flag = false;

            }
            else
            {
                System.out.println(arr[start]);
                start++;
                flag= true;
            }
        }

    }


}
