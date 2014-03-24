/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package task1;

/**
 *
 * @author Artem_Kobeliev
 */
public class MyRunnableThread implements Runnable{
    private double sequence[];
    private double[] res;
    int begin;
    int end;
    double sum = 0;
    private static int k = 0;
    private int threadNumber;
    
    public MyRunnableThread(double sequence[], int begin, int end, double[] res){
        this.sequence = sequence;
        this.begin = begin;
        this.end = end;
        this.res = res;
        threadNumber = k++;
    }
    
    @Override
    public void run() {
        for(int i = begin; i < end; i++){
            sum += sequence[i];
        }
        res[threadNumber] = sum;
    }
}
