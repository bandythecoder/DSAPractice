package Stack;

public class QueueCustom {

    int front = 0;
    int rear;
    int size;
    int[] arr;

    public QueueCustom()
    {
        size = 0;
        arr = new int[2];
    }

    public void add(int x)
    {
        if(arr.length == size)
        {
            int len = arr.length * 2;
            int[] temp = new int[len];
            for(int i = 0; i < arr.length; i++)
            {
                int j = (i+ front)%arr.length;
                temp[i] = arr[j];
            }
            arr = temp;
            front = 0;
            arr[size++] = x;

        }
        else
        {
            int rear = (front + size) % arr.length;
            arr[rear] = x;
            size++;
        }

    }

   public int remove()
    {
        if(size > 0)
        {
            var x = arr[front];
            front++;
            size--;
            return x;
        }
        return Integer.MAX_VALUE;
    }


    int peek()
    {
        if(size > 0)
        {
            return arr[front];
        }
        return Integer.MAX_VALUE;
    }

}
