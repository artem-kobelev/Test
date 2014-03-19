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
public class CheckDays implements ICheck{
    
    @Override
    public boolean check(ICard card) {
        if (Calendar.getInstance().getTime().before(card.getEndDate())){
            return true;
        }
        return false;
    }
    
}
