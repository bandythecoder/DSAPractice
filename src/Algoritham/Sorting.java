package Algoritham;

public class Sorting
{
    public static void SelectionSort(int[] arr)
    {

        for(int i = 0; i < arr.length; i++)
        {
            int minIndex=i;
            for(int j = i; j < arr.length; j++)
            {
               if(arr[minIndex] > arr[j])
               {
                   minIndex = j;
               }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    public static void bubbleSort(int[] arr)
    {
        for(int i = 0; i < arr.length;i++)
        {
            for(int j = 0 ; j < arr.length - i -1; i++)
            {
                if(arr[j] > arr[j+1])
                {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    private static void swap(int[] arr, int j, int i3) {
        int temp = arr[j];
        arr[j] = arr[i3];
        arr[i3] = temp;
    }

    public static void bubbleSortRecursive(int[] arr)
    {
       bubbleSortRecursive(arr, arr.length);
    }

    private static void bubbleSortRecursive(int[] arr, int n)
    {
        if(n ==1) return;
        for(int i = 0; i < n -1 ; i++)
        {
            if(arr[i] > arr[i+1])
            {
                swap(arr, i, i+1);
            }

        }
        bubbleSortRecursive(arr,n-1);
    }
    public static void InsertionSort(int[] arr, int n)
    {
        for(int i = 1; i < n ; ++i)
        {
         int   key = arr[i];
         int j = i-1;
         while(j >= 0 && arr[j] > key)
         {
             arr[j+1] = arr[j];
             j = j-1;
         }
           arr[j+1] = key;
        }
    }

    public static void InsertionSortRecursive(int[] arr, int n)
    {
      //Base Case
        if( n <= 1) return;
        InsertionSortRecursive(arr, n-1);
        int Key = arr[n-1];
        int j = n-2;
        while( j > 0 && arr[j] > Key)
        {
            arr[j +1 ] = arr[j];
            j = j-1;
        }
        arr[j+1] = Key;

    }

    public static void mergeSort(int[] arr, int n)
    {
        Sort(arr, 0 , n-1);
    }

    private static void Sort(int[] arr, int l, int r)
    {
        if(l < r)
        {
            int m =l+ (r-l)/2;
            Sort(arr, l , m);
            Sort(arr,m+1,r);
            merge(arr, l, m, r);
        }
    }
   static void merge(int arr[], int l, int m, int r)
   {
     int lengthLeftArray = m - l +1;
     int lengthRightArray = r -m;
     int[] LeftArray = new int[lengthLeftArray];
     int[] RightArray = new int[lengthRightArray];
     // Copy Array
       for(int i =0; i < lengthLeftArray; i++)
       {
           LeftArray[i] = arr[l+i];
       }
       for(int i =0; i < lengthRightArray; i++)
       {
           RightArray[i] = arr[m + 1+i];
       }
       int i =0, j =0, k =l;
       while(i < lengthLeftArray && j < lengthRightArray)
       {
           if(LeftArray[i] <= RightArray[j])
           {
               arr[k] = LeftArray[i];
               i++;
           }
           else
           {
               arr[k] = RightArray[j];
               j++;
           }
           k++;
       }
       while(i< lengthLeftArray)
       {
           arr[k]= LeftArray[i];
           i++;
           k++;
       }
       while(j< lengthRightArray)
       {
           arr[k] = RightArray[j];
           j++;
           k++;
       }
   }

    public static void QuickSort(int[] arr, int n)
{
    QuickSort(arr, 0, n-1);
}



    public static void QuickSort(int[] arr, int low, int high)
    {
    if(low<high)
    {
        int pivot = Partition(arr,low,high);
        QuickSort(arr,low,pivot -1);
        QuickSort(arr, pivot+1, high);
    }
    }

    private static int Partition(int[] arr, int low, int high)
    {
        int count = low-1;
        int pivot = arr[high];
        for(int i = low ; i <= high; i++ )
        {
            if(arr[i] <= pivot)
            {
                count++;
                swap(arr,i,count);
            }
        }
      //  swap(arr,count+1,high);
        return count;
    }
    public static void heapsort(int arr[])
    {
        int length = arr.length;
        // Create a max heap
        for(int i = length/2 -1 ; i >= 0 ; i--)
        {
            heapify(arr, length, i);
        }

        // Delete the top element
        for(int i = length -1 ; i >0; i--)
        {
            swap(arr, i,0);
            heapify(arr, i,0);
        }

    }

    public static void heapify(int[] arr, int length, int root)
    {
        int left = 2 * root +1;
        int right = 2* root +2;
        int Largest = root;
        if(left < length && arr[left] > arr[Largest])
            Largest = left;

        if(right < length && arr[right] > arr[Largest])
            Largest = right;

        if(Largest != root)
        {
            swap(arr,root,Largest);
            heapify(arr,length,Largest);
        }


    }




}
