package LinkedList;

public class DeleteNodeLinkedList
{
    public void deleteNodes(LinkedListImpl li , LinkedListImpl.Node n)
    {
        LinkedListImpl.Node node = li.head;
        while(node.next != n)
        {
            node = node.next;
        }
        node.next = n.next;
    }
}
