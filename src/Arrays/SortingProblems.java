package Arrays;


import java.util.*;
import java.util.stream.Collectors;


public class SortingProblems
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
        if(start == end)
        {
            System.out.println(arr[end]);
        }

    }


    public void sortKDistanceNodes(int[] arr, int k)
    {
        PriorityQueue<Integer> pq = new PriorityQueue<>(arr.length);
        for(int i = 0 ; i < k+1; i++)
        {
            pq.add(arr[i]);
        }
        int index = 0;
        for(int i = k +1 ; i < arr.length ; i++)
        {
            arr[index] = pq.peek();
            index ++;
            pq.poll();
            pq.add(arr[i]);
        }
        while (!pq.isEmpty())
        {
            arr[index] = pq.peek();
            index++;
            pq.poll();
        }


    }


    public void sortKDistance(int[] arr, int k)
    {
        Arrays.sort(arr);
        Map<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i < arr.length; i++)
        {
            hm.put(arr[i], Math.abs(k - arr[i]));
        }

        HashMap<Integer,Integer> hm1 = hm.entrySet().stream().
                sorted((i1,i2) -> i1.getValue().compareTo(i2.getValue())).
                collect(Collectors.toMap( a -> a.getKey(), b -> b.getValue(),(e1,e2) -> e1, LinkedHashMap::new));
       int index = 0;
        for (var entry: hm1.entrySet()
             ) {
            arr[index] = entry.getKey();
            index++;

        }



    }
    public void sortLikeWave(int[] arr)
    {
        int value = 1
                ;
        while(value < arr.length)
        {
            if(arr[value] > arr[value-1] && (value +1) %2 == 0)
            {
                var value1 = arr[value];
                arr[value] = arr[value -1];
                arr[value -1 ]= value1;
            }
            if(arr[value] < arr[value-1] && (value +1) %2 != 0)
            {
                var value1 = arr[value];
                arr[value] = arr[value -1];
                arr[value -1 ]= value1;
            }
            value++;
        }

    }

    public int[] mergeTwoArray(int[] m, int[] n)
    {
        int[] mn = new int[m.length + n.length];
        int i = 0;
        int j = 0;
        int k  = 0;
        while(i < m.length && i < n.length)
        {
            if(m[j] <= m[k] )
            {
                mn[i] = m[j];
                j++;
            }
            else
            {
                mn[i] = m[k];
                k++;
            }
            i++;
        }

        while(k < n.length)
        {
            mn[i] = m[k];
            k++;
            i++;
        }
        return mn;
    }

    public void sort0and1(int[] rr)
    {
        int count  = -1;
        int i = 0;
        while(i < rr.length)
        {
            if(rr[i] == 0)
            {
                count++;
                var abc = rr[count];
                rr[count] = rr[i];
                rr[i] = count;

            }
            i++;
        }
    }

    public int findNumberofInversions(int[] arr, int l, int r)
    {
        int count = 0;
        if(l < r)
        {
            int mid =  (l +r) /2;
           count += findNumberofInversions(arr, l, mid);
           count += findNumberofInversions(arr, mid+1, r);
           count += merge(arr, l,mid,r);
        }
        return count;
    }

    private int merge(int[] arr, int l, int mid, int r)
    {
        int count = 0;
        int[] left = Arrays.copyOfRange(arr, l, mid +1);
        int[] ri = Arrays.copyOfRange(arr, mid+1, r+1);
        int i = 0 , j = 0, k = 0;
        while(i < left.length && j < ri.length)
        {
            if(left[i] <= ri[j])
            {
                arr[l + k] = left[i];
                        k++;
                i++;
            }
            else
            {
                arr[l + k] = ri[j];
                j++;
                k++;
                count += mid + 1 - l + i;

            }
        }
        while(i < left.length)
        {
            arr[l + k] = left[i];
            i++;
            k++;
        }
        while(j < ri.length)
        {
            arr[l + k] = ri[j];
            j++;
            k++;
        }
        return count;
    }


    public int[] MakeUnion(int[] arr1, int[] arr2)
{
    int[] arr = new int[arr1.length + arr2.length];
    int i = 0;
    int j = 0;
    int k  = 0;
    while(i < arr1.length && j < arr2.length)
    {
        if(arr1[i] < arr2[j])
        {
            arr[k] = arr1[i];
            i++;
            k++;
        }
        else if(arr1[i] > arr2[j])
        {
            arr[k] = arr2[j];
            j++;
            k++;
        }

        else if(arr1[i] == arr2[j])
        {
            arr[k] = arr2[j];
            j++;
            i++;
            k++;
        }

    }
    while ( i < arr1.length)
    {
        arr[k] = arr1[i];
        i++;
        k++;
    }
    while ( j < arr2.length)
    {
        arr[k] = arr2[j];
        j++;
        k++;
    }
    return arr;

}

    public int[] MakeIntersaction(int[] arr1, int[] arr2)
    {
        int[] arr = new int[arr1.length + arr2.length];
        int i = 0;
        int j = 0;
        int k  = 0;
        while(i < arr1.length && j < arr2.length)
        {
           if(arr1[i] == arr2[j])
           {
               arr[k] = arr1[i];
               k++;
               i++;
               j++;
           }
           else if(arr1[i] < arr2[j])
           {
               i++;
           }
           else if(arr1[i] > arr2[j])
           {
               j++;
           }

        }

        return arr;
    }

    public void restructureTwoArray(int[] arr1, int[] arr2)
    {
        int i = 0;
        int j = 0;
        int k = arr1.length -1;
        while(i <= k && j < arr1.length)
        {
            if(arr1[i] < arr2[j])
            {
                i++;
            }
            else
            {
                int value = arr2[j];
                arr2[j] = arr1[k];
                arr1[k] = value;
                j++;
                k--;
            }

        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);

    }


    public int[] find(int[] arr1)
    {
        int startIndex = 0;
        int endIndex = arr1.length -1;

        for(int i = 0 ; i < arr1.length -1 ; i++)
        {
            if(arr1[i] > arr1[i+1])
            {
                startIndex = i+1;
                break;
            }

        }


        for(int i = arr1.length -1 ; i >= 1 ; i--)
        {
            if(arr1[i] < arr1[i-1])
            {
               endIndex = i -1;
               break;
            }

        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;


        for(int i = startIndex ; i <= endIndex ; i++)
        {
            var value = arr1[i];
            max = Math.max(value,max);
            min = Math.min(value,min);
        }

        for(int i = startIndex -1 ; i >= 0 ; i--)
        {
            if(arr1[i] > min)
            {
                startIndex = i;
            }
        }

        for(int i = endIndex + 1 ; i < arr1.length ; i++)
        {
            if(arr1[i] < max)
            {
                endIndex = i;
            }
        }
        int[] ret   = {startIndex,endIndex};
        return ret;


    }


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
            }


        }
return ans -1;
    }

    public int findNumberOfTrianges(int[] arr)
    {


        Arrays.sort(arr);
        int ans = 0;
        for(int i = arr.length -1 ; i >= 1 ; i--)
        {
            int l = 0; int r = i-1;
            while (l < r)
            {
                if(arr[l] + arr[r] > arr[i])
                {
                    ans += r - l;
                    r--;
                }
                else
                {
                    l++;
                }
            }

        }
        return ans;
    }

}

