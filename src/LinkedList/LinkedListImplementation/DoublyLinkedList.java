package LinkedList.LinkedListImplementation;

public class DoublyLinkedList {
    Node head;
    Node tail;
    int size;

    public void insertFirst(int data) {
        Node n = new Node(data);
        if (head == null) {
            head = tail = n;
        } else {
            head.previous = n;
            n.next = head;
            head = n;
        }
        size++;
    }

    public void insertLast(int data) {

        if (head == null) {
            insertFirst(data);
            return;
        } else {
            Node n = new Node(data);
            tail.next = n;
            n.previous = tail;
            tail = n;
        }
        size++;
    }

    public void insert(int index, int value) {
        if (index == 0) {
            insertFirst(value);
            return;
        }
        if (index == size) {
            insertLast(value);
            return;
        }
        if (index > size) {
            System.out.println("Can't add Node");
            return;
        }
        var temp = head;
        int count = 0;
        while (temp != null && count == index - 1) ;
        {
            temp = temp.next;
            count++;
        }
        Node n = new Node(value, temp.next, temp);
        temp.next.previous = n;
        temp.next = n;
        size++;
    }

    public void displayFront()
    {
        var temp = head;
        for(int i = 0; i < size ; i++)
        {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
    public void displayReverse()
    {
        var temp = tail;
        for(int i = size -1; i >= 0 ; i--)
        {
            System.out.println(temp.data);
            temp = temp.previous;
        }
    }

    public void deleteFirst()
    {
        if(head.next == null)
        {
            head = tail = null;
        }

        head = head.next;
        head.previous = null;
        size--;
    }

    public void deleteLast()
    {
        if(head.next == null)
        {
            head = tail = null;
        }

        tail = tail.previous;
        tail.next = null;
        size--;
    }

    public void delete(int index)
    {
        if(index == 0) {
            deleteFirst();
            return;
        }
        if(index == size -1) {
            deleteLast();
            return;
        }

        var temp = head;
        int count = 0;
        while(temp != null && count != index -1)
        {
            temp = temp.next;
            count++;
        }

        temp.next = temp.next.next;
        if(temp.next != null)
        {
            temp.next.previous = temp;
        }
        size--;
    }



    private class Node
    {
        int data;
        Node next;
        Node previous;

        public Node(int data)
        {
            this.data = data;
        }

        public Node(int data, Node next, Node previous)
        {
            this.data = data;
            this.next = next;
            this.previous = previous;
        }

    }
}
