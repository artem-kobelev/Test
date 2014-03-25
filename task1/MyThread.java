/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package task1;

import java.util.concurrent.*;

/**
 *
 * @author Artem_Kobeliev
 */
public class MyThread implements Callable<Double> {
    
    private IFunc func;
    int begin;
    int end;
    double sum = 0;
    
    public MyThread(IFunc func, int begin, int end){
        this.func = func;
        this.begin = begin;
        this.end = end;
    }
    
    @Override
    public Double call() {
        for(int i = begin; i < end; i++){
            sum += (Double)func.calculate(i);
        }
        return sum;            
    }
    
}
