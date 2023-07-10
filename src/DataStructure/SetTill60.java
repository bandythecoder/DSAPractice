package DataStructure;

public class SetTill60 {
    long y = 0;
    public void add(int x)
    {
         y = y | (1 << x);
    }

    public void remove(int x)
    {
        y = y & ~(1 << x);
    }

    public void printAll()
    {
        for(int i = 1; i < 64; i++)
        {
            if((y & (long)(1<<i)) != 0)
            {
                System.out.println(i);
            }
        }
    }
}
