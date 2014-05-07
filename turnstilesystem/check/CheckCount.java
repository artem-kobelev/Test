/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turnstilesystem.check;

import turnstilesystem.check.ICheck;
import java.util.Calendar;
import turnstilesystem.Enums.CardType;
import turnstilesystem.InterfaceCard.ICard;
import turnstilesystem.UsualCard.*;
import turnstilesystem.StudentCard.*;
import turnstilesystem.SchoolCard.*;

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
