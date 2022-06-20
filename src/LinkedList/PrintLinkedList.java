package LinkedList;

public class PrintLinkedList
{
    LinkedListImpl li ;

    public PrintLinkedList(LinkedListImpl li) {
        this.li = li;
    }
    public void printLinkedList()
    {
        LinkedListImpl.Node n = li.head;
        while(n != null)
        {
            System.out.println(n.data);
            n = n.next;
        }
    }

}
