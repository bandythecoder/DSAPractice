package Algoritham;

import jdk.dynalink.beans.MissingMemberHandlerFactory;

import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.RecursiveTask;

public class MatrixChanMultiplication {
   public int t[][] = new int[1000][1000];
   Map<String,Boolean> map = new HashMap<>();
    public MatrixChanMultiplication() {
        for(int i = 0; i < t.length;i++)
        {
            for(int j = 0; j < t[0].length; j++)
            {
                t[i][j] = -1;
            }
        }
    }

    public int matrixChanMultiPlication(int[] arr, int i , int j)
    {
        //Base Condition
        if(i >= j)
        {
            return 0;
        }

        if(t[i][j] != -1) return t[i][j];
          int min = Integer.MAX_VALUE;
        for(int k = i ; k < j ; k ++)
        {
            int value = matrixChanMultiPlication(arr, i, k) + matrixChanMultiPlication(arr, k+1,j) +
                    (arr[i-1] * arr[k] * arr[j]);
            min = Math.min(value, min);
        }
        return t[i][j] = min ;
    }

   public int palindromicPartition(char[] arr, int i , int j)
   {
       if(i > j)
       {
           return 0;
       }
       if(isPalindrome(arr,i,j))
       {
           return 0;
       }
       if(t[i][j] != -1) return t[i][j];
       int min = Integer.MAX_VALUE;
       for(int k = i ; k <= j-1; k++)
       {
           if(t[i][k] == -1)
           {
               t[i][k] = palindromicPartition(arr,i, k);
               t[k+1][j] =  palindromicPartition(arr, k+1,j);
           }
           int value =  t[i][k]+  t[k+1][j] + 1;
           min = Math.min(min,value);
       }
       return t[i][j] = min;
   }


    boolean isPalindrome(char[] string, int i, int j)
    {
        while(i < j)
        {
            if(string[i] != string[j])
            {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }


 public    int numberOfWaysToReturnTrue(String string , int start, int end , boolean isTrue)
    {
        if(start > end)
        {
            return 0;
        }
        if(start == end)
        {
            if (isTrue == true)
         return    string.charAt(start) == 'T' ? 1 : 0;
            else
                return string.charAt(start) == 'F' ? 1:0;
        }
int ans = 0;
        for(int k = start +1; k < end ; k = k+2)
        {
            int lT = numberOfWaysToReturnTrue(string, start, k-1,true);
            int lF = numberOfWaysToReturnTrue(string, start, k-1,false);
            int rT = numberOfWaysToReturnTrue(string, k+1, end,true);
            int rF = numberOfWaysToReturnTrue(string, k+1, end,false);
            if(string.charAt(k) == '&' )
            {
                if(isTrue == true)
                {
                    ans = ans + lT * rT;
                }
                else if (isTrue == false)
                {
                    ans = ans + lT*rF + rT*lF + lF * rF;
                }

            }
            else if(string.charAt(k) == '|' )
            {
                if(isTrue == true)
                {
                    ans = ans + lT * rF + rT * lT + rT * lF;
                }
                else if (isTrue == false)
                {
                    ans = ans + rF * lF;
                }

            }
            else if(string.charAt(k) == '^' )
            {
                if(isTrue == true)
                {
                    ans = ans + lT * rF + rT * lF;
                }
                else if (isTrue == false)
                {
                    ans = ans + lT*rT + rF*lF;
                }

            }
        }
        return ans;
    }

    public boolean isScramble(String S1,
                              String S2) {
        if(S1.length() != S2.length())
        {
            return false;
        }

        int n = S1.length();
        if(n==0)
        {
            return false;
        }
        if(S1.equals(S2))
        {
            return true;
        }
        if(map.containsKey(S1 + "~" + S2))
        {
            return map.get(S1 + "~" + S2);
        }
        for(int i = 1; i < n ; i++)
        {
            if(map.containsKey(S1 + "~" + S2))
            {
                return map.get(S1 + "~" + S2);
            }
            if(isScramble(S1.substring(0,i),S2.substring(0,i))&& isScramble(S1.substring(i,n),S2.substring(i,n)))
            {
                map.put(S1 + "~" + S2,true);
                return true;
            }
            if(isScramble(S1.substring(0,i),S2.substring(n-i,n)) && isScramble(S1.substring(i,n),S2.substring(0,n-i)))
            {
                map.put(S1 + "~" + S2,true);
                return true;
            }

        }
          map.put(S1 + "~" + S2,false);
        return map.get(S1 + "~" + S2);
    }

    public int minAttemptsEggDrop(int n, int f)
    {
        if(n ==1 || f == 1 || f==0) return f;
        int min = Integer.MAX_VALUE;
        for(int i = 1; i <=f ; i++)
        {
            int minAttempts = 1 + Math.max(minAttemptsEggDrop(n-1,i-1), minAttemptsEggDrop(n,f-i));
            min = Math.min(min,minAttempts);
        }
        return min;
    }


}
