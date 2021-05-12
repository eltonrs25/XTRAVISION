/*
 * This class is used to show movie details to user as selected.
 */
package xtra.vision;

import java.awt.event.ActionListener;

/**
 *
 * @author ha349
 */
public class MovieDetailView extends javax.swing.JPanel {

    /**
     * Creates new form MovieDetailView
     */
    public MovieDetailView(Movie movie) {
        this.aMovie = movie;
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

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        movieName = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        poster1 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(800, 540));
        setMinimumSize(new java.awt.Dimension(800, 540));
        setPreferredSize(new java.awt.Dimension(800, 540));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("Rent");
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 410, -1, -1));

        jButton2.setText("Back");
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 450, -1, -1));

        movieName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        movieName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        movieName.setText(aMovie.getName());
        add(movieName, new org.netbeans.lib.awtextra.AbsoluteConstraints(224, 40, 360, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Length");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 460, 100, -1));

        jTextArea2.setEditable(false);
        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jTextArea2.setText(aMovie.getDescription());
        jTextArea2.setCaretPosition( 0 );
        jScrollPane3.setViewportView(jTextArea2);

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 120, 500, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Description");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 90, 70, -1));

        jTextArea3.setEditable(false);
        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        String[] arrOfStr = aMovie.getCast().split(",", 0);
        for (String a : arrOfStr){
            jTextArea3.append(a+"\n");
        }
        jScrollPane4.setViewportView(jTextArea3);

        add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 270, 230, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Cast");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 240, 30, -1));

        jTextField1.setEditable(false);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.setText(aMovie.getLength());
        add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 490, 230, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Released Date");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 390, 100, -1));

        jTextField2.setEditable(false);
        jTextField2.setText(aMovie.getReleaseDate().toString());
        add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 420, 230, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Category");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 390, 100, -1));

        jTextField3.setEditable(false);
        jTextField3.setText(aMovie.getCategory());
        add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 420, 230, -1));

        poster1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/xtra/vision/posters/"+aMovie.getName()+".jpg")));
        add(poster1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 182, 268));
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed
    
    public void addButtListener(ActionListener listener){
    this.jButton2.addActionListener(listener);
    }
    
    public void addRentButtListener(ActionListener listener){
    this.jButton1.addActionListener(listener);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JLabel movieName;
    private javax.swing.JLabel poster1;
    // End of variables declaration//GEN-END:variables
    public Movie aMovie;
}