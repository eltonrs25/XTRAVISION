    /*
 * This class shows the transaction details for a return .
 */ 
package xtra.vision;

import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 *
 * @author ha349
 */
public class ReturnFinalView extends javax.swing.JPanel {

    /**
     * Creates new form MovieDetailView
     */
    public ReturnFinalView(ReturnTransaction a, String Date) {
        this.trans = a;
        this.rentDate = Date;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        total = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        AddCharges = new javax.swing.JLabel();
        rentalDate = new javax.swing.JLabel();
        totDays = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        returnDate = new javax.swing.JLabel();

        setEnabled(false);
        setMaximumSize(new java.awt.Dimension(800, 540));
        setMinimumSize(new java.awt.Dimension(800, 540));
        setPreferredSize(new java.awt.Dimension(800, 540));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 153, 0));
        jLabel4.setText("Transaction Successful");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, 220, -1));
        add(total, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 290, 110, 20));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Rental Summary");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 270, -1));

        jButton2.setText("Exit");
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 330, 90, -1));

        jLabel2.setText("Total No of Days :");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));

        jLabel3.setText("Date of rent : ");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        jLabel5.setText("Additional Charges : ");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));

        AddCharges.setForeground(new java.awt.Color(255, 51, 51));
        AddCharges.setText(String.valueOf(trans.getFine()));
        add(AddCharges, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 250, 120, 20));

        rentalDate.setForeground(new java.awt.Color(0, 0, 204));
        rentalDate.setText(rentDate);
        add(rentalDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 120, 20));

        totDays.setForeground(new java.awt.Color(0, 0, 204));
        totDays.setText(String.valueOf(trans.getNoOfDays()));
        add(totDays, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, 120, 20));

        jLabel6.setText("Date of return : ");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        returnDate.setForeground(new java.awt.Color(0, 0, 204));
        String pattern = "MM/dd/yyyy";
        DateFormat df = new SimpleDateFormat(pattern);
        returnDate.setText(df.format(trans.getTransDate().getTime()));
        add(returnDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, 120, 20));
    }// </editor-fold>//GEN-END:initComponents
    public void addExitButtListener(ActionListener listener){
        this.jButton2.addActionListener(listener);        
    }
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AddCharges;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel rentalDate;
    private javax.swing.JLabel returnDate;
    private javax.swing.JLabel totDays;
    private javax.swing.JLabel total;
    // End of variables declaration//GEN-END:variables
   private ReturnTransaction trans;
   private String rentDate;
}
