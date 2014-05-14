/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package threads.task3.withsynch;

/**
 *
 * @author Artem_Kobeliev
 */
public class CircularBuffer {

    String[] array;
    int size = 0;
    int start = 0;
    int count = 0;
    
    
    public CircularBuffer(int n){
        this.size = n;
        array = new String[n];
    }
    
    public synchronized void put(String s){
            while(count >= size){
                try{
                    wait();
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
            notifyAll();
    }
    
    public synchronized String get(){
            while(count <= 0){
                try{
                    wait();
                }
                catch(InterruptedException ex){
                    System.out.println(ex.getMessage());
                }
            }
            if (count <= 0){
                return null;
            }
            String s = array[start];
            start = (start + 1) % size;
            count--;
            
            notifyAll();
            return s;
    }
    
}
