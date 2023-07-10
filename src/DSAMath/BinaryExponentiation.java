package DSAMath;

public class BinaryExponentiation {

    // pow Basic Way
     private static final int mod = (int) (10e9+7);
    public int pow(int n, int p)
    {
        if(p == 0)
        {
            return 1;
        }

        return n * pow(n, p-1);
    }

    // using recur divide and conquer

    public int powBS(int n , int p)
    {
        if(p == 0) return 1;
        long res = powBS(n, p/2);
        if((p & 1) == 0)
        {
            return  (int)((res * res) % mod);
        }
        else
        {
            return (int)(n * (res* res) % mod)  ;
        }

    }

    // let's see iterative way

     public int powBS1(int n , int p)
     {
         int  res = 1;

         while(p > 0)
         {
             if((p & 1) != 0)
             {
                 res = (int) ((res * 1l) * (n * 1l) % mod);
             }
             n = (int) ((n * 1l) * (n * 1L) % mod);
             p = p >> 1;
         }
         return (int)res;
     }
}
