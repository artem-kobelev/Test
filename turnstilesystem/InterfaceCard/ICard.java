/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turnstilesystem.InterfaceCard;

import java.util.Date;
import turnstilesystem.Enums.CardType;

/**
 *
 * @author Artem_Kobeliev
 */
public interface ICard {
    
    public boolean check();
    
    public int getId();
    
    public CardType getCardType();
    
    public Date getEndDate();
    
    public int getCountOfTrips();
    
    public void reduceCountOfTrips();
    
}
