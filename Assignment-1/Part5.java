// Iman Ereiqat
// Uber Career Prep Homework Part 5
// May 12, 2021
//

import java.util.*;


public class Part4 
{
    // Node class
    static class Node
    {
        int value;
        Node next;
        
        public Node(int val)
        {
            value = val;
            next = null;
        }
        
        public Node (int val, Node n)
        {
            value = val;
            next = n;
        }    
    }
    
    // LinkedList class
    static class MyLinkedList
    {
        Node head;
    
        // Initalize LinkedList
        public MyLinkedList() 
        {
            head = null;
        }
    
        // Push method adds node to end of the list
        public void push(int val) 
        {
            if (head == null)
            {
                head = new Node(val);
            }
            else
            {
                Node temp = head;
                while (temp.next != null)
                {
                    temp = temp.next;
                }
                temp.next = new Node(val); 
            }
        }
        
        // Pop method removes last node at the end of the list
        // Returns the popped node
        public Node pop() 
        {
            if (head == null)
            {
                return null;
            }
            else
            {
                Node temp = head; 
                Node prev = null; 
                
                while (temp.next != null) 
                {
                    prev = temp; 
                    temp = temp.next; 
                }
                
                Node popped = temp;
                prev.next = temp.next;
                return popped;
            }
        }
        
        // Insert method adds a single node containing
        // data to a chosen index at the list
        // If index is greater than the size of the list
        // it does nothing
        public void insert(int index, Node node) 
        {        
            Node temp = head; 
            Node prev = null; 
            int count = 0;
            
            if (temp == null && index == 0)
            {
                head = node;
            }
            
            if (temp != null)
            {
                if (index == 0)
                {
                    node.next = head;
                    head = node;
                }
                while (temp.next != null && count < index) 
                {
                    prev = temp; 
                    count++; 
                    temp = temp.next; 
                }
                if (count == 0) 
                {
                    node.next = temp; 
                    temp = node; 
                }
                if (prev == null)
                {
                    node.next = temp;
                    temp = node;
                }
                else if (count == index) 
                {
                    node.next = temp;
                    prev.next = node;
                } 
                else if (temp.next == null && count == index - 1)
                {
                    temp.next = node;
                }
            }
        }
        
        // Remove method removes a single node 
        // at the chosen index
        // If node doesn't exist, do nothing
        public void remove(int index) 
        {        
            Node temp = head;
            Node prev = null;
            int count = 0;
            
            if (temp != null)
            {
                if (index == 0)
                {
                    head = head.next;
                }
                else
                {
                    while (temp.next != null && count < index)
                    {
                        prev = temp; 
                        count++; 
                        temp = temp.next; 
                    }
                    if (count == index)
                    {
                        if (prev == null)
                        {
                            head = null;
                        }
                        else
                        {
                            prev.next = temp.next;
                        }
                    }
                }
            }
        }
        
        // elementAt method returns a pointer to the
        // node at the chosen index
        // Returns null if there is no node
        public Node elementAt(int index) 
        {
            Node temp = head;
            int count = 0;
            
            if (temp != null)
            {
                if (index == 0)
                {
                    return head;
                }
                while (temp.next != null && count < index)
                {
                    count++;
                    temp = temp.next;
                }
                if (count == index)
                {
                    return temp;
                }
            }   
            return null;
        }
        
        // Size method returns the size of the list
        public int size()
        {
            int size = 0;
            Node temp = head;
            
            while (temp != null)
            {
                size++;
                temp = temp.next;
            }
            return size;
        }
        
        // printList method returns a string 
        // representation of the list
        public void printList(Node node)
        {
            Node temp = node;
            String list = "";
            
            while (temp != null)
            {
                list += temp.value;
                if (temp.next != null)
                {
                    list += "->";
                }
                temp = temp.next;
            }
            System.out.println(list);
        }
        
        // hasCycle method returns a boolean
        // if the given node references an earlier node
        // as it's "next" reference
        public boolean hasCycle(Node head) 
        {
            if (head == null)
            {
                return false;
            }
            Node s = head; 
            Node f = head.next; 
            
            while (s != f)
            {
                if (f == null || f.next == null)
                {
                    return false;
                }
                s = s.next; 
                f = f.next.next; 
            }
            return true;
        }
        
        // reverseLinkedListIteratively 
        // Iterative approach at reversing a linked list
        //
        public Node reverseLinkedListIteratively(Node node)
        {
            Node curr = node, prev = null, next = null;
            
            while (curr != null)
            {
                next = curr.next; 
                curr.next = prev; 
                prev = curr;
                curr = next;
            }
            return prev;
        }
        
        // reverseLinkedListStack
        // Reverse a linked list using a stack
        //
        public Node reverseLinkedListStack(Node head)
        {
            Stack<Node> stack = new Stack<Node>();
            Node temp = head;
            
            while (temp.next != null)
            {
                stack.push(temp);
                temp = temp.next;
            }
            
            head = temp;
            while (!stack.isEmpty())
            {
                temp.next = stack.peek();
                temp = temp.next;
                stack.pop();
            }
            temp.next = null;
            
            return head;
        }
        
        // reverseLinkedListRecursively
        // Recursive approach at reversing a linked list
        //
        public Node reverseLinkedListRecursively(Node node)
        {
            if (node == null || node.next == null)
            {
                return node;
            }
            Node rNode = reverseLinkedListRecursively(node.next); 
            node.next.next = node; 
            node.next = null;   
            
            return rNode; 
        }
    }
    
    public static void main(String args[])
    {
        MyLinkedList list = new MyLinkedList();
        System.out.println("\n***UCP HW PT 5 TEST CASES***\n");
        
        list.push(1);
        list.push(2);
        list.push(3);
        list.push(4);
        list.push(5);
        list.push(6);
        list.push(7);
        list.push(8);
        
        System.out.println("Original list: ");
        list.printList(list.head);
        System.out.println("");
 
        System.out.println("After reversing the list iteratively: ");
        Node iterativelyReversedList = list.reverseLinkedListIteratively(list.head);
        list.printList(iterativelyReversedList);
        System.out.println("");
        
        System.out.println("After reversing the list recursively: ");
        Node recursivelyReversedList = list.reverseLinkedListRecursively(iterativelyReversedList);
        list.printList(recursivelyReversedList);
        System.out.println("");
        
        System.out.println("After reversing the list with Stack: ");
        Node stackReversedList = list.reverseLinkedListRecursively(recursivelyReversedList);
        list.printList(stackReversedList);
        System.out.println("");
    }
}