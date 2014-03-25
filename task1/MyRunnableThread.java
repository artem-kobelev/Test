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
    private IFunc func;
    private double[] res;
    int begin;
    int end;
    double sum = 0;
    private static int k = 0;
    private final int threadNumber;
    
    public MyRunnableThread(IFunc func, int begin, int end, double[] res){
        this.func = func;
        this.begin = begin;
        this.end = end;
        this.res = res;
        threadNumber = k++;
    }
    
    @Override
    public void run() {
        for(int i = begin; i < end; i++){
            sum += (Double)func.calculate(i);
        }
        res[threadNumber] = sum;
    }
}
