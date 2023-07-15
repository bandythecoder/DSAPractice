package LinkedList.LinkedListImplementation;

public class CirculerLinkedList {


    private Node head;
    private Node tail;
    private int size;


    public void display()
    {
        var temp = head;
        while(temp.next != head)
        {
            System.out.print(temp.value + " ->");
            temp = temp.next;
        }
        System.out.print(temp.value);
        System.out.println("Break");
    }
    public void insertFirst(int value)
    {
        Node n = new Node(value);
        if(head == null)
        {
            head = n;
            tail = n;
            head.next = head;
        }
        else
        {
           tail.next = n;
           n.next = head;
           head = n;
        }
        size++;
    }


    public void insertLast(int value)
    {
        Node n = new Node(value);
        if(head == null)
        {
            insertFirst(value);
            return;
        }
        else
        {
            tail.next = n;
            n.next = head;
            tail = n;
        }
        size++;
    }

    public void insert(int index, int value)
    {
        if(index == 0)
        {
            insertFirst(value);
        }
        else if(index == size)
        {
            insertLast(value);
        }
        else if(index > size)
        {
            return;
        }
        else
        {
            var temp = head;

            for(int i = 0; i < size && i < index; i++)
            {
                temp = temp.next;
            }
            var node = new Node(value, temp.next);
            temp.next = node;

        }
        size++;
    }

    public void deleteFirst()
    {
        if(head.next == head)
        {
            head = tail = null;
        }
        else
        {
            tail.next = head.next;
            head = head.next;
        }
        size--;
    }

    private Node get(int index)
    {
        if(size -1  < index) return null;
        var temp = head;
        for(int i = 0; i < index; i++)
        {
            temp = temp.next;
        }
        return temp;
    }

    public void delete(int index)
    {
        if(index == 0)
        {
            deleteFirst();
            return;
        } else if (index == size-1)
        {
          deleteLast();
          return;
        }
        else
        {
            var node = get(index-1);
            if(node != null)
            {
                node.next = node.next.next;
            }

        }

        size--;
    }

    public void deleteLast()
    {
        if(size == 1)
        {
            deleteFirst();
        }
        else
        {
            var node = get(size-2);
            tail = node;
            node.next = head;
        }
        size--;
    }
    private class Node
    {
        private int value;
        private Node next;

        public Node(int value)
        {
            this.value = value;
        }

        public Node(int value, Node next)
        {
            this.value = value;
            this.next = next;
        }
    }
}
