/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package threads.task5.bank;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class ThreadsTask5Bank {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Bank bank = new Bank();
        Random rand = new Random();
        int n = 300;
        long sum = 0;
        //create accounts
        for (int i = 0; i < n; i++){
            Account acc = new Account();
            int amount = 1000 + rand.nextInt(10000);
            sum += amount;
            acc.deposit(amount);
            bank.addClient(acc);
        }
        //create threads
        int k = 2000;
        Thread[] ths = new Thread[k];
        for (int i = 0; i < k; i++ ){
            ths[i] = new Thread(new TransferMoney(bank));
            ths[i].start();
        }
        
        for (int i = 0; i < k; i++){
            try {
                ths[i].join();
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadsTask5Bank.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        long newSum = 0;
        //count new sum
        for (int i = 0; i < n; i++){
            newSum += ((Account)(bank.getClients().get(i))).getAmount();
        }
        
        System.out.println(sum);
        System.out.println(newSum);
        System.out.println(sum - newSum);
    }
    
}
