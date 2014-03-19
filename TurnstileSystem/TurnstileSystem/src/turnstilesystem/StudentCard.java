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

abstract class A{};


class B extends A{};

public class StudentCard extends ICard{
    
    public StudentCard(ICheck ch, int id, Date beginDate, 
            int countOfDays, int countOfTrips){
        super(ch, id, CardType.STUDENT, beginDate, countOfDays, 
                countOfTrips);
    }
    
}
