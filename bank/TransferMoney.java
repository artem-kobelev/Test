/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package threads.task5.bank;

import java.util.Random;

/**
 *
 * @author Admin
 */
public class TransferMoney implements Runnable{
    
    Bank bank;
    
    
    public TransferMoney(Bank bank){
        this.bank = bank;
    }
    
    @Override
    public void run() {
        Random rand = new Random();
        int from = rand.nextInt(bank.getClients().size() - 1);
        int to;
        while ((to = rand.nextInt(bank.getClients().size() - 1)) == from){}
        int amount = 100 + rand.nextInt(100);
        bank.transfer((Account)bank.getClients().get(from), (Account)bank.getClients().get(to), amount);
    }
    
}
