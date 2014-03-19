/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turnstilesystem;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

/**
 *
 * @author Artem_Kobeliev
 */
public class System {
    
    private static System system;
    private double cost;
    private HashMap<PaymentType, ICheck> checks = new HashMap();
    private ArrayList<ICard> cards;
    private MyArrayList accounting;
    static int id = 0;
    
    
    private System(){
        cards = new ArrayList();
        accounting = new MyArrayList();
        checks.put(PaymentType.COUNTS, new CheckCount());
        checks.put(PaymentType.DAYS, new CheckDays());
        checks.put(PaymentType.MONEY, new CheckBalance());
    }
    
    static System getInstance(){
        if (system == null){
            system = new System();
        }
        return system;
    }
    
    public ArrayList<?> getArrayOfCards(){
        return cards;
    }
    
    public void addToAccounting(int cardId, boolean accept, CardType type){
        accounting.add(cardId, accept, type);
    }
    
    public double getCost(){
        return cost;
    }
    
    public void setCost(double cost){
        this.cost = cost;
    }
    
    public ICard releaseStudentCard(CardType typeOfCard, PaymentType typeOfPayment , int balance){
        if ((typeOfPayment == PaymentType.MONEY) && (typeOfCard != CardType.USUAL)){
            return null;
        }
        ICard card = null;
        ICheck check = checks.get(typeOfPayment);
        switch (typeOfCard){
            case STUDENT: {
                card = new StudentCard(check, ++id, Calendar.getInstance().getTime(),
                        balance, balance);
                break;
            }
            case SCHOOL: {
                card = new SchoolCard(check, ++id, Calendar.getInstance().getTime(),
                        balance, balance);
                break;
            }
            case USUAL: {
                card = new UsualCard(check, ++id, Calendar.getInstance().getTime(),
                        balance, balance, balance);
                break;
            }
        }
        
        if (card != null){
            cards.add(card);
        }
        
        return card;
    }
    
    
    
}
