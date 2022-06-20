package LinkedList;

import java.text.BreakIterator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.Stack;

public class LinkedListProblems
{
    public int findLengthOfLinkedList(LinkedListImpl li)
    {
        if(li.head == null) return 0;
        LinkedListImpl.Node n = li .head;
        int count = 0;
        while (n.next != null)
        {
            count = count + 1;
            n = n.next;
        }
        return count +1;
    }

    public boolean search(LinkedListImpl li, int element)
    {
        if(li.head == null) return false;
        LinkedListImpl.Node n = li .head;
        while (n != null)
        {
            if(n.data == element) return true;
            n = n.next;

        }
        return false;
    }

    public int findMiddle(LinkedListImpl li)
    {
      LinkedListImpl.Node slowPointer = li.head;
      LinkedListImpl.Node fastPoint = li.head;

      while(fastPoint != null && fastPoint.next != null )
      {
          slowPointer = slowPointer.next;
          fastPoint = fastPoint.next.next;
      }
      return  slowPointer.data;
    }

    public boolean findLoopUsingExtraSpace(LinkedListImpl li)
    {
        LinkedListImpl.Node n = li.head;
        Set<LinkedListImpl.Node> set = new HashSet<>();
        while(n != null)
        {
            if(set.contains(n))
            {
                return true;
            }
            set.add(n);
            n = n.next;
        }
        return false;
    }

    public boolean findLoop(LinkedListImpl li)
    {
        LinkedListImpl.Node slow_p = li.head;
        LinkedListImpl.Node fast_p = li.head;
        while (slow_p !=null && fast_p!=null && fast_p.next!=null)
        {
            slow_p = slow_p.next;
            fast_p = fast_p.next.next;

        /* If slow_p and fast_p meet at some point
        then there is a loop */
            if (slow_p == fast_p)
                return true;
        }
        return false;
    }

    public int findLoopLength(LinkedListImpl li)
    {
        LinkedListImpl.Node slow_p = li.head;
        LinkedListImpl.Node fast_p = li.head;
        while (slow_p !=null && fast_p!=null && fast_p.next!=null)
        {
            slow_p = slow_p.next;
            fast_p = fast_p.next.next;

        /* If slow_p and fast_p meet at some point
        then there is a loop */

            if (slow_p == fast_p)
            {
                int count = 1;
                while(slow_p.next != fast_p)
                {
                    count++;
                   slow_p =  slow_p.next;
                }
                return count;
            }
        }
        return 0;
    }

    public boolean findIfLinkedLPalindrome(LinkedListImpl li)
    {
        Stack<Integer> s = new Stack<>();
        LinkedListImpl.Node node = li.head;
        while(node != null)
        {
            s.push(node.data);
                node = node.next;

        }
        node = li.head;
        boolean isPalindrome = false;
        while (node!= null)
        {
            if(node.data == s.pop())
                isPalindrome =  true;
            else
                {
                    isPalindrome = false;
                break;
                }
            node = node.next;
        }
        return isPalindrome;
    }


    public boolean findIfLinkedLPalindromeWithNoExtraMemory(LinkedListImpl li) {
        LinkedListImpl.Node slowPointer = li.head;
        LinkedListImpl.Node fastPointer = li.head;
        LinkedListImpl.Node mid  = null;
        while(fastPointer != null && fastPointer.next != null)
        {

            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;

        }
        if(fastPointer != null)
        {

            slowPointer = slowPointer.next;
        }
        mid = slowPointer;
        LinkedListImpl.Node prev = null;
        LinkedListImpl.Node next = null;
        LinkedListImpl.Node curr = slowPointer;
        while (curr != null)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
    }
        mid.next = prev;
       return compareTwoList(li, mid);

    }

    private boolean compareTwoList(LinkedListImpl li, LinkedListImpl.Node slowPointer)
    {

        LinkedListImpl.Node head = li.head;
        LinkedListImpl.Node second = slowPointer.next;
        boolean isPalindrome = false;
        while(head != slowPointer.next && second != null)
        {
            if(head.data == second.data)
            {
                isPalindrome = true;
            }
            else
            {
                isPalindrome = false;
                break;
            }
        }
        return isPalindrome;
    }

    public void removeDuplicates(LinkedListImpl li)
    {
        LinkedListImpl.Node node = li.head;
        while( node != null && node.next != null)
        {
            if(node.data == node.next.data)
            {
                node.next = node.next.next;
            }
            else
            {
                node = node.next;
            }
        }

    }


}
