/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package threads.task3;

/**
 *
 * @author Artem_Kobeliev
 */
public class Producer implements Runnable{
    
    private CircularBuffer cb;
    Integer i = 0;
    
    public Producer(CircularBuffer cb){
        this.cb = cb;
    }
    
    @Override
    public void run() {
        while(true){
            cb.put(i.toString());
            i++; 
        }
    }
    
}
