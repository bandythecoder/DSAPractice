package DSAMath;

public class SQRT {

    public double sqrtBS(int n, int p)
    {
     double i = 0;
     double j = n/2;
     double root = 0.0;
     double ans = 0;
     while(i < j)
     {
      double m = i + (j-i)/2;
      if(m > n/m)
      {
          j = m -.0001;
      }
      else
      {
          ans = m;
          i = m+ .0001;
      }
     }


     return Math.round(ans * 1000)/1000.000;
    }

    public double newtonBS(int n, int p)
    {
        double res = 0.0;
        double x = n;
        double root = 0;
        while(true)
        {
             root = .5 * (x + n/x);
            if(root >= x - .01)
            {
                break;
            }
            x = root;
        }
        return root;
    }
}
