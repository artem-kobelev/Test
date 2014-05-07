/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turnstilesystem.MyCollections;

import turnstilesystem.Enums.CardType;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author Artem_Kobeliev
 */
public class MyArrayList {
    
    ArrayList<Accounting> acc;
    /*
     * count of accept cases divided on types of cadrs
     */
    HashMap<CardType, Integer> posStat;
    /*
     * count of decline cases divided on types of cadrs
     */
    HashMap<CardType, Integer> negStat;
    /*
     * count of general accept cases
     */
    int posGenStat = 0;
    /*
     * count of general decline cases
     */
    int negGenStat = 0;
    
    public MyArrayList(){
        acc = new ArrayList();
        posStat = new HashMap();
        negStat = new HashMap();
    }
    
    class Accounting{
        private int cardId;
        private boolean accept;
        private CardType type;
        private Date date;
        
        
        public Accounting(int cardId, boolean accept, CardType type){
            this.cardId = cardId;
            this.accept = accept;
            this.type = type;
            this.date = Calendar.getInstance().getTime();
        }
        
        public int getCardId(){
            return cardId;
        }
        
        public boolean isAccept(){
            return accept;
        }
        
        public Date getDate(){
            return date;
        }
    }
    
    
    public boolean add(Integer cardId, boolean accept, CardType type){
        if (accept){
            posGenStat++;
            posStat.put(type, posStat.get(type) + 1);
        }
        else{
            negGenStat++;
            negStat.put(type, negStat.get(type) + 1);
        }
        return acc.add(new Accounting(cardId, accept, type));
    }
    
    public int indexOf(Object o){
        return acc.indexOf(o);
    }
    
    public Accounting get(int index){
        return acc.get(index);
    }
    
    public Accounting remove(int index){
        return acc.remove(index);
    }
    
    public boolean remove(Object o){
        return acc.remove(o);
    }
    /*
     * returns summary data
     */
    public String getSummaryData(){
        return "count of accepted cases is " + posGenStat + "\n" +
                "count of declined cases is " + negGenStat;
    }
    /*
     * returns data devided on types of card
     */
    public String getDataByTypesOfCards(){
        String s = "";
        for(CardType ct: CardType.values()){
            s += "count of accepted cases of " + ct + " card is " + posStat.get(ct) + "\n";
            s += "count of declined cases of " + ct + " card is " + negStat.get(ct) + "\n";
        }
        
        return s;
    }
}
