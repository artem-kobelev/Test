/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package threads.task3;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Artem_Kobeliev
 */
public class CircularBuffer {
    
    ReentrantLock lock = new ReentrantLock();
    
    String[] array;
    int size = 0;
    int start = 0;
    int count = 0;
    private final Condition full = lock.newCondition();
    private final Condition empty = lock.newCondition();
    
    public CircularBuffer(int n){
        this.size = n;
        array = new String[n];
    }
    
    public void put(String s){
        lock.lock();
        try{
            while(count >= size){
                    try{
                        full.await();
                    }
                    catch(InterruptedException ex){
                        System.out.println(ex.getMessage());
                    }
                }
            int end = (start + count) % size;
            array[end] = s;
            if (count >= size){
                start = (start + 1) % size;
            }
            else{
                count++;
            }
            empty.signalAll();
        }
        finally{
            lock.unlock();
        }
    }
    
    public String get(){
        lock.lock();
        try{
            while(count <= 0){
                try{
                    empty.await();
                }
                catch(InterruptedException ex){
                    System.out.println(ex.getMessage());
                }
            }
            String s = array[start];
            start = (start + 1) % size;
            count--;

            full.signalAll();
            return s;
        }
        finally{
            lock.unlock();
        }
    }
    
}
