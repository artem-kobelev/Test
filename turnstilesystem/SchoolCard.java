/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turnstilesystem;

import java.util.Date;

/**
 *
 * @author Artem_Kobeliev
 */
public class SchoolCard extends ICard{
    
    public SchoolCard(ICheck ch, int id, Date beginDate, 
            int countOfDays, int countOfTrips){
        super(ch, id, CardType.SCHOOL, beginDate, countOfDays, 
                countOfTrips);
    }
    
}
