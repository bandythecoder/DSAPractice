package GraphProblems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NumberOfSwapsToSortAnArray {

    public int numOfSwaps(int[] arr)
    {
        int swap = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i < arr.length; i++)
        {
            map.put(arr[i], i);

        }
        Arrays.sort(arr);
        boolean[] arr1 = new boolean[arr.length];
        int ans = 0;
        for(int i = 0 ; i < arr.length; i++)
        {
            if(arr1[i] == true || map.get(arr[i]) == i) {
                continue;
            }
            if(arr1[i] == false)
            {
                int j = i;
                while (arr1[j] == false)
                {
                    arr1[j] = true;
                    ans++;
                    j =map.get(arr[j]);

                }
                ans--;
            }


        }
        return ans ;
    }
}
