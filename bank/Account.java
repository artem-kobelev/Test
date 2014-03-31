/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package threads.task5.bank;

/**
 *
 * @author Admin
 */
public class Account {
    
    private static int count = 0;
    private int totalAmount;
    private final int id;
    
    
    public Account(){
        id = count++;
        totalAmount = 0;
    }
    
    public synchronized  int getId(){
        return id;
    }
    
    public synchronized int getAmount(){
        return totalAmount;
    }
    
    public synchronized boolean withdraw(int amount){
        if (totalAmount - amount >= 0){
            totalAmount -= amount;
            return true;
        }
        return false;
    }
    
    public synchronized boolean deposit(int amount){
        if (totalAmount + amount >= 0){
            totalAmount += amount;
            return true;
        }
        return false;
    }
}
