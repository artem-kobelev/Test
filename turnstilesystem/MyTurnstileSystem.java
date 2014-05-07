/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turnstilesystem;

import turnstilesystem.InterfaceCard.ICard;
import turnstilesystem.MyCollections.MyArrayList;
import turnstilesystem.MyExceptions.CannotCreateClassException;
import turnstilesystem.Enums.CardType;
import turnstilesystem.Enums.PaymentType;
import turnstilesystem.UsualCard.UsualCard;
import turnstilesystem.SchoolCard.SchoolCard;
import turnstilesystem.StudentCard.StudentCard;
import turnstilesystem.check.CheckBalance;
import turnstilesystem.check.CheckCount;
import turnstilesystem.check.CheckDays;
import turnstilesystem.check.ICheck;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

/**
 *
 * @author Artem_Kobeliev
 */
public class MyTurnstileSystem {
    
    //private static MyTurnstileSystem system;
    public static final MyTurnstileSystem instance = new MyTurnstileSystem();
    private double cost;
    private HashMap<PaymentType, ICheck> checks = new HashMap();
    private ArrayList<ICard> cards;
    private MyArrayList accounting;
    int id = 0;
    
    
    public MyTurnstileSystem(){
        cards = new ArrayList();
        accounting = new MyArrayList();
        checks.put(PaymentType.COUNTS, new CheckCount());
        checks.put(PaymentType.DAYS, new CheckDays());
        checks.put(PaymentType.MONEY, new CheckBalance());
    }
    
    public ArrayList<?> getArrayOfCards(){
        return cards;
    }
    
    public void addToAccounting(int cardId, boolean accept, CardType type){
        accounting.add(cardId, accept, type);
    }
    
    public String getSummaryData(){
        return accounting.getSummaryData();
    }
    
    public String getDataByTypesOfCards(){
        return accounting.getDataByTypesOfCards();
    }
    
    public double getCost(){
        return cost;
    }
    
    public void setCost(double cost){
        this.cost = cost;
    }
    
    private ICard produceCard(CardType typeOfCard, PaymentType typeOfPayment , int balance){
        if ((typeOfPayment == PaymentType.MONEY) && (typeOfCard != CardType.USUAL)){
            return null;
        }
        ICard card = null;
        ICheck check = checks.get(typeOfPayment);
        try{
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
        }
        catch(CannotCreateClassException ex){
            System.err.print(ex);
        }
        
        if (card != null){
            cards.add(card);
        }
        
        return card;
    }
    
    public ICard produceCardOn10Days(CardType typeOfCard){
        return produceCard(typeOfCard, PaymentType.DAYS, 10);
    }
    
    public ICard produceCardOn30Days(CardType typeOfCard){
        return produceCard(typeOfCard, PaymentType.DAYS, 10);
    }
    
    public ICard produceCardOn5Trips(CardType typeOfCard){
        return produceCard(typeOfCard, PaymentType.COUNTS, 5);
    }
    
    public ICard produceCardOn10Trips(CardType typeOfCard){
        return produceCard(typeOfCard, PaymentType.COUNTS, 10);
    }
    
    public ICard produceAccumulativeCard(CardType typeOfCard){
        return produceCard(typeOfCard, PaymentType.MONEY, 0);
    }
    
    public ICard produceAccumulativeCard(CardType typeOfCard, int balance){
        return produceCard(typeOfCard, PaymentType.MONEY, balance);
    }
    
}
