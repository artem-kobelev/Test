/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turnstilesystem;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Artem_Kobeliev
 */
public abstract class ICard {
    
    private ICheck ch;
    private int id;
    private CardType type;
    private Date beginDate;
    private int countOfDays;
    private Date endDate;
    private int countOfTrips;
    
    
    public ICard(ICheck ch, int id, CardType type, Date beginDate,
            int countOfDays, int countOfTrips){
        this.ch = ch;
        this.id = id;
        this.type = type;
        this.beginDate = beginDate;
        this.countOfDays = countOfDays;
        this.countOfTrips = countOfTrips;
    }
    
    public void setCheck(ICheck check){
        this.ch = check;
    }
    
    public ICheck getCheck(){
        return ch;
    }
    
    public int getId(){
        return id;
    }
    
    public CardType getCardType(){
        return type;
    }
    
    public Date getEndDate(){
        if (endDate == null){
            endDate = countEndDate();
        }
        return endDate;
    }
    
    public int getCountOfTrips(){
        return countOfTrips; 
    }
    
    private Date countEndDate(){
        if (beginDate == null) {
            return null;
        }
        Calendar c = Calendar.getInstance();
        c.setTime(beginDate);
        c.add(Calendar.DAY_OF_YEAR, 10);
        endDate = c.getTime();
        return endDate;
    }
    
    public void reduceCountOfTrips(){
        countOfTrips--;
    }
    /*
    * checked if user can pass
    */
    public boolean check(){
        if (ch != null) {
            return ch.check(this);
        }
        return false;
    };
    
    @Override
    public int hashCode(){
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ICard other = (ICard) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
}
