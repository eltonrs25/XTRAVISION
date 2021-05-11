/*
 * This class inherits from Transaction class and consists of varibales for a returning transaction.
 */
package xtra.vision;

import java.util.Date;

/**
 *
 */
public class ReturnTransaction extends Transaction {
         /*
 * Member Variables of class
 */   
    private double fine;
    private int noOfDays;
    private int TagNo;
      /*
 * Constructors of class
 */    
    ReturnTransaction(String email, Date date){
        super.setEmailID(email);
        super.setTransDate(date);
    }
       /*
 * Getters and Setters of class
 */     
    public double getFine() {
        return this.fine;
    }
    
    public void setFine(double amount){
        this.fine = amount;
    }
    
    public int getNoOfDays() {
        return this.noOfDays;
    }
    
    public void setNoOfDays(int count){
        this.noOfDays = count;
    }

    public int getTagNo() {
        return this.TagNo;
    }
    
    public void setTagNo(int num){
        this.TagNo = num;
    }
    
}
