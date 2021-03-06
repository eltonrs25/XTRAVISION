/*
 * This class is used to give user interface for showing cart.
 */
package xtra.vision;

import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author ha349
 */
public class CartView extends javax.swing.JPanel {

    /**
     * Creates new form MovieDetailView
     */
    public CartView() {        
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
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        total = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        promo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setEnabled(false);
        setMaximumSize(new java.awt.Dimension(800, 540));
        setMinimumSize(new java.awt.Dimension(800, 540));
        setPreferredSize(new java.awt.Dimension(800, 540));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Cart Details");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 80, -1));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, 680, 10));
        add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 680, 10));
        add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 680, 10));

        jSeparator4.setEnabled(false);
        add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, 680, 10));

        jSeparator5.setForeground(new java.awt.Color(204, 0, 0));
        jSeparator5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, 680, 10));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Cart Price");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 290, -1, -1));

        jButton1.setBackground(new java.awt.Color(102, 255, 51));
        jButton1.setText("Checkout And Pay");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 350, -1, -1));
        add(total, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 290, 110, 20));

        jButton2.setText("Add more to Cart");
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 40, -1, -1));
        add(promo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 290, 180, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Promo Code");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, -1, -1));

        jButton3.setText("Apply");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 290, -1, -1));

        jLabel3.setText("- 2.99??");
        jLabel3.setVisible(false);
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(665, 250, 40, 20));

        jLabel5.setText("Promo");
        jLabel5.setVisible(false);
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 250, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/xtra/vision/remove.jpg"))); // NOI18N
        jLabel6.setText("Remove");
        jLabel6.setVisible(false);
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 250, -1, -1));
        showCartItems();
    }// </editor-fold>//GEN-END:initComponents
/*
 * This function checks the promo validity.
 */
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if(promo.getText().equalsIgnoreCase("freemovie") ){            
            RentGUI.cart.setPromo(2.99);
            showPromo(true);
        }else{
            JOptionPane.showMessageDialog(new JFrame(),"Invalid Promo Code!","Prommo Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton3ActionPerformed
/*
 * This function removes the promo from cart.
 */
    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        // TODO add your handling code here:
        RentGUI.cart.setPromo(0.0);
        showPromo(false);
    }//GEN-LAST:event_jLabel6MouseClicked
    
    public void addButtListener(ActionListener listener){
        this.jButton1.addActionListener(listener);
    }
 /*
 * This function shows the promo details on screen.
 */   
    public void showPromo(boolean yesNo){        
            jLabel3.setVisible(yesNo);
            jLabel5.setVisible(yesNo);
            jLabel6.setVisible(yesNo);
            total.setText(String.valueOf(RentGUI.cart.calculateAndReturnPrice()+" ??"));        
    }
    
    public void addMoreButtListener(ActionListener listener){
        this.jButton2.addActionListener(listener);
    }
  /*
 * This function shows the complete cart items and details on the screen.
 */     
    public void showCartItems(){
        javax.swing.JLabel Items[] = new javax.swing.JLabel[4];
        javax.swing.JLabel Prices[] = new javax.swing.JLabel[4];
        javax.swing.JLabel RemoveLabels[] = new javax.swing.JLabel[4];
        int y = 130;
        for(int i=0; i < RentGUI.cart.getQty();i++){
            String name = RentGUI.cart.getCartItem(i);
            Items[i]= new javax.swing.JLabel(RentGUI.cart.getCartItem(i));           
            add(Items[i], new org.netbeans.lib.awtextra.AbsoluteConstraints(60, y, 280, 20));
            Prices[i]= new javax.swing.JLabel("2.99??");
            add(Prices[i], new org.netbeans.lib.awtextra.AbsoluteConstraints(670, y, 40, 20));            
            RemoveLabels[i]= new javax.swing.JLabel("Remove");
            RemoveLabels[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/xtra/vision/remove.jpg"))); 
            RemoveLabels[i].setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            add(RemoveLabels[i], new org.netbeans.lib.awtextra.AbsoluteConstraints(560, y, -1, -1));
            RemoveLabels[i].addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                
                for(int i=0; i < RentGUI.cart.getQty();i++){
                    remove(Items[i]);
                    remove(Prices[i]);
                    remove(RemoveLabels[i]);                       
                }   
                repaint();
                RentGUI.cart.removeFromCart(name);
                showCartItems();
                 
            }
        });
            y+=30;
        }
        if(RentGUI.cart.getPromo() > 0){
            showPromo(true);
        }
        total.setText(String.valueOf(RentGUI.cart.calculateAndReturnPrice()+" ??"));
        
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTextField promo;
    private javax.swing.JLabel total;
    // End of variables declaration//GEN-END:variables
    
}
