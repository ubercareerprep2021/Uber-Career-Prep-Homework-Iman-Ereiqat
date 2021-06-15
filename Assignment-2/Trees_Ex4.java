// Iman Ereiqat
// Uber Career Prep Homework Trees Ex3
// June 9, 2021
//

import java.util.*;

public class Trees_Ex4 
{
    static class Node 
    {
        public int key;
        public Node left;
        public Node right;
        
        public Node(int key)
        {
            this.key = key;
        }
    }
    
    static class BinaryTree
    {
        private Node root;
        
        public BinaryTree(Node root)
        {
            this.root = root;
        }
        
        /**
        * Inserts a key into this binary search tree.
        * If there are n nodes in the tree, 
        * then the average runtime of this method should be log(n).
        * 
        * @param key The key to insert.
        */
        public void insert(int key) 
        {
            Node temp = root;
            
            while (temp != null)
            {
                if (key > temp.key)
                {
                    if (temp.right != null)
                    {
                        temp = temp.right;
                    }
                    else
                    {
                        temp.right = new Node(key);
                        break;
                    }
                }
                else
                { 
                    if (temp.left != null)
                    {
                        temp = temp.left;
                    }
                    else
                    {
                        temp.left = new Node(key);
                        break;
                    }
                }
            }
        }
        
        /**
         * Checks whether or not a key exists in this binary search tree.
         * If there are n nodes in the tree, 
         * then the average runtime of this method should be  log(n).
         * 
         * @param key The key to check for.
         * @return true if the key is present in this binary search tree, 
         * false otherwise.
         */
        public boolean find(int key) 
        {
            Node temp = root;
            
            while (temp != null)
            {
                if (key == temp.key)
                {
                    return true;
                }
                else if (key > temp.key)
                {
                    temp = temp.right;
                }
                else if (key < temp.key)
                {
                    temp = temp.left;
                }
            }
            return false;
        }
        
        // Print with preorder traversal
        List<Integer> nodeList = new ArrayList<>();
        public void print(Node root) 
        {
            preorderTraversal(root);
            System.out.println(nodeList.toString());
            
            if(nodeList.size() > 0)
            {
                nodeList.clear();
            }
        }
        
        public void preorderTraversal(Node root)
        {
            if (root != null) 
            {
                nodeList.add(root.key);
                preorderTraversal(root.left);
                preorderTraversal(root.right);
            }
        }
    }
    
    public static void main(String args[])
    {
        System.out.println("\n***UCP HW TREES EX4***\n");
        
        Node root = new Node(16);
        root.left = new Node(10);
        root.left.left = new Node(7);
        
        BinaryTree tree = new BinaryTree(root);
        root.left.right = new Node(13);
        
        System.out.println("Tree before inserting new nodes: ");
        tree.print(root);
        
        tree.insert(12);
        tree.insert(21);
        tree.insert(18);
        tree.insert(29);
        tree.insert(99);
        tree.insert(17);
        
        System.out.println("Tree after inserting new nodes: ");
        tree.print(root);
        
        boolean result1 = tree.find(12);
        boolean result2 = tree.find(86);
        boolean result3 = tree.find(99);
        
        System.out.printf("\nfind(12): %b\n", result1);
        System.out.printf("find(86): %b\n", result2);
        System.out.printf("find(99): %b\n", result3);
    }
}
