package LinkedList;

public class BrowserHistory {
    DoublyLinkedList list;
    public BrowserHistory(String homepage) {
        list = new DoublyLinkedList(homepage);
    }

    public void visit(String url) {
        list.add(url);
    }

    public String back(int steps) {
        return list.back(steps);
    }

    public String forward(int steps) {
        return list.forward(steps);
    }

    class DoublyLinkedList
    {
        ListNode head;
        ListNode tail;
        ListNode curr;


        public DoublyLinkedList(String val)
        {
            head =  new ListNode("");
            tail = new ListNode("");
            head.next = tail;
            tail.next = head;
            curr = head;


        }

        public void add(String url)
        {
            ListNode node = new ListNode(url);
            curr.next = node;
            node.next = tail;
            tail.previous = node;
            node.previous = curr;
            curr = curr.next;
        }

        public String back(int steps)
        {
            while(curr.previous != head && steps > 0 )
            {
                curr = curr.previous;
                steps--;

            }
            return curr.val;

        }

        public String forward(int steps) {
            while(curr.next != tail && steps > 0)
            {
                curr = curr.next;
                steps--;
            }
            return curr.val;

        }
        class ListNode
        {
            String val;
            ListNode next;
            ListNode previous;


            ListNode(String val)
            {
                previous = null;
                next = null;
                this.val = val;
            }
        }
    }
}
