package Algoritham;

public class DynamicProgramming_LCS
{
    public static int[][] t = new int[1000][1000];
    public static String[][] t1 = new String[1000][1000];
    public  DynamicProgramming_LCS()
    {
        for(int i =0 ; i < t.length; i++)
        {
            for (int j = 0; j < t[i].length ; j++)
            {
                t[i][j] = -1;
            }
        }
    }
    public int LCSRecursive(char[] string1, char[] string2, int m, int n )
    {
        // Base
        if(m == 0 || n == 0)
        {
            return 0;
        }


        // Choice Diagram
        if(string1[m-1] == string2[n-1])
        {
            return 1 + LCSRecursive(string1, string2, m-1, n-1);
        }
        else
        {
            return Math.max(LCSRecursive(string1,string2,m-1, n), LCSRecursive(string1, string2, m, n-1));
        }

    }

    public int LCSRecursiveMemo(char[] string1, char[] string2, int m, int n )
    {
        // Base
        if(m == 0 || n == 0)
        {
            return 0;
        }

if(t[m][n] != -1)
{
    return t[m][n];
}
        // Choice Diagram
        if(string1[m-1] == string2[n-1])
        {
            t[m][n] = 1 + LCSRecursive(string1, string2, m-1, n-1);
            return t[m][n];
        }
        else
        {
            t[m][n] =  Math.max(LCSRecursive(string1,string2,m-1, n), LCSRecursive(string1, string2, m, n-1));
          return   t[m][n];
        }

    }

    public int LCSTopDown(char[] string1, char[] string2, int m, int n)
    {
        for(int i = 0; i < m + 1; i++)
    {
        t[i][0] = 0;
    }

        for(int i = 0; i < m + 1; i++)
        {
            t[0][1] = 0;
        }
        for(int i = 1; i < m +1 ; i++)
        {
            for(int j = 1; j < n +1; j++)
            {
                if(string1[i-1] == string2[j-1])
                {
                    t[i][j] = 1 + t[i-1][j-1];
                }
                else
                {
                    t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
                }
            }
        }
        return t[m][n];
    }

     public int LCSubString(char[] string1, char[] string2, int m, int n)
     {
         for(int i = 0; i < string1.length +1; i++) t[i][0] = 0;
         for(int i = 0; i < string2.length +1; i++) t[0][1] = 0;
         int max = Integer.MIN_VALUE;
         for(int i = 1; i < string1.length +1; i++)
         {
             for(int j = 1; j < string2.length  +1; j++)
             {
                 if(string1[i-1] == string2[j-1])
                 {
                     t[i][j] = 1 + t[i-1][j-1];
                     max = Math.max(t[i][j], max);
                 }
                 else
                 {
                     t[i][j] = 0;
                 }
             }
         }
         return max;
     }

  public    String PrintLCS(char[] string1, char[] string2 , int m, int n)
     {
         for(int i = 0; i < m+1; i++)
         {
             t[i][0] = 0;
         }
         for(int i = 0; i < n +1; i++)
         {
             t[0][i] = 0;
         }

         for(int  i = 1; i < m+1; i++)
         {
             for(int j = 1; j < n+1 ; j++)
             {
                 if(string1[i-1] == string2[j-1])  t[i][j] = 1 + t[i-1][j-1];
                 else t[i][j] = Math.max(t[i][j-1],t[i-1][j]);


             }
         }

         int i = m -1;
         int j = n -1;
StringBuilder sb = new StringBuilder();
         while(i >= 0 && j >= 0)
         {
             if(string1[i] == string2[j])
             {
                 sb.append(string1[i]);
                 i--;
                 j--;
             }
             else
             {
                 if(t[i][j+1] > t[i+1][j])
                 {
                     i--;
                 }
                 else
                 {
                     j--;
                 }
             }
         }
         return sb.reverse().toString();
     }

