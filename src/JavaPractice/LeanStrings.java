package JavaPractice;

public class LeanStrings {

    public void whatIsStrings()
    {
        // It is an object
        String s = "Kunal Mishra";
        String s1 = "Kunal Mishra";
        String s2 = new String("Kunal Mishra");
        String s3 = new String("Kunal Mishra").intern();
        // returns true because s and s2 both stored in String pool.

        System.out.println(s == s1);
        // returns false because s2 stored in heap.
        System.out.println(s == s2);
        // returns true because intern method points to thread pool.
        System.out.println(s == s3);
    }
}
