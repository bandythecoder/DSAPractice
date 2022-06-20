package Algoritham;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class RecursionProblems {

    // sort an Array

    public static void sort(int[] arr, int l)
    {
        if(l == 0) return ;
        int value = arr[l-1];
        sort(arr, l-1);
        insert(arr,value, l-1);
    }

    private static void insert(int[] arr, int value, int length) {
        if(length == 0 || arr[length-1] <= value)
        {
            arr[length] = value;
            return;
        }
        int temp = arr[length-1];

        insert(arr,value,length-1);
        arr[length] = temp;
    }


    public static void sortStack(Stack<Integer> stack)
    {
        if(stack.size() == 0) return ;
        int value = stack.pop();
        sortStack(stack);
        insertStack(stack,value);
    }
    private static void insertStack(Stack<Integer> stack, int value) {
        if(stack.isEmpty() || stack.peek() <= value)
        {
            stack.push(value);
            return;
        }
        int temp = stack.pop();

        insertStack(stack,value);
        stack.push(temp);
    }

    // Delete the Middle element of Stack

    public void deleteMiddleElement(Stack<Integer> s)
    {
        int k = s.size()/2 + 1;
        deleteKthElement(s,k);
    }

    private void deleteKthElement(Stack<Integer> s, int k)
    {
        if(k==1)
        {
            s.pop();
            return;
        }
        var value = s.pop();
        deleteKthElement(s,k-1);
        s.push(value);
    }


    // Recursion - reverse a stack

    public void reverseStack(Stack<Integer> s)
    {
        if(s.size() == 1)
        {
            return;
        }
        var value = s.peek();
        s.pop();
        reverseStack(s);
        insertValueAtTheBeginOfStack(s, value);
    }

    private void insertValueAtTheBeginOfStack(Stack<Integer> s, Integer val)
    {
        if(s.size() == 0)
        {
            s.push(val);
            return;
        }
        var  value =  s.pop();
        insertValueAtTheBeginOfStack(s,val);
        s.push(value);

    }

    public  int kthGrammar(int n, int k) {
        if(k == 0) return 0;
        return solve(n,k);
    }

    private  int solve(int n, int k)
    {
        if(n == 1 && k == 1)
        {
            return 0;
        }
        int mid = (int)Math.pow(2,n-1);
        mid = mid/2;
        if(k <= mid)
        {
            return solve(n-1, k);
        }
        else
        {
            return solve(n-1,k-mid) ;
        }

    }

    public void towerOfHanoi(int n, char one, char two , char three)
    {
        if(n==1)
        {
            System.out.println("Shift disk " + 1 + " from " + one + " to " + three);
            return;
        }
        towerOfHanoi(n-1,one,three,two);
        System.out.println("Shift disk " + n + " from " + one + " to " + three);
        towerOfHanoi(n-1,two,one,three);
    }
     Set<String> set;

    public RecursionProblems() {
        this.set =  new HashSet<>();
    }


    public void printSubset(String input, String output)
    {
        if(set.contains(input + "~" + output)) return;
        set.add(input + "~" + output);

        if(input.length() == 0)
        {
            System.out.println(output);
            return;
        }
        String output1 = output;
        String output2 = output + input.charAt(0);

        printSubset(input.substring(1,input.length()), output1);
        printSubset(input.substring(1,input.length()), output2);
    }

    public void printPermutation(String input, String output)
    {
        if(set.contains(input + "~" + output)) return;
        set.add(input + "~" + output);

        if(input.length() == 1)
        {
            System.out.println(output + input);
            return;
        }
        String output1 = output + input.charAt(0);
        String output2 = output + input.charAt(0) + "-";

        printPermutation(input.substring(1,input.length()), output1);
        printPermutation(input.substring(1,input.length()), output2);
    }

    public void printPermutationCase(String input, String output)
    {
        if(input.length() == 0)
        {
            System.out.println(output);
            return;
        }
        if(Character.isDigit(input.charAt(0)))
        {
            output = output + input.charAt(0);
            input = input.substring(1,input.length());
        }
        if(input.length() == 0)
        {
            System.out.println(output);
            return;
        }
        String output1 = output + Character.toString(input.charAt(0)).toLowerCase();
        String output2 = output + Character.toString(input.charAt(0)).toUpperCase();
        input = input.substring(1,input.length());

        printPermutationCase(input,output1);
        printPermutationCase(input,output2);

    }

    public void generateAllParentheses(int open, int close , String output)
    {
        if(open == 0 && close == 0)
        {
            System.out.println(output);
            return;
        }

        if(open == close)
        {
            open = open -1;
            output = output + "(";
            generateAllParentheses(open,close,output);
        }
        else
        {
            if(open != 0) {
                String output1 = output + "(";
                generateAllParentheses(open - 1, close, output1);
            }
            String output1 = output + ")";
            generateAllParentheses(open, close-1,output1);
        }
    }


    public void printNbitNumbersWherePrefix1GreaterThan0(int ones, int zero, int n ,String output)
    {

        // BC
        if(n==0)
        {
            System.out.println(output);
            return;
        }

        if(output == "")
        {
            output = "1";
            printNbitNumbersWherePrefix1GreaterThan0(1,0,n-1,output);
        }
        else if(ones > zero)
        {
            String output1 = output + "1";
            printNbitNumbersWherePrefix1GreaterThan0(ones+1,zero,n-1,output1);
            String output2 = output + "0";
            printNbitNumbersWherePrefix1GreaterThan0(ones,zero+1,n-1,output2);
        }
        else if(ones <= zero)
        {
            String output1 = output + "1";
            printNbitNumbersWherePrefix1GreaterThan0(ones+1,zero,n-1,output1);
        }
    }

    public int joesphusGame(int n , int k)
    {
        if(n== 1) return 1;

        return (joesphusGame(n-1,k) + k-1) % n+1;
    }
    
}
