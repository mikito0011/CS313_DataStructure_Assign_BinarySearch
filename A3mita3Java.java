/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a3mita3.java;
import java.util.*;

/**
 *
 * @author mikito
 */
public class A3mita3Java {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        java.util.ArrayDeque<Integer> dque = new java.util.ArrayDeque<Integer>(10); 
        dque.add(1);
        dque.add(0);
        dque.add(3);
        dque.add(2);
        dque.add(5);
        dque.add(5);
        dque.add(2);
        System.out.println(dque);
        
        TreeSet<Integer> ts = new TreeSet<Integer>(dque);
        System.out.println(ts);
        
        
    }
    
}
