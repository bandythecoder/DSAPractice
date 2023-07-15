package Spring.Framework;

import LinkedList.LinkedListImplementation.CirculerLinkedList;
import LinkedList.LinkedListImplementation.DoublyLinkedList;
import LinkedList.LinkedListImplementation.SingleLinkedList;



public class Main {

    public static void main(String args[]) {
         CirculerLinkedList sll = new CirculerLinkedList();
        sll.insertFirst(10);
        sll.insertFirst(12);
        sll.insertFirst(15);
        sll.insertLast(17);
        sll.insert(2, 11);
        sll.display();
        sll.deleteLast();
        sll.display();
        sll.deleteFirst();
        sll.display();
        sll.delete(1);
        sll.display();



    }



   
    }














