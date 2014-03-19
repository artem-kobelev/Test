/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turnstilesystem;

/**
 *
 * @author Artem_Kobeliev
 */
public class Turnstile {
    
    /*
     * check if passager can pass through turnstile
     */
    public boolean checkCard(ICard card){
        boolean res = false;
        if (card != null){
            res = card.check();
        }
        System.getInstance().addToAccounting(card.getId(), res, card.getCardType());
        return res;
    }
    
    
}
