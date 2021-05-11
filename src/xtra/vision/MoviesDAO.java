/*
 * This class inherits from DAO class and interacts with movies table in database.
 */
package xtra.vision;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**

 */
public class MoviesDAO extends DAO {
    /*
 * Constructors of class
 */     
    MoviesDAO() throws SQLException{        
        super.establishConnection();       
    }
  /*
 * This function returns all the available movies in the machine.
 */    
    public ArrayList getAvailableMovies(){
        
        Statement stmt;
        ArrayList availableMovies = new ArrayList();
        try {
            String sql= "SELECT *  FROM Movies WHERE Available = yes";
            stmt = super.sqlConnection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {   
                
            String movieName = (String)rs.getString("MovieName");
            String castNames = (String)rs.getString("Cast");             
            Date relDate = rs.getDate("ReleasedDate");     
            String desc = (String)rs.getString("Description");
            String length = (String)rs.getString("Length");
            String cat = (String)rs.getString("Category");
            int tagNo = rs.getInt("electronic_TagNo");
            Movie a = new Movie(movieName,castNames,relDate,desc,length,cat,tagNo); 
            availableMovies.add(a);
                    } }
            catch (SQLException ex) {            
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage(),"Database Error",
            JOptionPane.ERROR_MESSAGE);
        }
         
       
        
        return availableMovies;
    
    } 
  /*
 * This function checks whehter the movie is available or not.
 */     
    public boolean checkAvailabilityStatus(int tagNo){
        String sql = "SELECT Available from Movies WHERE electronic_TagNo = ? ";
        boolean matched = false;       
        try {
            PreparedStatement preparedStatement = super.sqlConnection.prepareStatement(sql);          
            preparedStatement.setInt(1, tagNo);    
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {  
                matched = rs.getBoolean("Available");
            }
        }catch (SQLException ex) {           
           JOptionPane.showMessageDialog(new JFrame(), ex.getMessage(),"Database Error",
            JOptionPane.ERROR_MESSAGE);
        }   
        return matched;
    }
  /*
 * This function changes the movie availability status in database.
 */     
    public void changeMovieAvailabilityStatus(int tagNo, boolean choice){
         String sql = "UPDATE Movies SET Available = ? WHERE electronic_TagNo = ? ";
               int rs = 0;
        try {
            PreparedStatement preparedStatement = super.sqlConnection.prepareStatement(sql);
            preparedStatement.setBoolean(1, choice);            
            preparedStatement.setInt(2,tagNo);            
            rs = preparedStatement.executeUpdate();
        }catch (SQLException ex) {           
           JOptionPane.showMessageDialog(new JFrame(), ex.getMessage(),"Database Error",
            JOptionPane.ERROR_MESSAGE);
        }   
       
    }

    
}
