/*
 + * To change this template, choose Tools | Templates
 + * and open the template in the editor.
 + */
 package threads.task2.MergeSort;
 
 /**
 + *
 + * @author Artem_Kobeliev
 + */
 public class Threads2 {
 
     /**
 +     * @param args the command line arguments
 +     */
     public static void main(String[] args) {
         // TODO code application logic here
         int a[] = {6, 5, 3, 4, 7, 8, 2, 1};
         new MultithreadedMergeSort().sort(a);
         
         for (int i = 0; i < a.length; i++){
             System.out.print(a[i]);
         }
         System.out.println();
     }
 }