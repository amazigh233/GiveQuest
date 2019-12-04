/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login.scherm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author jugraj
 */
public class ToevoegScherm extends javax.swing.JFrame {

    /**
     * Creates new form main
     */
    public ToevoegScherm() {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        gewichtField = new javax.swing.JTextField();
        merkField = new javax.swing.JTextField();
        naamField = new javax.swing.JTextField();
        soortField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 23, 250, 400));
        setMinimumSize(new java.awt.Dimension(250, 400));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBounds(new java.awt.Rectangle(0, 23, 250, 400));
        jPanel1.setMaximumSize(new java.awt.Dimension(250, 400));
        jPanel1.setPreferredSize(new java.awt.Dimension(250, 400));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/button.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 280, 90, 40));

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Product toevoegen");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-6, 30, 260, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ball_kleiner.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, -200, -1, -1));

        gewichtField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        gewichtField.setText("Gewicht");
        jPanel1.add(gewichtField, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 190, -1));

        merkField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        merkField.setText("Merk");
        merkField.setToolTipText("");
        merkField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                merkFieldActionPerformed(evt);
            }
        });
        jPanel1.add(merkField, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 190, -1));

        naamField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        naamField.setText("Naam");
        jPanel1.add(naamField, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 190, -1));

        soortField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        soortField.setText("Soort");
        jPanel1.add(soortField, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 190, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void merkFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_merkFieldActionPerformed
    }//GEN-LAST:event_merkFieldActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_db","test","Jugraj123");
            
            Statement stm = con.createStatement();
            
            stm.executeUpdate("insert into Product(merk, naam, soort, gewicht)" + " values "
                    + "('" + merkField.getText() + "','"
                    + naamField.getText() + "','"
                    + soortField.getText() + "', "
                    + gewichtField.getText() + ")");      
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ToevoegScherm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ToevoegScherm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ToevoegScherm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ToevoegScherm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ToevoegScherm().setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField gewichtField;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField merkField;
    private javax.swing.JTextField naamField;
    private javax.swing.JTextField soortField;
    // End of variables declaration//GEN-END:variables
}
