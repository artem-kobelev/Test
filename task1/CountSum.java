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
     volatile double[] sequence;
     int step;
     int n;
     int k;
     
     CountSum(double[] sequence){
         this.sequence = sequence;
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
        List<Future<Double>> res = new ArrayList();
        ExecutorService es = Executors.newCachedThreadPool();
        for (int i = 0; i < k; i++){
            res.add(es.submit(new MyThread(sequence, Math.min(step * i, sequence.length), 
                    Math.min(step * (i + 1), sequence.length))));
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
        
        return sum;
     }
    
     private double withoutExecutorService(double[] res){
        double sum = 0;
        List<Thread> threads = new ArrayList();
        
        for (int i = 0; i < k; i++){
            threads.add(new Thread(new MyRunnableThread(sequence, Math.min(step * i, sequence.length), 
                    Math.min(step * (i + 1), sequence.length), res)));
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