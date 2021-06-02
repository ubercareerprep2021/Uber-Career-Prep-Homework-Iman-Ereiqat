public class Part3
{
    /*
        Iman Ereiqat
        Uber Career Prep Homework Part 3
        April 16, 2021
    */
    
    //
    // 
    // Stack data structure takes in objects according to LIFO principle
    //
    //
    static class Stack
    { 
        int[] arr;  // Array to hold items
        int index;  // To keep track of elements
        
        // Constructor - initalize stack
        //
        public Stack() 
        {
            arr = new int[1000];
            index = 0;
        } 
        
        // Pushes an integer on top of the stack
        //
        public void push(int val) 
        {
            if (index < arr.length)
            {
                arr[index] = val;
                System.out.println(arr[index]);
                index++;
            }
        }
    
        // Removes the integer on top of the stack & returns it
        // Returns -1 if stack is empty
        //
        public int pop() 
        {
            int popped_value = -1;
            
            if (index - 1 >= 0)
            {
                popped_value = arr[index - 1];
                arr[index - 1] = -1;
                index--;
            }
            return popped_value;
        }
        
        // Returns the value at the top of the stack
        // Returns -1 if stack is empty
        //
        public int top() 
        {
            if (index - 1 >= 0)
            {
                return arr[index - 1];
            }
            return -1;
        }
        
        // Returns the minimum value in the stack
        // Returns -1 if stack is empty
        //
        public int min() 
        {
            if (index - 1 < 0)
            {
                return -1;
            }
            
            int min = Integer.MAX_VALUE;
            for (int i = 0; i <= index - 1; i++)
            {
                if(arr[i] < min)
                {
                    min = arr[i];
                }
            }
            return min;
        }
        
        // Returns true if stack is empty
        // Otherwise, returns false
        //
        public Boolean isEmpty()
        {
            if (index - 1 >= 0)
            {
                return false;
            }
            return true;
        }
        
        // Returns the number of elements in the stack
        //
        public int size()
        {
            return index;
        }
    }
    

    //
    // 
    // Queue data structure takes in & removes objects according to FIFO principle
    //
    //
    static class Queue
    {
        int[] arr;  // Array for holding items
        int index;  // Keep track of number of elements
        int front;  // Keep track of the front index of queue
        int rear;   // Keep track of the rear index of queue
        
        // Constructor - initalize queue
        //
        public Queue()
        {
            arr = new int[1000];
            index = 0;
            front = 0;
            rear = -1;
        }
        
        // Add an item to the queue
        //
        public void enqueue(int val)
        {
            rear++;
            arr[rear] = val;
            index++;
        }
        
        // Remove an item from the queue & return it
        // Returns -1 if queue is empty
        //
        public int dequeue()
        {
            int dequeued_item = -1;
            if (index > 0)
            {
                dequeued_item = arr[front];
                front++;
            }
            return dequeued_item;
        }
        
        // Returns the element at the rear of the queue
        // Returns -1 if queue is empty
        //
        public int rear()
        {
            if (index > 0)
            {
                return arr[rear];
            }
            return -1;
        }
        
        // Returns the element at the front of the queue
        // Returns -1 if queue is empty
        //
        public int front()
        {
            if (index > 0)
            {
                return arr[front];
            }
            return -1;
        }
        
        // Returns the number of elements in the queue
        //
        public int size()
        {
            return index;
        }
        
        // Returns true if queue is empty
        // Otherwise, returns false
        //
        public Boolean isEmpty()
        {
            if (index > 0)
            {
                return false;
            }
            return true;
        }
    }
    
     public static void main(String []args)
     {
        System.out.println("**********STACK**********");
        
        Stack myStack = new Stack();
        myStack.push(42);
        
        System.out.printf("Top of stack: %d\n", myStack.top());
        System.out.printf("Size of stack: %d\n", myStack.size());
        
        int popped_value = myStack.pop();
        popped_value = myStack.pop();
        
        System.out.printf("Popped value: %d\n" , popped_value);
        System.out.printf("Size of stack: %d\n", myStack.size());
        System.out.printf("Minimum: %d\n\n", myStack.min());
        
        
        System.out.println("**********QUEUE**********");

        Queue myQueue = new Queue();
        
        myQueue.enqueue(1);
        myQueue.enqueue(2);
        myQueue.enqueue(3);
        
        System.out.printf("Size of queue: %d\n", myQueue.size());
        System.out.printf("Front of queue: %d\n", myQueue.front());
        System.out.printf("Rear of queue: %d\n", myQueue.rear());
        
        int dequeuedItem = myQueue.dequeue();
        
        System.out.printf("Dequeue item: %d\n", dequeuedItem);
     }
}