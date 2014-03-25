/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package task1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Artem_Kobeliev
 */
public class CountSum {
     private IFunc func;
     private int step;
     private int n;
     private int k;
     
     CountSum(IFunc funk){
         this.func = funk;
     }
     
     public double countWithExecutorService(int n, int k) {
        this.n = n;
        this.k = k;
        step = (2 * n + 1) / k + 1;
        
        return withExecutorService();
     }
     
     public double countWithoutExecutorService(int n, int k, double[] res) {
        this.n = n;
        this.k = k;
        step = (2 * n + 1) / k + 1;
        
        return withoutExecutorService(res);
     }
    
     private double withExecutorService(){
        double sum = 0;
        List<Future<Double>> res = new ArrayList<Future<Double>>();
        ExecutorService es = Executors.newCachedThreadPool();
        for (int i = 0; i < k; i++){
            res.add(es.submit(new MyThread(func, Math.min(-n + step * i, n), 
                    Math.min(-n + step * (i + 1), n))));
        }
        
        for (int i = 0; i < k; i++){
            try {
                sum += res.get(i).get();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            } catch (ExecutionException ex) {
                ex.printStackTrace();
            }
        }
        es.shutdown();
        return sum;
     }
     
     private double withoutExecutorService(double[] res){
        double sum = 0;
        List<Thread> threads = new ArrayList<Thread>();
        
        for (int i = 0; i < k; i++){
            threads.add(new Thread(new MyRunnableThread(func, Math.min(-n + step * i, n), 
                    Math.min(-n + step * (i + 1), n), res)));
            threads.get(i).start();
        }
        
        for (int i = 0; i < k; i++){
            try {
                threads.get(i).join();
                sum += res[i];
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        return sum;
    }
}