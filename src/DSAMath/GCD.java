package DSAMath;

public class GCD {
    private int a;
    private int b;
    public GCD(int a, int b)
    {
        this.a = a;
        this.b = b;
    }

    public int gcd()
    {
      while(a != 0)
      {
          int temp = a;
          a = b%a;
          b = temp;
      }
      return b;
    }
}
