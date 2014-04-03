/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package generics.task2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Artem_Kobeliev
 */
public class GenericsTask2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new GenericsTask2().test();
    }
    
    public <T> void copyAll(Collection<? extends T> in, Collection<? super T> out){
        if (out == null){
            return;
        }
        if (in != null){
            out.addAll(in);
        }
    }
    
    public void printCollection(Collection<Apple> c){
        for (Apple elem : c){
            System.out.print(elem.getWeight() + " ");
        }
        System.out.println();
    }
    
    public <T extends Comparable> Collection<T> returnAllBiggerThen(Collection<T> c, T elem){
        
        Collection<T> newC = null;
        try {
            newC = c.getClass().newInstance();
            for (T t : c){
            if (t.compareTo(elem) > 0){
                newC.add(t);
            }
        }
        } catch (InstantiationException ex) {
            Logger.getLogger(GenericsTask2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(GenericsTask2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return newC;
    }
    
    public void test(){
        
        Apple a1 = new Apple();
        a1.setWeight(1);
        Apple a2 = new Apple();
        a2.setWeight(2);
        Apple a3 = new Apple();
        a3.setWeight(3);
        Apple a4 = new Apple();
        a3.setWeight(101);
        List<Apple> app = new ArrayList<Apple>();
        
        app.add(a1);
        app.add(a2);
        app.add(a3);
        
        RedApple ra1 = new RedApple();
        ra1.setWeight(11);
        RedApple ra2 = new RedApple();
        ra2.setWeight(12);
        RedApple ra3 = new RedApple();
        ra3.setWeight(13);
        List<Apple> rapp = new ArrayList<Apple>();
        
        rapp.add(ra1);
        rapp.add(ra2);
        rapp.add(ra3);
        
        
        Collection app2 = returnAllBiggerThen(rapp, a2);
        printCollection(app2);
        
    }
}
