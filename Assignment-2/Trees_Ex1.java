// Iman Ereiqat
// Uber Career Prep Homework Trees Ex1
// May 26, 2021
//

import java.util.*;


public class Ex1 
{
    // TreeNode class
    static class TreeNode
    {
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data, TreeNode left, TreeNode right) 
        {
            this.data = data;
            this.left = left;
            this.right = right;
         }
    }
    
    // Tree class
    static class Tree
    {
        TreeNode root;
        
        public Tree(TreeNode root) 
        {
            this.root = root;
        }
        
        List<Integer> nodeList = new ArrayList<>();
    
        // Function Print takes in a TreeNode
        // and prints the tree in preorder
        public void print(TreeNode root) 
        {
            preorderTraversal(root);
            System.out.println(nodeList.toString());
            
            if(nodeList.size() > 0)
            {
                nodeList.clear();
            }
        }
        
        public void preorderTraversal(TreeNode root)
        {
            if (root != null) 
            {
                nodeList.add(root.data);
                preorderTraversal(root.left) ;
                preorderTraversal(root.right);
            }
        }
    }
    
    public static void main(String args[])
    {
        System.out.println("\n***UCP HW EX1***\n");
       
        TreeNode leftChild = new TreeNode(6, null, null);
        TreeNode rightChild = new TreeNode(3, null, null);
        TreeNode left = new TreeNode(7, null, null);
        TreeNode right = new TreeNode(17, leftChild, rightChild);
        TreeNode root = new TreeNode(1, left, right);
        Tree tree = new Tree(root);
        
        System.out.println("Ex 1 - Print Method Using Preorder Traversal:");
        tree.print(root);
    }
}