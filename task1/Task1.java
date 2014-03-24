/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package task1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.midi.Sequence;

/**
 *
 * @author Artem_Kobeliev
 */

public class Task1 {
    
     static double[] sequence;
     static volatile double[] res;
     static double sum = 0;
     static int k;
     static int n;
     
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner(System.in);
        System.out.println("Enter n number");
        n = in.nextInt();
        sequence = new double[2 * n + 1];
        for (int i = 0; i < sequence.length; i++){
            sequence[i] = Math.sin(i - n);
        }
        
        System.out.println("Enter count of threads");
        k = in.nextInt();
        
        res = new double[k];
        CountSum cs = new CountSum(sequence);
        
        long begTime = Calendar.getInstance().getTimeInMillis();
        sum = cs.countWithExecutorService(n, k);
        long endTime = Calendar.getInstance().getTimeInMillis();
        System.out.println("Result with ExecutorService is " + sum);
        System.out.println("Time is " + (endTime - begTime) );
        
        begTime = Calendar.getInstance().getTimeInMillis();
        sum = cs.countWithoutExecutorService(n, k, res);
        endTime = Calendar.getInstance().getTimeInMillis();
        System.out.println("Result without ExecutorService is " + sum);
        System.out.println("Time is " + (endTime - begTime) );
        /*
         * with N=2000000 optimal count of threads is 8-12
         */
        System.exit(0);
    }
    
}