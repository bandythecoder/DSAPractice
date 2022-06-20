package Algoritham;

import java.util.HashMap;

public class DPRevision
{
    int[][] t = new int[1000][1000];
    boolean[][] t1 = new boolean[1000][1000];
    public DPRevision() {
        for(int i = 0 ; i < t.length ; i++)
        {
            for(int j = 0; j < t[0].length; j++)
            {
                t[i][j] = -1;
            }
        }
    }
    // To Do 0_1 Knapsack
    // DP -> recursive -> Top down

    // Problem Statement -> Value array / Item Array / max profit

    public int knapSack01(int[] value, int[] item, int m , int wt)
    {
        if(wt == 0 || m == 0)
        {
            return 0;
        }
        if(item[m-1] > wt)
        {
          return   knapSack01(value, item, m-1,wt);
        }
        else
        {
           return Math.max(knapSack01(value,item, m-1, wt - item[m-1]) + value[m-1],knapSack01(value, item, m-1,wt));
        }
    }

    public int knapSack01Memo(int[] value, int[] item, int m , int wt)
    {
        if(t[m][wt] != -1) return t[m][wt];
        if(wt == 0 || m == 0)
        {
            return 0;
        }
        if(item[m-1] > wt)
        {
            return t[m][wt] =  knapSack01(value, item, m-1,wt);
        }
        else
        {
            return t[m][wt] = Math.max(knapSack01(value,item, m-1, wt - item[m-1]) + value[m-1],knapSack01(value, item, m-1,wt));
        }
    }

    public int knapSack01TopDown(int[] value, int[] item, int m , int wt)
    {
      for(int i= 0; i <= m ; i++  )
    {
        t[i][0] = 0;
    }
        for(int i= 0; i <= wt ; i++  )
        {
            t[0][i] = 0;
        }

        for(int i = 1; i <= m ; i++)
        {
            for(int j = 1; j <= wt; j++)
            {
                if(item[i-1] > j)
                {
                    t[i][j] = t[i-1][j];
                }
                else
                {
                    t[i][j] = Math.max(t[i-1][j], value[i-1] + t[i-1][j-item[i-1]]);
                }
            }
        }
        return t[m][wt];
    }

    public boolean subsetSum(int[] arr,int n, int sum)
    {
      for(int i = 0; i <= n ; i++)
      {
          t1[i][0] = true;
      }
      for(int i =  1; i <= sum ; i++)
      {
         t1[0][i] = false;
      }

      for(int i = 1; i <= n ; i++)
      {
          for(int j  = 1 ; j <= sum ; j++)
          {
              if(arr[i-1] > j)
              {
                  t1[i][j] = t1[i-1][j];
              }
              else
              {
                  t1[i][j] = t1[i-1][j] || t1[i-1][j-arr[i-1]];
              }
          }
      }
return t1[n][sum];
    }

    int subsetCount(int nums[], int n, int sum)
    {
        t = new int[n+1][sum+1];

        for(int i = 0; i <= n ; i++)
        {
            for(int j = 0; j <= sum ; j++)
            {
                if(j == 0)
                {
                    t[i][j] =1;
                }
                else if(i == 0)
                {
                    t[i][j] = 0;
                }
                else
                {
                    if(nums[i-1] > j)
                    {
                        t[i][j] = t[i-1][j];
                    }
                    else
                    {
                        t[i][j] = t[i-1][j] + t[i-1][j-nums[i-1]];
                    }
                }

            }
        }
        return t[n][sum];
    }

    public int subsetMinDifference(int[] arr, int n)
    {
        int sum = 0;
        for(int i = 0 ; i < n ; i++)
        {
            sum += arr[i];
        }
         int min = Integer.MAX_VALUE;
       boolean[] subset = subset(arr, n , sum);
        for(int i = 0; i <= sum/2; i++)
        {
            if(subset[i] == true)
            {
                min = Math.min(min, sum - 2*i);
            }
        }
        return min;
    }

    private boolean[] subset(int[] arr, int n, int sum) {

        for(int i = 0; i <= n ; i++)
        {
            for(int j = 0; j<= sum ; j++)
            {
                if(j == 0)
                {
                    t1[i][j] = true;
                }
                else if(i == 0)
                {
                    t1[i][j] = false;
                }
                else
                {
                    if(arr[i-1] > j)
                    {
                        t1[i][j] = t1[i-1][j];
                    }
                    else
                    {
                        t1[i][j] = t1[i-1][j] || t1[i-1][j-arr[i-1]];
                    }
                }


            }
        }

        return t1[n];
    }

    public int subsetCountwithdiff(int[] arr, int n, int diff)
    {
       int sum = 0;
       for(int value : arr)
       {
           sum += value;
       }
       int subSetSum = (sum + diff)/2;
       return subsetCount(arr, n, subSetSum);
    }

