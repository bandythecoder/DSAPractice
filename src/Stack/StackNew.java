package Stack;

import java.util.LinkedList;
import java.util.List;

public class StackNew
{
    int index = -1;
    int size = 3;
    int[] li = new int[size];
    public StackNew()
    {
    }

    public void push(int x)
{
      if(index == size -1)
      {
          int[] temp = new int [2*size];
          size = 2* size;
          for(int i  = 0; i < li.length; i++)
          {
              temp[i] =  li[i];
          }
          li = temp;
      }
    li[++index] = x;
}

    public int pop()
    {
        var x = li[index];
        index--;
        return x;
    }

    public int top()
    {
        var x = li[index];
        return x;
    }

public boolean isEmpty()
{
     return index == -1;
}


}
