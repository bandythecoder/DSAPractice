package LinkedList.LinkedListImplementation;

public class SingleLinkedList
{
    Node head;
    Node tail;
    int size;

    public SingleLinkedList()
    {
        this.size = 0;
    }

    public void insertFirst(int value)
    {
        Node node = new Node(value);
        node.next = head;
        head = node;
        if(tail == null)
        {
            tail = head;
        }
    }

    public void insertLast(int value)
    {
        Node node = new Node(value);
        if(tail == null)
        {
            tail = node;
            head = node;
        }
        else
        {
            tail.next = node;
            tail = node;
        }
    }

    public void insert(int index, int value)
    {
        Node n = new Node(value);
        Node n1 = head;
        int i = 0;
        while(n1 != null && i != index -1)
        {
            n1 = n1.next;
            i++;
        }
        if(n1 == null)
        {
            return;
        }

        Node next = n1.next;
        n1.next = n;
        n.next = next;
    }

    public void display()
    {
        Node n = head;
        while(n != null)
        {
            System.out.println(n.value);
            n = n.next;
        }

    }

    private class Node
    {
        private int value;
        private Node next;
        public Node(int value)
        {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

}


