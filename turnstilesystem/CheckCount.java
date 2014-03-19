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
public class CheckCount implements ICheck{
    
    @Override
    public boolean check(ICard card) {
        card.reduceCountOfTrips();
        if (card.getCountOfTrips() >= 0){
            return true;
        }
        return false;
    }
    
}
