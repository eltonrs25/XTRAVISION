/*
 * This class inherits from Transaction class and consists of varibales for a renting transaction.
 */
package xtra.vision;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 */
public class RentTransaction extends Transaction {
     /*
 * Member Variables of class
 */   
    private double rentAmount;
    private int noOfMovies;
    private String Movies;
    private String cardNumber;
    private ArrayList<Integer> tags; 
     /*
 * Constructors of class
 */    
    RentTransaction(String email, Date date){
        super.setEmailID(email);
        super.setTransDate(date);
        rentAmount = 0.0;
        noOfMovies = 0;
        tags = new ArrayList<>();
        for(int i =0;i<4;i++){
            tags.add(0);
        }
    }
     /*
 * Getters and Setters of class
 */    
    public String getCardNumber() {
        return this.cardNumber;
    }
    
    public void setCardNumber(String number){
        this.cardNumber = number;
    }
    
    public double getRentAmount() {
        return this.rentAmount;
    }
    
    public void setRentAmount(double amount){
        this.rentAmount = amount;
    }
    
    public int getNoOfMovies() {
        return this.noOfMovies;
    }
    
    public void setNoOfMovies(int count){
        this.noOfMovies = count;
    }

    public String getMovies() {
        return this.Movies;
    }
    
    public void setMovies(String movies){
        this.Movies = movies;
    }    
  
    public ArrayList getTags(){
        return this.tags;
    }
    
    public void setTags(ArrayList tagNos){
        for(int i =0 ;i<tagNos.size(); i++){
            tags.set(i, (Integer) tagNos.get(i)) ;            
        }
        
    }
}
