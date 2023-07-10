package Arrays.CyclicSort;

public class SortAnArray {

    public  void sort(int[] arr)
    {
        int n = arr.length;

        for(int i = 0; i < n ; i++)
        {
            int x = arr[i];
            while(arr[i] != i + 1)
            {
             var temp = arr[x-1];
              arr[x-1] = x;
              arr[i] = temp;
              x = temp;
            }
        }
    }
}
