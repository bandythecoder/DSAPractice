package DSAMath;

public class LCM {
    private int a;
    private int b;

    private int gcd;

    public LCM(int a, int b ) {
        this.a = a;
        this.b = b;
        gcd = new GCD(a,b).gcd();
    }

    public int lcm()
    {
        return a *b /gcd;
    }
}
