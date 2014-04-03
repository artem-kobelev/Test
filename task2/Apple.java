/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package generics.task2;

/**
 *
 * @author Artem_Kobeliev
 */
public class Apple<E extends Apple<E>> extends Fruit implements Comparable<E> {
    
    protected int weight;
    
    @Override
    public int compareTo(E o) {
        if (this.weight > o.weight) {
            return 1;
        }
        if (this.weight < o.weight){
            return -1;
        }
        return 0;
    }
    
    public void setWeight(int weight){
        this.weight = weight;
    }
    
    public int getWeight(){
        return weight;
    }
}
