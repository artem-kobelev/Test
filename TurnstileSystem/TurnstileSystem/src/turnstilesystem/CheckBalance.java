/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turnstilesystem;

import java.util.Calendar;

/**
 *
 * @author Artem_Kobeliev
 */
public class CheckBalance implements ICheck{
    
    @Override
    public boolean check(ICard card) {
        double cost = System.getInstance().getCost();
        try{
            card = (UsualCard)card;
        }
        catch(ClassCastException ex){
            return false;
        }
        if (((UsualCard)card).reduseBalance(cost)){
            return true;
        }
        return false;
    }
    
}
