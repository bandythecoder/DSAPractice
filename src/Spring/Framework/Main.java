package Spring.Framework;

import Algoritham.BackTrackingProblems;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Main {


    public static int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] cars = new int[n][2];
        Stack<Double> stack = new Stack<>();

        for(int i = 0; i < n ; i++)
        {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        Arrays.sort(cars, (a, b) -> Integer.compare(b[0],a[0]));

        for(int i = 0; i < n ;i++)
        {
            if(stack.size() == 0)
            {
                double value  = (target - cars[i][0])/cars[i][1];
                stack.push(value);
            }
            else
            {
                double prev =  stack.peek();
                double curr = (target - cars[i][0])/(double)cars[i][1];
                if(curr > prev)

                    stack.push(curr);
                }

        }
        return stack.size();

    }

    static List<String> value;
    public static List<String> letterCasePermutation(String s)
    {
        value = new ArrayList<>();
        letterCasePermutation(s,"");
        return value;

    }

   static void letterCasePermutation(String s, String output)
    {
        if(s.length() == 0)
        {
            value.add(output);
            return;
        }
        if(Character.isDigit(s.charAt(0)))
        {
            s = s.substring(1,s.length());
            output = output + s.charAt(0);

        }
        if(s.length() == 0)
        {
            value.add(output);
            return;
        }
        s = s.substring(1,s.length());
        String output1 = output + Character.toString(s.charAt(0)).toLowerCase();
        String output2 = output + Character.toString(s.charAt(0)).toUpperCase();

        letterCasePermutation(s,output1);
        letterCasePermutation(s,output2);

    }




    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        {
          int[]  position = {6,8,0};
          int[] speed = {3,2};
            BackTrackingProblems r = new BackTrackingProblems();
           int v = r.subset_sum(position,0,0,14,0);
System.out.println(v);
        }
        }
    }








