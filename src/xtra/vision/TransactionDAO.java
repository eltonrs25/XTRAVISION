/*
 * This class inherits from DAO class and interacts with transactions table in database.
 */
package xtra.vision;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 */
public class TransactionDAO extends DAO{
    /*
 * Constructors of class
 */      
    TransactionDAO() throws SQLException{        
        super.establishConnection();       
    }
  /*
 * This function returns  the transaction if it contains the movie tag in argument.
 */       
    public RentTransaction getTransactionsByTag(int tag){
        RentTransaction trans = null;
        java.util.Date date = null; 
        Integer tags [] = new Integer[4];
        try {
            Statement st; 
            st = super.sqlConnection.createStatement();            
            String sql = "SELECT * FROM transactions";  
            ResultSet rs = st.executeQuery(sql); 
            while(rs.next()){          
            tags [0] = rs.getInt("tag1");
            tags [1] = rs.getInt("tag2");
            tags [2] = rs.getInt("tag3");
            tags [3] = rs.getInt("tag4");
            java.sql.Date sqlDate = rs.getDate("trans_date");             
            for (int a : tags){
                if(a == tag){
                    date = new java.util.Date(sqlDate.getTime());
                    trans = new RentTransaction(rs.getString("email"),date);
                }           
            }
                }
                }catch (SQLException ex) {
                   JOptionPane.showMessageDialog(new JFrame(), ex.getMessage(),"Database Error",
                    JOptionPane.ERROR_MESSAGE);
                }
       

            return trans;
        
    }
  /*
 * This function saves the whole rent transaction.
 */       
    public boolean saveRentTransaction(RentTransaction trans){
        
        String sql = "INSERT INTO transactions(email,trans_date,cardNo,amount,no_of_movies,movies,tag1,tag2,tag3,tag4) VALUES(?,?,?,?,?,?,?,?,?,?)";
               int rs = 0;
               java.sql.Date sqlDate = new java.sql.Date(trans.getTransDate().getTime());
        try {
            PreparedStatement preparedStatement = super.sqlConnection.prepareStatement(sql);
            preparedStatement.setString(1, trans.getEmailID());
            preparedStatement.setDate(2, sqlDate );
            preparedStatement.setString(3, trans.getCardNumber());
            preparedStatement.setDouble(4, trans.getRentAmount());
            preparedStatement.setInt(5, trans.getNoOfMovies());
            preparedStatement.setString(6, trans.getMovies());
            preparedStatement.setInt(7, (int) trans.getTags().get(0));
            preparedStatement.setInt(8, (int) trans.getTags().get(1));
            preparedStatement.setInt(9, (int) trans.getTags().get(2));
            preparedStatement.setInt(10, (int) trans.getTags().get(3));
            rs = preparedStatement.executeUpdate();
        }catch (SQLException ex) {           
           JOptionPane.showMessageDialog(new JFrame(), ex.getMessage(),"Database Error",
            JOptionPane.ERROR_MESSAGE);
        }   
        if(rs > 0){
            return true;
        }else{
            return false;
        }
                 
    }
  /*
 * This function saves the whole return transaction.
 */    
    public boolean saveReturnTransaction(ReturnTransaction trans){
        
        String sql = "INSERT INTO ReturnTransactions(email,trans_date,fine,noOfDays,tagNo) VALUES(?,?,?,?,?)";
               int rs = 0;
               java.sql.Date sqlDate = new java.sql.Date(trans.getTransDate().getTime());
        try {
            PreparedStatement preparedStatement = super.sqlConnection.prepareStatement(sql);
            preparedStatement.setString(1, trans.getEmailID());
            preparedStatement.setDate(2, sqlDate );            
            preparedStatement.setDouble(3, trans.getFine());
            preparedStatement.setInt(4, trans.getNoOfDays());
            preparedStatement.setInt(5, trans.getTagNo());    
            rs = preparedStatement.executeUpdate();
        }catch (SQLException ex) {           
           JOptionPane.showMessageDialog(new JFrame(), ex.getMessage(),"Database Error",
            JOptionPane.ERROR_MESSAGE);
        }   
        if(rs > 0){
            return true;
        }else{
            return false;
        }
                 
    }
   /*
 * This function checks that user is new or old
 */   
    public boolean isNew(String number){        
        boolean temp =true;
        try {
            Statement st; 
            st = super.sqlConnection.createStatement();            
            String sql = "SELECT cardNo FROM transactions";  
            ResultSet rs = st.executeQuery(sql); 
            while(rs.next()){          
            if(number.equals(rs.getString("cardNo"))){
                temp= false;
            }
                }
                }catch (SQLException ex) {
                   JOptionPane.showMessageDialog(new JFrame(), ex.getMessage(),"Database Error",
                    JOptionPane.ERROR_MESSAGE);
                }
       

            return temp;
    }
    
}
