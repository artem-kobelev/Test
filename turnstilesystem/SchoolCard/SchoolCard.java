/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turnstilesystem.SchoolCard;

import turnstilesystem.MyExceptions.CannotCreateClassException;
import java.util.Calendar;
import turnstilesystem.check.ICheck;
import java.util.Date;
import turnstilesystem.Enums.CardType;
import turnstilesystem.InterfaceCard.ICard;

/**
 *
 * @author Artem_Kobeliev
 */
public class SchoolCard implements ICard{
    
     private ICheck ch;
    private int id;
    private CardType type;
    private Date beginDate;
    private int countOfDays;
    private Date endDate;
    private int countOfTrips;
    
    public SchoolCard(ICheck ch, int id, Date beginDate, 
            int countOfDays, int countOfTrips) throws CannotCreateClassException{
        if (ch == null){
            throw new CannotCreateClassException("Check object can't be null");
        }
        this.ch = ch;
        this.id = id;
        this.type = CardType.SCHOOL;
        this.beginDate = beginDate;
        this.countOfDays = countOfDays;
        this.countOfTrips = countOfTrips;
    }
    
    ///////////////////
    public ICheck getCheck(){
        return ch;
    }
    
     @Override
    public int getId(){
        return id;
    }
    
     @Override
    public CardType getCardType(){
        return type;
    }
    
     @Override
    public Date getEndDate(){
        if (endDate == null){
            endDate = countEndDate();
        }
        return endDate;
    }
    
     @Override
    public int getCountOfTrips(){
        return countOfTrips; 
    }
    
    private Date countEndDate(){
        if (beginDate == null) {
            return null;
        }
        Calendar c = Calendar.getInstance();
        c.setTime(beginDate);
        c.add(Calendar.DAY_OF_YEAR, countOfDays);
        endDate = c.getTime();
        return endDate;
    }
    
     @Override
    public void reduceCountOfTrips(){
        countOfTrips--;
    }
    /*
    * checked if user can pass
    */
    @Override
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
        final SchoolCard other = (SchoolCard) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
}
