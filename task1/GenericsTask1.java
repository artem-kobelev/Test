/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package generics.task1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author Artem_Kobeliev
 */
public class GenericsTask1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        GenericsTask1 gt = new GenericsTask1();
        Integer[] a = {1, 2, 3};
        List<Integer> c = new ArrayList<Integer>();
        gt.fromArrayToCollection(a, c);
        for (Integer i : c){
            System.out.print(i + " ");
        }
    }
    
    /**
     *
     * @param <T>
     * @param a
     * @param c
     */
    public <T> void fromArrayToCollection(T[] a, Collection<? super T> c){
        c.addAll(Arrays.asList(a));
    }
    
    
}
