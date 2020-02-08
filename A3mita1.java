/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package A3mita1;

/**
 *
 * @author mikito
 */
public class A3mita1 {
    static class BinarySearchTree{
        class Node{
            int key;
            Node left, right;
            
            public Node(int item){
                key = item;
                left = right = null;
            }
        }
        Node root;
        
        BinarySearchTree(){
            root =null;
        }
        void insert(int key){
            root = insertRec(root, key);
        }
        Node insertRec(Node root, int key){
            if(root == null){
                root =new Node(key);
                return root;
            }
            if(key<root.key)
                root.left = insertRec(root.left, key);
            else if(key>root.key)
                root.right = insertRec(root.right, key);
            return root;
        }
        public int findMin(){
            Node temp = root;
            while(temp.left!=null)
                temp = temp.left;
            return temp.key;
        }
        public int findMax(){
            Node temp = root;
            while(temp.right!= null)
                temp = temp.right;
            return temp.key;
        }
        public int printDiff(){
            Node temp = root;
            while(temp.left!=null)
                temp = temp.left;
            int min= temp.key;
             temp = root;
            while(temp.right!=null)
                temp = temp.right;
            int max =temp.key;
            return max-min;
        }
        
        void inorder(){
            inorderRec(root);
        }
        private void inorderRec(Node root){
            if(root !=null){
                inorderRec(root.left);
                System.out.println(root.key);
                inorderRec(root.right);
            }
              
        }
    }
 

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insert(40);
        tree.insert(60);
        tree.insert(80);
        tree.inorder();
        System.out.println("The difference of the maximum and minimum values is "+tree.printDiff());
        
      
        
    }
    
    
    
    
    
    
    
    
    
}
