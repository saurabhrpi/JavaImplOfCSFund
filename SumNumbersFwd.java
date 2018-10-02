import java.io.*;
import java.util.*;

class Node{
    int d;
    Node next;
    
    Node()
    {
        
    }
    
    Node(int i)
    {
        d = i;
        next = null;
    }
    
    void appendToTail(Node n)
    {
        if(this.next == null)
        {
            this.next = n; 
        }
        else
        {
            Node next = this.next;
            while(next.next != null)
            {
               // System.out.println("next is: " + next.d);
                next = next.next;
            }
            //System.out.println("n is: " + n.d);
            next.next = n;
        }
    }
}

class myLinkedList{
    
    void printLL(Node head)
    {
        Node next = head;
        while(next != null)
        {
            System.out.println(next.d);
            next = next.next;
        }
    }
    
    Node deleteNode(Node head, Node del)
    {
        System.out.println("del node requested "+ del.d);   
        if(head == null)
        {
            return null;
        }
        else
        {
            if(del == head)
            {
                head = head.next;
            }
            else
            {
                Node next = head; 
                while(next.next != null)
                {
                    if(next.next == del)
                    {
                        next.next = del.next;
                        break;
                    }
                    next = next.next;
                }
            }
        }
        System.out.println("head returned "+ head.d);
        return head;
    }
    
    public int length(Node head)
    {
        int count = 0;
        
        while(head != null)
        {
            count++;
            head = head.next;
        }
        
        return count;
    }
}

class Carry{
    public int car = 0; 
}

public class SumNumbersFwd{
        
    public Node stuffZeroes(Node head, int l)
    {
        
        myLinkedList ll = new myLinkedList();
        
        while(l > 0)
        {
            head = ll.appendToHead(head, new Node(0));
            l--;
        }
        
        return head;
    }
    
    public Node recurseHandler(Node first, Node second)
    {
        myLinkedList ll = new myLinkedList();
        
        int l = ll.length(first) - ll.length(sec);
        
        if(l != 0)
        {
            if(l > 0)
            {
                sec = stuffZeroes(sec,l);   
            }
            else
            {
                first = stuffZeroes(first,(0-l));
            }
        }
        
        Carry c = new Carry();
        
        Node res = recurseResult(first, second, c);
        
        if(c.car == 1)
        {
            Node head = new Node(1);
            head.next = res;
            return head;
        }
        
        return res;
    }
    
    public Node recurseResult(Node first, Node second, Carry c)
    {
        if(first == null && second == null)
        {
            return null;
        }
        
        Node res = new Node();
        
        res.appendToTail(recurseResult(first == null? null : first.next,
                                       second == null? null : second.next,
                                       c
                                       ));
    
        if(first != null)
        {
            c.car += first.d;
        }
        
        if(second != null)
        {
            c.car += second.d;
        }
        
        if(c.car >= 10)
        {
            res.d = c.car % 10;
            c.car = 1;
        }
        else
        {
            res.d = c.car;
            c.car = 0;
        }
        
        return res;
    }

    // 237, 9891
    public static void main(String args[]) {
        
        SumNumbersFwd rd = new SumNumbersFwd();
        
        myLinkedList ll = new myLinkedList();
        
        Node head = new Node(7);
        head.appendToTail(new Node(3));
        head.appendToTail(new Node(2));
        
        Node head2 = new Node(4);
        head2.appendToTail(new Node(1));
        head2.appendToTail(new Node(3));
        
        Node head3 = new Node(1);
        head3.appendToTail(new Node(9));
        head3.appendToTail(new Node(8));
        head3.appendToTail(new Node(9));
        head3.appendToTail(new Node(7));
        
        //head = rd.result(head3,head2);
        
        head =  rd.recurseHandler(head2, head);
        
        if(head == null)
        {
            System.out.println("Please enter a non null list");
        }
        else
        {
            if(head.next == null)
            {
                System.out.println("There is only one element in the list");
            }
            else
            {
                System.out.println("Linked list after calling functionality");
                ll.printLL(head);   
            }
        }
    }
}
