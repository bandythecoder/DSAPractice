package LinkedList;

public class LinkedListSwaps
{
    Node head;

    public void push(int x)
    {
        Node node = new Node(x);
        if(head == null) head = node;
        else
        {
            var temp = head;
            head = node;
            head.next = temp;
        }
    }

    public void swapNodes(int x, int y)
    {
        // Search x

        Node currNodeX = head;

        Node prevNodeX = null;

        while (currNodeX!= null)
        {
            if(currNodeX.data == x)
            {
                break;
            }

            prevNodeX = currNodeX;
            currNodeX = currNodeX.next;
        }
        Node currNodeY = head;
        Node prevNodeY = null;
        while (currNodeY!= null)
        {
            if(currNodeY.data == y)
            {
                break;
            }

            prevNodeY = currNodeY;
            currNodeY = currNodeY.next;
        }
        if(prevNodeX != null)
        {
            prevNodeX.next = currNodeY;
        }
        else
        {
            head = currNodeY;
        }
        if(prevNodeY != null)
        {
            prevNodeY.next = currNodeX;
        }
        else
        {
            head = currNodeX;
        }
        // Swap nodes now

        var temp = currNodeX.next;
        currNodeX.next = currNodeY.next;
        currNodeY.next = temp;


    }
}
