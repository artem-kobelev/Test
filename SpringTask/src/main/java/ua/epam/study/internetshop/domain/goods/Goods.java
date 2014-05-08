/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.epam.study.internetshop.domain.goods;

/**
 *
 * @author Artem_Kobeliev
 */
public class Goods {
    
    Integer goodsID;
    String goodsName;
    Integer goodsPrice;
    
    public Goods(){
    }
    
    public Goods(String name, int price){
        this.goodsName = name;
        this.goodsPrice = price;
    }
    
    public int getGoodsID(){
        return this.goodsID;
    }
    
    public void setGoodsID(int id){
        this.goodsID = id;
    }
    
    public String getGoodsName(){
        return this.goodsName;
    }
    
    public void setGoodsName(String name){
        this.goodsName = name;
    }
    
    public int getGoodsPrice(){
        return this.goodsPrice;
    }
    
    public void setGoodsPrice(int price){
        this.goodsPrice = price;
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + (this.goodsName != null ? this.goodsName.hashCode() : 0);
        hash = 13 * hash + (this.goodsPrice != null ? this.goodsPrice.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Goods other = (Goods) obj;
        if ((this.goodsName == null) ? (other.goodsName != null) : !this.goodsName.equals(other.goodsName)) {
            return false;
        }
        if (this.goodsPrice != other.goodsPrice && (this.goodsPrice == null || !this.goodsPrice.equals(other.goodsPrice))) {
            return false;
        }
        return true;
    }    
    
    @Override
    public String toString() {
        return "Goods{" + "goodsID=" + goodsID + ", goodsName=" + goodsName + ", goodsYear=" + goodsPrice + '}'+"\n";
    }   
    
}
