/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a3mita2;
import java.util.Iterator; 
import java.util.ArrayDeque; 
import java.lang.Math; 
/**
 *
 * @author mikito
 */
public class A3mita2 {
public static class AvlTree<E extends Comparable<? super E>> implements Iterable<E>{
   private class AvlNode<E extends Comparable<? super E>>{
      private E element;
      private AvlNode<E> left;
      private AvlNode<E> right;
      int height;
      public AvlNode(E e){
	 this(e, null, null);
      }
      public AvlNode(E e, AvlNode<E> l, AvlNode<E> r){
	 element = e;
	 left = l;
	 right = r;
         height = 0;
         if (l != null && r != null) height = Math.max(l.height, r.height) + 1;
         else if (r != null) height = r.height + 1;
         else if (l != null) height = l.height + 1;
      }
      public E getE(){
	 return element;
      }
      public AvlNode<E> getLeft(){
	 return left;
      }
      public AvlNode<E> getRight(){
	 return right;
      }
      public int getHeight(){
	 return height;
      }
      public void setE(E e){
	 element = e;
      }
      public void setLeft(AvlNode<E> l){
	 left = l;
      }
      public void setRight(AvlNode<E> r){
	 right = r;
      }
      public void setHeight(int h){
	 height = h;
      }
   }
   private class TreeIterator<E extends Comparable<? super E>> implements Iterator<E>{
      private ArrayDeque<AvlNode<E>> stack;
      public TreeIterator(AvlTree<E> tr){
         stack = new ArrayDeque<>();
         add((AvlNode<E>) tr.getRoot());
      }
      public boolean hasNext(){
         return !stack.isEmpty();
      }
      private void add(AvlNode<E> n){
	 while (n != null){
	    stack.push(n);
            n = n.left;
         }
      }
      public E next(){
         AvlNode<E> temp = stack.pop();
	 E ans = temp.getE();
	 add(temp.right);
         return ans;
      }
   }
   private AvlNode<E> root;
   private int size;
   public AvlTree(){
      root = null;
      size = 0;
   }
   private AvlNode<E> balance(AvlNode<E> n){
   if (n == null || isLeaf(n))
      return n;
   int bFactor = height(n.left) - height(n.right);
   if (bFactor > 1){
      if (height(n.left.left) >= height(n.left.right))
         n = rotateLeftChild(n);
      else
         n = doubleLeftChild(n);
   }
   else if (bFactor < -1){
      if (height(n.right.right) >= height(n.right.left))
	 n = rotateRightChild(n);
      else
	 n = doubleRightChild(n);
   }
   n.height = Math.max(height(n.left), height(n.right)) + 1;
   return n;
   }
   private int height(AvlNode<E> n){
      if (n == null) return -1;
      return n.height;
   }
   private boolean isLeaf(AvlNode<E> n){
      if (n == null || n.left != null || n.right != null) return false;
      return true;
   }
   private AvlNode<E> rotateLeftChild(AvlNode<E> n1){
      AvlNode<E> n2 = n1.left;
      n1.left = n2.right;
      n2.right = n1;
      n1.height = Math.max(n1.left.height, n1.right.height)+1;
      n2.height = Math.max(n2.left.height, n2.right.height)+1;
      return n2;
  }
   private AvlNode<E> rotateRightChild(AvlNode<E> n1){
      AvlNode<E> n2 = n1.right;
      n1.right = n2.left;
      n2.left = n1;
      return n2;
  }
   private AvlNode<E> doubleLeftChild(AvlNode<E> n1){
      n1.left = rotateRightChild(n1.left);
      return rotateLeftChild(n1);
   }
   private AvlNode<E> doubleRightChild(AvlNode<E> n1){
      n1.right = rotateLeftChild(n1.right);
      return rotateRightChild(n1);
   }

   public void add(E e){
      root = add(e, root);
   }
   private AvlNode<E> add(E e, AvlNode<E> n){
      if (n == null){
         size++;
         return  new AvlNode <E>(e);
      }
      int compare = e.compareTo(n.getE());
      if (compare < 0){
	 n.left = add(e, n.left);
      }
      else if (compare > 0){
	 n.right = add(e, n.right);
      }
     n = balance(n); 
     return n;
   }
   public AvlNode<E> getRoot(){
      return root;
   }
   public int size(){
      return size;
   }
   public void print(){
         System.out.println("Total: " + size);
         System.out.println("pre Order: ");
	 preOrder(root);
         System.out.println();
   }
   public void preOrder(AvlNode<E> n){
         if (n == null) return;
         System.out.print(n.getE() + ", ");
         preOrder(n.left);
         preOrder(n.right);
   }
   public void printIT(){
      System.out.println("Total: " + size);
      System.out.println("Iterator: ");

      Iterator<E> it = iterator();
      while (it.hasNext()){
         System.out.print(it.next() + ", ");
      }

      System.out.println();
   }
   public Iterator<E> iterator(){
      return new TreeIterator<E>(this);
   }
}

   public static void main(String argc[]){
      AvlTree<Integer> tr = new AvlTree<Integer>();
      tr.add(1);
      tr.add(2);
      tr.print(); //1, 2,
     tr.add(3);
     tr.print(); //2, 1, 3,
     tr.add(4);
     tr.print(); //2, 1, 3, 4, 
      tr.add(5);
     tr.add(5);
     tr.print(); //2, 1, 4, 3, 5,
     tr.add(0);
     tr.print(); //2, 1, 0, 4, 3, 5,
     tr.printIT(); //0, 1, 2, 3, 4, 5,
      
      
   }
}
   
    

