package Arrays;

public class RotationHelper {

  public   static void ReverseArray(int[] arr,int start, int size) {
      int end = size - 1;
      while (start < end) {
          int temp = arr[start];
          arr[start] = arr[end];
          arr[end] = temp;
          start = start + 1;
          end = end - 1;
      }
  }
  public  static int gcd(int a, int b)
    {
        if(b == 0)
            return a;
        else
            return gcd(b, a%b);
    }

    public static void Swap(int[] arr, int fi, int si,int d)
    {
        for(int i = 0; i< d; i++)
        {
            int temp = arr[fi + i];
            arr[fi + i] = arr[si+i];
            arr[si+i] = temp;
        }

    }
}