     public int superSequence(char[] string1, char[] string2, int m , int n)
     {
       for(int i = 0; i < m+1; i++)
       {
           t[i][0] = i;
       }

         for(int i = 0; i < n+1; i++)
         {
             t[0][i] = i;
         }

         for(int i =1; i < m+1; i++)
         {
             for(int j =1 ; j < n+1; j++)
             {
                 if(string1[i-1] == string2[j-1])
                 {
                     t[i][j] = 1+ t[i-1][j-1];
                 }
                 else
                 {
                     t[i][j] = 1 + Math.min(t[i][j-1], t[i-1][j]);
                 }
             }
         }
         return t[m][n];
     }

     public int maxInsertionAndDeletionToReachAtoB(char[] string1, char[] string2, int m , int n)
     {
         for(int i = 0; i < m +1; i++)
         {
             t[i][0] = 0;
         }
         for(int i = 0; i < n+1; i++)
         {
             t[0][i] = 0;
         }
         for(int i =1; i < m+1; i++)
         {
             for(int j =1; j< n+1; j++)
             {
                 if(string1[i-1] == string2[j-1])
                 {
                     t[i][j] = 1 + t[i-1][j-1];
                 }
                 else
                 {
                     t[i][j] = Math.max(t[i][j-1], t[i-1][j]);
                 }
             }
         }

         int lcs = t[m][n];
         int insertion = m - lcs;
         int deletion = n - lcs;
         return insertion;
     }

     public int longestPallandromicSequence(char[] string1, int m )
     {
         char[] string2 = reverse(string1, m);
         int lcs = LCSTopDown(string1,string2,m,m);
         return lcs;
     }

    public int MinNumberOfDeletionToMakeStringPallandrome(char[] string1, int m )
    {
        char[] string2 = reverse(string1, m);
        int lcs = LCSTopDown(string1,string2,m,m);
        return m-lcs;
    }


    public String printSuperSequence(char[] string1, char[] string2, int m, int n)
    {
        t = new int[m+1][n+1];
        for(int i = 0; i < m + 1; i++)
        {
            t[i][0] = 0;
        }
        for(int i = 0; i < m + 1; i++)
        {
            t[0][1] = 0;
        }
        for(int i = 1; i < m +1 ; i++)
        {
            for(int j = 1; j < n +1; j++)
            {
                if(string1[i-1] == string2[j-1])
                {
                    t[i][j] = 1 + t[i-1][j-1];
                }
                else
                {
                    t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
                }
            }
        }

        int i = m;
        int j = n;
        StringBuilder sb = new StringBuilder();
        while(i >= 0 && j >= 0)
        {
            if(string1[i-1] == string2[j-1])
            {
                sb.append(string1[i-1]);
                i--;
                j--;

            }
            else
            {
                if(  t[i][j-1] > t[i-1][j])
                {
                    sb.append(string2[j-1]);
                    j--;


                }
                else
                {
                    sb.append((string1[i-1]));
                    i--;
                }
            }

        }
        while(i >= 0 )
    {
        sb.append(string1[i]);
        i--;
    }
        while(j >= 0 )
        {
            sb.append(string2[j]);
            j--;
        }
return sb.reverse().toString();

    }


    public int LongestReaptingSequence(char[] string1 ,int m)
    {
        char[] string2 = string1;

        for(int i = 0; i < m+1; i++)
        {
            t[0][i] = 0;
        }

        for(int i = 0; i < m+1; i++)
        {
            t[i][0] = 0;
        }

        for(int i = 1; i < m+1; i ++)
        {
            for(int j = 1; j < m+1;j++)
            {
                if(string1[i-1] == string2[j-1] && i != j)
                {
                    t[i][j] = 1 + t[i-1][j-1];
                }
                else
                {
                    t[i][j] = Math.max(t[i-1][j], t [i][j-1]);
                }
            }
        }
     return t[m][m];

    }

    private char[] reverse(char[] string1, int m) {
        int i = 0; int j = m-1;
        StringBuilder sb = new StringBuilder();
        sb.append(string1);
        char[] string2 = sb.reverse().toString().toCharArray();

       return string2;
    }
}
