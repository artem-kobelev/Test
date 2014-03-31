/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package threads.task2.mergesort;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Artem_Kobeliev
 */
public class ThreadsTask2MergeSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int a[] = {6, 5, 3, 4, 7, 8, 2, 1};
        List<Future> future = new ArrayList<>();
        ExecutorService pool = Executors.newCachedThreadPool();
        
        MyRecursiveAction task = new MyRecursiveAction(a, 0, a.length - 1, pool);
        Thread th = new Thread(task);
        future.add(pool.submit(task));
        for (Future f : future){
            try {
                f.get();
            } catch (    InterruptedException | ExecutionException ex) {
                Logger.getLogger(ThreadsTask2MergeSort.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        pool.shutdown();
        
        for (int i = 0; i < a.length; i++){
            System.out.print(a[i]);
        }
        System.out.println();
    }
}
