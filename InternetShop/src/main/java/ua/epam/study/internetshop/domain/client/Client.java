/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ua.epam.study.internetshop.domain.client;

/**
 *
 * @author Artem_Kobeliev
 */
public class Client {
    
    Integer clientID;
    String clientName;
    Integer clientDiscount;
    
    public Client(){}
    
    public Client(String name, int disc){
        this.clientName = name;
        this.clientDiscount = disc;
    }
    
    public int getClientID(){
        return this.clientID;
    }
    
    public void setClientID(int id){
        this.clientID = id;
    }
    
    public String getClientName(){
        return this.clientName;
    }
    
    public void setClientName(String name){
        this.clientName = name;
    }
    
    public int getClientDiscount(){
        return this.clientDiscount;
    }
    
    public void setClientDiscount(int disc){
        this.clientDiscount = disc;
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + (this.clientName != null ? this.clientName.hashCode() : 0);
        hash = 13 * hash + (this.clientDiscount != null ? this.clientDiscount.hashCode() : 0);
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
        final Client other = (Client) obj;
        if ((this.clientName == null) ? (other.clientName != null) : !this.clientName.equals(other.clientName)) {
            return false;
        }
        if (this.clientDiscount != other.clientDiscount && (this.clientDiscount == null || 
                !this.clientDiscount.equals(other.clientDiscount))) {
            return false;
        }
        return true;
    }    
    
    @Override
    public String toString() {
        return "Client{" + "clientID=" + clientID + ", clientName=" + clientName 
                + ", clientDiscount=" + clientDiscount + '}'+"\n";
    }  
}