    public int knapSackUnbounded(int[] value , int item[], int m ,int wt)
    {
      for(int i = 0; i <= m ; i++)
      {
          for(int j = 0; j <= wt ; j++)
          {
              if(i == 0)
              {
                  t[i][j] = 0;
              }
              else if(j == 0)
              {
                  t[i][j] = 0;
              }
              else
              {
                  if(item[i-1] > j)
                  {
                      t[i][j] = t[i-1][j];
                  }
                  else
                  {
                      t[i][j] = Math.max(t[i-1][j], t[i][j-item[i-1]] + value[i-1]);
                  }
              }
          }
      }
      return t[m][wt];
    }

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] t = new int[n+1][amount+1];

        for(int i = 0; i <= n ; i++)
        {
            for(int j = 0; j <= amount; j++)
            {
                if(i == 0)
                {
                    t[i][j] = Integer.MAX_VALUE-1;
                }
                else if(j == 0)
                {
                    t[i][j] = 0;
                }
                else if(i == 1)
                {
                    if (j%coins[i-1]==0)
                    {
                        t[i][j] = j/coins[i-1];
                    }
                    else
                    {
                        t[i][j] = Integer.MAX_VALUE-1;
                    }
                }
                else
                {
                    if(coins[i-1] > j)
                    {
                        t[i][j] = t[i-1][j];
                    }
                    else
                    {
                        t[i][j] = Math.min(t[i-1][j],1 + t[i][j-coins[i-1]]);
                    }
                }
            }
        }
        return t[n][amount] == Integer.MAX_VALUE -1 ? -1 : t[n][amount];
    }

    public int LCS(String str1, String str2, int m, int n)
    {
        if(m == 0 || n == 0)
        {
            return 0;
        }
        if(str1.charAt(m-1) == str2.charAt(n-1))
        {
            return 1 + LCS(str1,str2,m-1,n-1);
        }
        else
        {
            return Math.max(LCS(str1,str2,m-1,n), LCS(str1,str2,m,n-1));
        }
    }

    public int LCSMemozize(String str1, String str2, int m, int n)
{
    if(t[m][n] != -1)
    {
        return t[m][n];
    }
    if(m == 0 || n == 0)
    {
        return 0;
    }
    if(str1.charAt(m-1) == str2.charAt(n-1))
    {
        return t[m][n] = 1 + LCS(str1,str2,m-1,n-1);
    }
    else
    {
        return t[m][n] = Math.max(LCS(str1,str2,m-1,n), LCS(str1,str2,m,n-1));
    }
}

    public int[][] LCSTopDown(String str1, String str2, int m, int n)
    {
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    t[i][j] = 0;
                else if (str1.charAt(i - 1) == str2.charAt(j - 1))
                    t[i][j] = t[i - 1][j - 1] + 1;
                else
                    t[i][j] = Math.max(t[i - 1][j],
                            t[i][j - 1]);
            }
        }
     return t;
    }

    public int LCSubstring(String str1, String str2, int m, int n)
    {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i <= m ; i++)
        {
            for(int j = 0; j <= n; j++)
            {
                if(i == 0|| j == 0)
                {
                    t[i][j] = 0;
                }
                else
                {
                    if(str1.charAt(i-1) == str2.charAt(j-1))
                    {
                        t[i][j] = 1 + t[i-1][j-1];
                        max = Math.max(t[i][j],max);
                    }
                    else
                    {
                        t[i][j] = 0;
                    }
                }
            }
        }
        return max;
    }

    public String printSubsequence(String str1, String str2, int m, int n)
    {
        var t = LCSTopDown(str1,str2,m,n);
        StringBuilder sb = new StringBuilder();
        while(m > 0 && n > 0) {
            if (str1.charAt(m - 1) == str2.charAt(n - 1)) {
                sb.append(str1.charAt(m - 1));
                m = m - 1;
                n = n - 1;
            } else {
                if (t[m - 1][n ] > t[m ][n - 1] ) {
                    m = m - 1;
                } else if (t[m - 1][n ] < t[m ][n - 1] ){
                    n = n - 1;
                }
                else
                {
                    if(m < n)
                    {
                        m--;
                    }
                    else
                    {
                        n--;
                    }
                }

            }
        }

        return sb.reverse().toString();
    }


    public int shortestCommonSuperSequence(String s1, String s2, int m, int n)
    {
        int value = LCS(s1,s2,m,n);
        return m + n - value;
    }

    public HashMap<String, Integer> minInsertDeleteToMakeStringAtoB(String A, String B, int m, int n)
    {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        int value = LCS(A,B,m,n);
        int minInsert = A.length() - value;
        int minDelete = B.length() - value;

        map.put("insert",minInsert);
        map.put("delete", minDelete);

        return map;



    }

    public int  MaxPalindromeSub(String s)
{
    int n = s.length();
    StringBuilder sb = new StringBuilder(s);
    String s1 = sb.reverse().toString();
    int lcs = LCS(s,s1,n,n);
    return lcs;


}
    public String printSuperSequence(String str1, String str2, int m, int n) {
        int[][] t =LCSTopDown(str1, str2, m,n);
        int i =  m-1;
        int j = n-1;
        StringBuilder sb = new StringBuilder();
        while(i > 0 && j > 0)
        {
            if(str1.charAt(i) == str2.charAt(j))
            {
                sb.append(str1.charAt(i-1));
                i--;
                j--;
            }
            else
            {
                if(t[i][j-1] > t[i-1][j])
                {
                    sb.append(str2.charAt(j-1));
                    j--;
                }
                else
                {
                    sb.append(str1.charAt(i-1));
                    i--;
                }
            }
        }

        if(i != 0)
        {
            sb.append(str1.charAt(i-1));
            i--;
        }
        if(j != 0 )
        {
            sb.append(str2.charAt(j-1));
            j--;
        }


        return sb.reverse().toString();

    }
    public int  numberOfDeletionRequiredToMakeStringPalindrome(String s)
    {
        int n = s.length();
        StringBuilder sb = new StringBuilder(s);
        String s1 = sb.reverse().toString();
        int lcs = LCS(s,s1,n,n);
        return n-lcs;


    }



}
