/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turnstilesystem.check;

import turnstilesystem.check.ICheck;
import java.util.Calendar;
import turnstilesystem.InterfaceCard.ICard;
import turnstilesystem.MyTurnstileSystem;
import turnstilesystem.UsualCard.UsualCard;

/**
 *
 * @author Artem_Kobeliev
 */
public class CheckBalance implements ICheck {

    @Override
    public boolean check(ICard card) {
        double cost = MyTurnstileSystem.instance.getCost();
        
        try {
            card = (UsualCard) card;
        } catch (ClassCastException ex) {
            return false;
        }
        if (((UsualCard) card).reduseBalance(cost)) {
            return true;
        }
        return false;
    }

}
