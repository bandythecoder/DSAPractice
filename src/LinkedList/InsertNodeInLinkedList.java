package LinkedList;

public class InsertNodeInLinkedList
{
    public void insertAsFirstNode(LinkedListImpl li ,  LinkedListImpl.Node n)
    {
        LinkedListImpl.Node n1 = li.head;
        n.next =  n1;
        li.head = n;
    }
    public void insertLast(LinkedListImpl li ,  LinkedListImpl.Node n)
    {
        if(li.head == null)
        {
            li.head = n;
            return;
        }
        LinkedListImpl.Node n1 = li.head;

        while (n1.next != null)
        {
            n1 = n1.next;

        }
        n1.next = n;
    }
    public void insertAfterANode(LinkedListImpl li ,  LinkedListImpl.Node prev, LinkedListImpl.Node nodeToBeAdded)
    {
        if(prev == null)
        {
            return;
        }
        LinkedListImpl.Node n = prev.next;
        nodeToBeAdded.next = n;
        prev.next = nodeToBeAdded;

    }
}
