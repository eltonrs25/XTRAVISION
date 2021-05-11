/*
 * This class handles all panels related to renting and their events handling.
 */
package xtra.vision;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.util.Properties;
/**
 *
 * @author ha349
 */
public class RentGUI extends javax.swing.JFrame {

    /**
     * Creates new form MainView
     */
    public RentGUI() {
        
        cart = new Cart();
        try {
            db = new MoviesDAO();
            list = db.getAvailableMovies();
            db.releaseResources();
        } catch (SQLException ex) {
            Logger.getLogger(RentGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
       
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

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("XTRA-VISION");
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        moviesList = new MoviesListView(list);
        moviesList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JLabel temp = (JLabel)evt.getSource();
                showMovieDetails(temp.getParent().getComponentZOrder(temp));
            }
        });
        jPanel3.setMaximumSize(new java.awt.Dimension(800, 600));
        jPanel3.setMinimumSize(new java.awt.Dimension(800, 600));
        jPanel3.setPreferredSize(new java.awt.Dimension(800, 600));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel3.add(moviesList, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 800, 540));

        jPanel1.setBackground(new java.awt.Color(255, 0, 51));
        jPanel1.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("CHOOSE YOUR MOVIES");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, -1, -1));

        jButton1.setText("Home");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 20, -1, -1));

        jPanel3.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 60));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new MainView().setVisible(true);
                     dispose();
    }//GEN-LAST:event_jButton1ActionPerformed
  /*
 * This function shows the panel with list of movies
 */    
    public void showMoviesListView(){
        jLabel3.setText("CHOOSE YOUR MOVIES");
        moviesList = new MoviesListView(list);
        moviesList.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            JLabel temp = (JLabel)evt.getSource();
            showMovieDetails(temp.getParent().getComponentZOrder(temp));
        }
        });
        jPanel3.add(moviesList, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 800, 540));
        revalidate();
    }
  /*
 * This function shows the panel with detail of movies
 */        
    public void showMovieDetails(int index){
        Movie selected = (Movie)list.get(index);
        jPanel3.remove(moviesList);
        moviesDetail = new MovieDetailView(selected);
        moviesDetail.addRentButtListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if(cart.hasAlreadySelected(selected.getName())){
                    JOptionPane.showMessageDialog(new JFrame(), "You have already added this item to cart","Duplicate Item in Cart",JOptionPane.ERROR_MESSAGE);
                }else{
                    showCartGUI(selected.getName(),selected.getElectTagNo());
                }
                
            }
        });
        moviesDetail.addButtListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {                
                jPanel3.remove(moviesDetail);
                showMoviesListView();
            }
        });
        jPanel3.add(moviesDetail, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 800, 540));        
        revalidate();
        
    }
  /*
 * This function shows the panel with current cart
 */       
    public void showCartGUI(String name, int tag){
        jLabel3.setText("PRESS CHECKOUT");
                jPanel3.remove(moviesDetail);
                cart.addToCart(name,tag);
                cartview = new CartView();
                cartview.addButtListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    showPaymentGUI();
                }
                });
                cartview.addMoreButtListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                   if(cart.hasSpace()){
                     jPanel3.remove(cartview);
                    showMoviesListView();
                   } else{
                    JOptionPane.showMessageDialog(new JFrame(), "Sorry! No more space in Cart.","Cart Full",JOptionPane.ERROR_MESSAGE);
                }
                   
                }
                });                
                
                jPanel3.add(cartview, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 800, 540));
                revalidate();
        
                
    }
  /*
 * This function shows the panel results of rent transactions
 */        
     public void showRentFinalView(){
          jLabel3.setText("TRANSACTION COMPLETED");
         rentFinalview = new RentFinalView();
         rentFinalview.addExitButtListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    new MainView().setVisible(true);
                     dispose();
                }
                });
         jPanel3.remove(payView);
         jPanel3.add(rentFinalview, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 800, 540));
         revalidate();
     }
  /*
 * This function shows the panel with payment details
 */        
    public void showPaymentGUI(){
        jLabel3.setText("CARD PAYMENT");
        jPanel3.remove(cartview);
        payView = new PaymentView();
        payView.addPayButtListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    String data[] = payView.getEmailAndCardNo();
                    if(data[1].equals("") ){                        
                        JOptionPane.showMessageDialog(new JFrame(),"Please enter valid card number to proceed","Invalid Card Number",
                        JOptionPane.ERROR_MESSAGE);
                    }else{
                        if(!data[0].equals("") && !data[0].matches(PaymentView.EMAIL_PATTERN)){                            
                            JOptionPane.showMessageDialog(new JFrame(),"Please enter valid email address to proceed","Invalid Email",
                            JOptionPane.ERROR_MESSAGE);                            
                        }else{
                    RentTransaction transaction = new RentTransaction(data[0],new Date());
                    transaction.setCardNumber(data[1]);
                    transaction.setNoOfMovies(cart.getQty());
                    transaction.setMovies(cart.getMovies());
                    transaction.setRentAmount(cart.calculateAndReturnPrice());
                    transaction.setTags(cart.getMoviesTags());
        try {
            TransactionDAO db = new TransactionDAO();
            boolean saveOrNot = false;
            if(db.isNew(data[1])){
                if(cart.getQty() > 2 ){
                JOptionPane.showMessageDialog(new JFrame(),"You can only rent two discs in your first transaction! Please click cancel "
                        + "button below.","New User Limit",
                JOptionPane.ERROR_MESSAGE);
                }else{
                    saveOrNot = true;
                }
            }else{
                if(cart.getPromo() > 0 ){
                     JOptionPane.showMessageDialog(new JFrame(),"You can not use FREEMOVIE promo code! Please click cancel "
                        + "button below and remove promo from cart.","New User Limit",
                JOptionPane.ERROR_MESSAGE);
                }else{
                    saveOrNot = true;
                }
            }
            if(saveOrNot){
                if(db.saveRentTransaction(transaction)){
                    sendEmailToUser(transaction);
                    MoviesDAO movieDAO = new MoviesDAO();
                    for(int i=0; i < cart.getQty();i++){
                        movieDAO.changeMovieAvailabilityStatus((int) cart.getMoviesTags().get(i), false);
                    }                    
                    movieDAO.releaseResources();
                    showRentFinalView();
                }
            }
            db.releaseResources();
        } catch (SQLException ex) {
            Logger.getLogger(RentGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
                        }   }   }
                });
        payView.addCancelButtListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jPanel3.remove(payView);
                    showCartGUI(null,0);
                }
                });
        jPanel3.add(payView, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 800, 540));
        revalidate();
    }
      /*
 * This function send the email to user
 */    
    public void sendEmailToUser(RentTransaction t){
        String message ="<html>Rental Transaction<br /><br />Transaction Date = </html>" + t.getTransDate() + "<html><br /><br />Movies Rented = </html>" + t.getMovies() +
        "<html><br /><br />Total Rent Amount = </html>" + t.getRentAmount()+"<html><br /><br />Total No Of Movies Rented = </html>" + t.getNoOfMovies();
                  
                          try {           
			Properties defaultProps = new Properties();
		defaultProps.setProperty("mail.smtp.host", "smtp.gmail.com");
		defaultProps.setProperty("mail.smtp.port", "587");
		defaultProps.setProperty("mail.user", "your email");
		defaultProps.setProperty("mail.password", "pass");
		defaultProps.setProperty("mail.smtp.starttls.enable", "true");
		defaultProps.setProperty("mail.smtp.auth", "true");
			EmailUtility.sendEmail(defaultProps, t.getEmailID(), "Report",message , null);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
    private MoviesListView moviesList;
    private MovieDetailView moviesDetail;
    private CartView cartview;
    private PaymentView payView;
    private RentFinalView rentFinalview;
    private MoviesDAO db;
    private ArrayList list;
    public static Cart cart;
}
