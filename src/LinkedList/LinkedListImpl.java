package LinkedList;

public class LinkedListImpl
{
    // Hello
    public Node head;
   public static class Node {
        int data;
        public Node next;
        public Node(int d)
        {
            data = d;
            next = null;
        }
    }

    public void push(int n)
    {
        if(head == null) head = new Node(n);
        Node newHead = new Node(n);
        newHead.next = head;
        head = newHead;
    }
}
