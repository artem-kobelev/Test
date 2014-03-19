/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turnstilesystem;

import java.util.Date;

/**
 *
 * @author Artem_Kobeliev
 */
public class UsualCard extends ICard{
    
    private double balance;
    
    
    public UsualCard(ICheck ch, int id, Date beginDate, 
            int countOfDays, int countOfTrips, double balance){
        super(ch, id, CardType.USUAL, beginDate, countOfDays, 
                countOfTrips);
        this.balance = balance;
    }
    
    public double getBalance(){
        return balance;
    }
    /*
     * not prepared
     */
    public void addToBalance(double add, String code){
        this.balance += add;
    }
    
    public boolean reduseBalance(double reduce){
        if (balance - reduce > -Double.MIN_VALUE){
            balance -= reduce;
            return true;
        }
        return false;
    }
    
}
