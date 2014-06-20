/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ua.epam.study.internetshop.domain.bucket;

/**
 *
 * @author Artem_Kobeliev
 */
public class Bucket {
    
    Integer bucketID;
    Integer bucketClientID;
    Integer bucketGoodsID;
    
    public Bucket(){}
    
    public Bucket(int clientID, int goodsID){
        this.bucketClientID = clientID;
        this.bucketGoodsID = goodsID;
    }
    
    public int getBucketID(){
        return this.bucketID;
    }
    
    public void setBucketID(int id){
        this.bucketID = id;
    }
    
    public int getBucketClientID(){
        return this.bucketClientID;
    }
    
    public void setBucketClientID(int clientID){
        this.bucketClientID = clientID;
    }
    
    public int getBucketGoodsID(){
        return this.bucketGoodsID;
    }
    
    public void setBucketGoodsID(int goodsID){
        this.bucketGoodsID = goodsID;
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + (this.bucketClientID != null ? this.bucketClientID.hashCode() : 0);
        hash = 13 * hash + (this.bucketGoodsID != null ? this.bucketGoodsID.hashCode() : 0);
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
        final Bucket other = (Bucket) obj;
        if ((this.bucketClientID == null) ? (other.bucketClientID != null) : 
                !this.bucketClientID.equals(other.bucketClientID)) {
            return false;
        }
        if (this.bucketGoodsID != other.bucketGoodsID && (this.bucketGoodsID == null || 
                !this.bucketGoodsID.equals(other.bucketGoodsID))) {
            return false;
        }
        return true;
    }    
    
    @Override
    public String toString() {
        return "Bucket{" + "bucketID=" + bucketID + ", bucketClientID=" + bucketClientID 
                + ", bucketGoodsID=" + bucketGoodsID + '}'+"\n";
    }   
    
}
