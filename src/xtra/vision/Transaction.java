/*
 * This class is an abstract class for both types of rent and return transactions
 */
package xtra.vision;

import java.util.Date;

/**
 *
 */
public abstract class Transaction {
     /*
 * Member Variables of class
 */   
    private String emailID;
    private Date transactionDate;   
    
    public String getEmailID() {
        return this.emailID;
    }
    
    public void setEmailID(String email){
        this.emailID = email;
    }
    
    public Date getTransDate() {
        return this.transactionDate;
    }
    
    public void setTransDate(Date date){
        this.transactionDate = date;
    }



    
}
