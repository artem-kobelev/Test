/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package threads.task3;

/**
 *
 * @author Artem_Kobeliev
 */
public class Consumer implements Runnable{
    
    private CircularBuffer cb;
    
    
    public Consumer(CircularBuffer cb){
        this.cb = cb;
    }

    @Override
    public void run() {
        while(true){
            String s = cb.get();
            System.out.println(s);
        }
    }
        
}
