package DSAMath;

import java.util.ArrayList;
import java.util.List;

public class Prime {

    public boolean isPrime(int n)
    {
        if(n ==1 ) return false;
        for (int i =2 ; i <= Math.sqrt(n) ; i++)
        {
            if(n%i == 0) return false;
        }
        return true;
    }

    public List<Integer> primeNumbers(int n)
    {
        List<Integer> li = new ArrayList<>();

        for(int i = 2; i <= Math.sqrt(n) ; i++)
        {
            if(isPrime(i))
            {

            }
        }
        return li;
    }

}
