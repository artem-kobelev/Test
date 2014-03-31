/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package threads.task2.MergeSort;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Artem_Kobeliev
 */
public class MultithreadedMergeSort {
    
    public void sort(int[] a){
        List<Future> future = new ArrayList<>();
        ExecutorService pool = Executors.newCachedThreadPool();
         
         MyRecursiveAction task = new MyRecursiveAction(a, 0, a.length - 1, pool);
         Thread th = new Thread(task);
         future.add(pool.submit(task));
         for (Future f : future){
             try {
                 f.get();
             } catch (    InterruptedException | ExecutionException ex) {
                 Logger.getLogger(Threads2.class.getName()).log(Level.SEVERE, null, ex);
             }
         }
         pool.shutdown();
    }
     
}
