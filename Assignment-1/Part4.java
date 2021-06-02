// Iman Ereiqat
// Uber Career Prep Homework Part 4
// April 30, 2021
//
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
        public void printList()
        {
            Node temp = head;
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
    }
    
    public static void main(String args[])
    {
        MyLinkedList list = new MyLinkedList();
        System.out.println("***UCP HW PT 4 TEST CASES***");
        
        list.push(1);
        System.out.println("testPushBackAddsOneNode: ");
        list.printList();
        System.out.println("");
        
        list.push(2);
        list.push(3);
        list.push(4);
        System.out.println("After pushing 3 more nodes: ");
        list.printList();
        System.out.println("");
        
        Node num = list.pop();
        System.out.printf("testPopBackRemovesCorrectNode: %d\n", num.value);
        list.printList();
        System.out.println("");
        
        list.remove(1);
        System.out.println("testEraseRemovesCorrectNode: index 1");
        list.printList();
        System.out.println("");
        
        list.remove(4);
        System.out.println("testEraseDoesNothingIfNoNode: index 4");
        list.printList();
        System.out.println("");
        
        Node e = list.elementAt(1);
        System.out.printf("testElementAtReturnNode: index 1 = %d\n", e.value);
        list.printList();
        System.out.println("");
        
        Node n = list.elementAt(3);
        System.out.println("testElementAtReturnNode: index 3 = " + n);
        list.printList();
        System.out.println("");
        
        System.out.printf("testSizeReturnsCorrectSize: %d\n", list.size());
        list.printList();
        System.out.println("");
        
        boolean hasCycle = list.hasCycle(list.elementAt(1));
        System.out.println("testIfListHasCycle: " + hasCycle);
    }
}