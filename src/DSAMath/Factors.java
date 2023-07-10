package DSAMath;

import java.util.*;

public class Factors {

    public List<Integer> getFactor(int n)
    {
        List<Integer> res = new ArrayList<>();
        for(int i = 1; i <= n ; i++)
        {
            if(n%i == 0) res.add(i);
        }
        return res;
    }

    public List<Integer> getFactorImproved(int n)
    {
        List<Integer> res = new ArrayList<>();
        List<Integer> res1 = new ArrayList<>();
        for(int i = 1; i * i <= n ; i++)
        {
            if(n%i == 0)

            {

                res.add(i);
                if(i != n/i)
                    res1.add(n/i);
            }
        }
        Collections.sort(res1, Comparator.comparingInt(a -> a));
         res.addAll(res1);
         return res;
    }
}
