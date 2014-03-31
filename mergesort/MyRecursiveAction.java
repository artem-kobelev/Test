/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package threads.task2.mergesort;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Artem_Kobeliev
 */
public class MyRecursiveAction implements Runnable{
    
    private final int[] a;
    private final int l;
    private final int r;
    private final ExecutorService pool;
    
    
    public MyRecursiveAction(int[] a, int l, int r, ExecutorService pool){
        this.a = a;
        this.l = l;
        this.r = r;
        this.pool = pool;
    }
    
    @Override
    public void run() throws RejectedExecutionException{
        sort(a, l, r);
    }
    
    private void sort(int[] a, int l, int r) throws RejectedExecutionException{
        if ( l>=r ) {
        return;
        } 

        int m = (l+r)/2; 
        MyRecursiveAction task = new MyRecursiveAction(a, l, m, pool);
        Thread th = new Thread(task);
        Future f = pool.submit(th);
        sort (a, m+1, r);
        try {
            f.get();
        }
        catch (    InterruptedException | ExecutionException ex) {
            Logger.getLogger(MyRecursiveAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        merge (a, l, m, r);
    }
    
    private void merge (int[] a, int l, int m, int r) { 
          //base case: second sublist is empty 
          if (m+1>r) {
            return;
          } 
          
          int[] b = new int[a.length]; 
          System.arraycopy(a, l, b, l, m+1 - l); 
          //copy a[m+1..r] to b[m+1..r] in reverse order 
          for (int i=m+1; i<r+1; i++) { 
               b[i] = a[r+m+1-i]; 
          }
          //merge b[l..m] with b[m+1..r] to a[l..r] 
          int k=l; int j=r; //pointer wandering from outside inward 
          for (int i=l; i<r+1; i++) { 
               if (b[k] <= b[j]) {
                  a[i] = b[k++];
              } else {
                  a[i] = b[j--];
              } 
          } 
     }
}
