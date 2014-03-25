/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package task1;

/**
 *
 * @author Admin
 */
public class SinFunc implements IFunc<Double, Integer>{
    
    @Override
    public Double calculate(Integer t) {
        return Math.sin(t);
    }
    
}
