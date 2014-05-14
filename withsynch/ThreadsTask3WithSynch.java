/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package threads.task3.withsynch;

/**
 *
 * @author Artem_Kobeliev
 */
public class ThreadsTask3WithSynch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        CircularBuffer cb = new CircularBuffer(10);
        for (int i = 0; i < 5; i++){
            new Thread(new Producer(cb)).start();
        }
        for (int j = 0; j < 9; j++){
            new Thread(new Consumer(cb)).start();
        }
    }
    
}
