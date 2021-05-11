/*
 * This class is used as a Data Access Object class which establishes and removes the connection with database.
 */
package xtra.vision;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class DAO {
    public Connection sqlConnection;
 /*
 * This function establishes the connection.
 */    
    public void establishConnection() throws SQLException{ 
            
     try {        
         sqlConnection = DriverManager.getConnection("jdbc:ucanaccess://ProjectDB.accdb;jackcessOpener=xtra.vision.CryptCodecOpener", "Elton", "aakigb");
         } catch (SQLException ex) {
             ex.printStackTrace();
             JOptionPane.showMessageDialog(new JFrame(), ex.getMessage(),"Database Error",JOptionPane.ERROR_MESSAGE);
            }
    
    }
  /*
 * This function release the connection.
 */       
    public void releaseResources() {
        try{ 
            if(sqlConnection != null){
                sqlConnection.close();
            } 
        }
        catch(SQLException ex){ 
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage(),"Database Error",JOptionPane.ERROR_MESSAGE);
        } 
    } 
}
