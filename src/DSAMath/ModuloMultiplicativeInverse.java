package DSAMath;

public class ModuloMultiplicativeInverse
{
     private static final int mod = (int)(10e9+7);
     private final BinaryExponentiation bs1;
     public ModuloMultiplicativeInverse(BinaryExponentiation bs)
     {
         this.bs1 = bs;
     }
    public int MMI(int n)
    {
        return bs1.powBS1(n, mod-2) % mod;
    }


}
