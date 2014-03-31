/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package threads.task5.bank;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class Bank {
    
    List<Account> accs = new ArrayList<>();
    
    
    public void addClient(Account acc){
        accs.add(acc);
    }
    
    public List<?> getClients(){
        return accs;
    }
    
    public void transfer(Account from, Account to, int amount){
        if (from.getId() > to.getId()){
            amount = -amount;
            Account acc = from;
            from = to;
            to = acc;
        }
        synchronized(from){
            if ( ((from.getAmount() - amount) >= 0) && (to.getAmount() + amount >= 0) )
            {
                synchronized(to){
                    from.withdraw(amount);
                    to.deposit(amount);
                }
            }
        }
    }
    
}
