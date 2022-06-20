package Algoritham;

public class Searching
{
    public static boolean LinerSearch(int[] arr, int Key)
    {
        for(int i =0; i < arr.length; i++)
        {
            if(arr[i] == Key) return true;
        }
        return false;
    }
    public static boolean BinarySearch(int[] arr, int Key)
    {
        int low = 0,high = arr.length;
      return   BinarySearch(arr, low,  high,  Key);
    }
    public static boolean BinarySearch(int[] arr, int low, int high, int key)
    {
      if (low > high) return false;
        int mid = (high+low)/2;
        if(arr[mid] == key) return true;
        if(key > mid) return BinarySearch(arr,mid +1, high,key);
        else return BinarySearch(arr, low, mid-1, key);
    }
}
