package Arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class ArrayArrangement {

    public static void ArrayArrangementBasedOnIndex(int arr[], int n) {

        for (int i = 0; i < n; i++) {
            //01-132
            if (arr[i] != i && arr[i] != -1) {
                int x = arr[i];

                while (arr[x] != x && arr[x] != -1) {
                    int y = arr[x];
                    arr[x] = x;
                    x = y;
                }
                arr[x] = x;

                if (arr[i] != i) {
                    arr[i] = -1;
                }
            }

        }
    }


    public static void ArrangementEvenOdd(int[] arr, int n) {
        int[] tempArr = new int[n];
        for (int i = 0; i < n; i++) {
            tempArr[i] = arr[i];
        }
        Arrays.sort(tempArr);
        int evenPlace = n / 2;
        int oddPlace = n - evenPlace;
        int pointer = oddPlace - 1;
        for (int i = 0; i < n; i = i + 2) {
            arr[i] = tempArr[pointer];
            pointer--;
        }
        pointer = oddPlace;
        for (int i = 1; i < n; i = i + 2) {
            arr[i] = tempArr[pointer];
            pointer++;
        }
    }

    static void rightrotate(int arr[], int outofplace,
                            int cur) {
        int tmp = arr[cur];
        for (int i = cur; i > outofplace; i--)
            arr[i] = arr[i - 1];
        arr[outofplace] = tmp;
    }

    public static void rearrange(int[] arr, int n) {
        // Check if an index is out of index
        int outofIndex = -1;
        for (int i = 0; i < n; i++) {
            if (outofIndex >= 0) {
                if ((arr[i] >= 0 && arr[outofIndex] < 0) || arr[i] < 0 && arr[outofIndex] >= 0) {
                    rightrotate(arr, outofIndex, i);
                    i = outofIndex;
                    outofIndex = -1;
                }
            }


            if (outofIndex == -1) {
                if ((arr[i] >= 0 && i % 2 == 0) || (arr[i] < 0 && i % 2 == 1)) {
                    outofIndex = i;
                }
            }

        }

    }

    public static void ArrangeArrayPositiveNegetive(int[] arr, int length) {
        //Move positive one side
        int count = -1;
        int temp = 0;
        for (int i = 0; i < length; i++) {
            if (arr[i] > 0) {
                count++;
                temp = arr[count];
                arr[count] = arr[i];
                arr[i] = temp;

            }
        }

        int pos = count + 1;
        int neg = 0;
        //-4-531267
        while (pos < length && arr[neg] > 0 && neg < pos) {
            int temp1 = arr[neg];
            arr[neg] = arr[pos];
            arr[pos] = temp1;
            neg = neg + 2;
            pos = pos + 1;
        }

    }

    public static int MinSwapToBrindelementLessThanKtogether(int[] arr, int size, int k) {
        // Find the numbers > K
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (arr[i] <= k) count++;
        }
        // Find the numbers in current window
        int Swap = 0;
        int minSwap = 0;
        for (int i = 0; i < count; i++) {
            if (arr[i] > k) Swap++;
        }
        minSwap = Swap;

        for (int i = 0, j = count; j < count; ++i, ++j) {
            if (arr[i] > k) Swap--;
            if (arr[j] > k) Swap++;
            minSwap = Math.min(minSwap, Swap);
        }
        return minSwap;
    }

    public static void RearrangePositiveNegetive(int[] arr, int size) {
        int count = -1;
        for (int i = 0; i < size; i++) {
            if (arr[i] < 0) {
                count++;
                int temp = arr[i];
                arr[i] = arr[count];
                arr[count] = temp;
            }
        }
    }

    public static void ReArrangeArrayUsingIndexArray(int[] arr, int[] index, int size) {
        for (int i = 0; i < size; i++) {

            int temp = index[i];
            int tempIndex = i;
            while (temp != i) {
                int value = index[temp];
                int tempArr = arr[i];
                index[temp] = temp;
                arr[i] = arr[temp];
                arr[temp] = tempArr;

                index[i] = value;
                temp = value;
            }
            {

            }

        }
    }

    public static void DoubleandMove0toEnd(int[] arr, int n) {
        int count = -1;
        for (int i = 0; i < n; i++) {

            if (arr[i] != 0) {
                count++;

                if (i < n - 1 && arr[i + 1] != 0) {
                    arr[i] = 2 * arr[i];
                    arr[i + 1] = 0;
                }
// swap rule 1 - > override value will go in temp
                int temp = arr[count];
                arr[count] = arr[i];
                arr[i] = temp;


            }
        }
    }

    public static void findTheMaxingNumber(List<String> arr, int n) {
        Collections.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String X, String Y) {
                String XY = X + Y;
                String YX = Y + X;
                return XY.compareTo(YX) > 0 ? -1 : 1;

            }
        });
    }

    // A space efficient method to rearrange 'arr[0..n-1]'
    // so that 'arr[j]' becomes 'i' if 'arr[i]' is 'j'
    public static void Rea(int arr[], int n) {
        // Increment all values by 1, so that all elements
        // can be made negative to mark them as visited
        int i;
        for (i = 0; i < n; i++)
            arr[i]++;

        // Process all cycles
        for (i = 0; i < n; i++) {
            // Process cycle starting at arr[i] if this cycle is
            // not already processed
            if (arr[i] > 0)
                rearrangeUtil(arr, n, i);
        }

        // Change sign and values of arr[] to get the original
        // values back, i.e., values in range from 0 to n-1
        for (i = 0; i < n; i++)
            arr[i] = (-arr[i]) - 1;
    }

    static void rearrangeUtil(int arr[], int n, int i) {
        // 'val' is the value to be stored at 'arr[i]'

        // The next value is determined using current index
        int val = -(i + 1);

        // The next index is determined
        // using current value
        i = arr[i] - 1;

        // While all elements in cycle are not processed
        while (arr[i] > 0) {
            // Store value at index as it is going to be
            // used as next index
            int new_i = arr[i] - 1;

            // Update arr[]
            arr[i] = val;

            // Update value and index for next iteration
            val = -(i + 1);
            i = new_i;
        }
    }


    public static void ReturnAnArrayMultiplicationofPreviosandNext(int[] arr, int size) {

        int temp = arr[0];
        for (int i = 0; i < size; i++) {

            if (i == 0) {
                arr[i] =
                        arr[i] * arr[i + 1];
                continue;
            }
            if (i == size - 1) {
                arr[size - 1] = arr[size - 1] * temp;
                continue;
            }
            int temp1 = arr[i];
            arr[i] = temp * arr[i + 1];
            temp = temp1;


        }

    }

    public static void RearrangeEvenOdd(int[] arr, int n) {
        //complexity = 0(N2)
        int outofIndex = -1;
        for (int i = 0; i < n; i++) {
            if (outofIndex >= 0) {
                if ((arr[outofIndex] > 0 && arr[i] < 0) || (arr[outofIndex] > 0 && arr[i] < 0)) {
                    rightrotate(arr, outofIndex, i);
                    outofIndex = -1;
                }
            }
            if (outofIndex == -1) {
                if (arr[i] < 0 && i % 2 == 0) {
                    outofIndex = i;
                }
                if (arr[i] > 0 && i % 2 == 1) {
                    outofIndex = i;
                }
            }
        }

    }

    public static void RearrangeEvenOddNewMethod(int[] arr, int n) {
        int tempPositive = 0;
        int tempNegetive = 1;
        for (int i = 0; i < n; i++) {

            if (i % 2 == 0 && arr[i] > 0) {
                tempPositive = tempPositive + 2;
            }

            if (i % 2 == 1 && arr[i] < 0) {
                tempNegetive = tempNegetive + 2;
            }
            if (tempNegetive > n - 1 || tempPositive > n - 1) break;
            if ((arr[tempPositive] < 0 && arr[tempNegetive] > 0)) {
                int temp = arr[tempPositive];
                arr[tempPositive] = arr[tempNegetive];
                arr[tempNegetive] = temp;
            }
        }
    }

    public static void RearrangeEvenOddEvenIsless(int[] arr, int n) {
        for (int i = 0; i < n - 1; i++) {
//2345
            if (arr[i] > arr[i + 1] && i % 2 == 0) {
                int temp = arr[i + 1];
                arr[i + 1] = arr[i];
                arr[i] = temp;
            }

            if (arr[i] < arr[i + 1] && i % 2 == 1) {
                int temp = arr[i + 1];
                arr[i + 1] = arr[i];
                arr[i] = temp;

            }
        }
    }


    public static void MoveNegetiveToEnd(int[] arr, int n) {
        int count = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i] < 0) {
                count++;
                int temp = arr[count];
                arr[count] = arr[i];
                arr[i] = temp;
            }

        }

    }

    public static void rearrangeminmax(int arr[], int n) {
        // Algo -> Difine min max pointer
        // Get Max element +1
        // if even place max element arr[max] % max * max and decrease max index
        // if min place min element arr[min % max * max and increase max index
        // arr / max to get final numbers

        int min_index = 0, max_index = n - 1;
        int maxValue = arr[max_index] + 1;

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                arr[i] += (arr[max_index] % maxValue) * maxValue;
                max_index--;
            }
            if (i % 2 == 1) {
                arr[i] += (arr[min_index] % maxValue) * maxValue;
                min_index++;
            }

        }
        for (int i = 0; i < n; i++) {
            arr[i] = arr[i] / maxValue;

        }


    }

    public static void ArrangeBasedOnIndexMultipleCycles(int[] arr, int n)
    {
        for(int i = 0; i < n ; i++)
        {
            if(arr[i] > 0)
            {
                ArrangeBasedOnIndex(arr, n, i);
            }
        }

        for(int i = 0; i < n ; i++)
        {
            arr[i] = -(arr[i]) - 1;
        }
    }


    public static void ArrangeBasedOnIndex(int[] arr, int n, int i)
    {
        int value = -(i+1);
        int index = arr[i];
        //1302
        while (index >= 0)
        {
            int new_Index = arr[index];

            arr[index] = value;
            value = -(index + 1);
            index = new_Index;
        }

       // arr[i] = value;
    }

    public static void ArrangeBasedOnIndexplusminus1(int[] arr, int n)
    {
       for(int i = 0; i < n ; i++)
       {

           if( arr[i] != -1 && arr[i] != i)
           {
               int x = arr[i];
               while( arr[x] != -1 && arr[x] != x)
               {
                   int y = arr[x];
                   arr[x] = x;
                   x =y;
               }
               arr[x] =x;
               if(arr[i] != i)
               {
                   arr[i] = -1;
               }
           }

       }
    }


}




