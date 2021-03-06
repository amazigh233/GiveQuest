/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login.scherm;
/**
 *
 * @author jugraj
 */
public class inlog extends javax.swing.JFrame {

    public inlog() {
        initComponents();
        GiveQuest.setButtonLook(registreerButton);
        GiveQuest.defaultBehaviour(this);
        
    }
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        emailField = new javax.swing.JTextField();
        registrerenTextLabel = new javax.swing.JLabel();
        logInTextLabel = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        message = new javax.swing.JLabel();
        sumbitButton = new javax.swing.JButton();
        ballLabel = new javax.swing.JLabel();
        vergeetLabel = new javax.swing.JLabel();
        registreerButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 23, 250, 400));
        setMaximumSize(new java.awt.Dimension(250, 400));
        setMinimumSize(new java.awt.Dimension(250, 400));
        setSize(new java.awt.Dimension(250, 400));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(250, 400));
        jPanel1.setMinimumSize(new java.awt.Dimension(250, 400));
        jPanel1.setPreferredSize(new java.awt.Dimension(250, 400));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        emailField.setText("Email");
        jPanel1.add(emailField, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 190, 30));

        registrerenTextLabel.setBackground(new java.awt.Color(255, 255, 255));
        registrerenTextLabel.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        registrerenTextLabel.setForeground(new java.awt.Color(255, 255, 255));
        registrerenTextLabel.setText("Registreren");
        jPanel1.add(registrerenTextLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 370, -1, 20));

        logInTextLabel.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        logInTextLabel.setForeground(new java.awt.Color(255, 255, 255));
        logInTextLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logInTextLabel.setText("Log in");
        jPanel1.add(logInTextLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(-3, 60, 260, -1));

        passwordField.setText("jPasswordField1");
        jPanel1.add(passwordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 190, 30));

        message.setBackground(new java.awt.Color(0, 0, 0));
        message.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(message, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 190, 10));

        sumbitButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/button.png"))); // NOI18N
        sumbitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sumbitButtonActionPerformed(evt);
            }
        });
        jPanel1.add(sumbitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, 90, 40));

        ballLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ball_kleiner.png"))); // NOI18N
        jPanel1.add(ballLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(-50, -150, -1, -1));

        vergeetLabel.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        vergeetLabel.setForeground(new java.awt.Color(180, 228, 205));
        vergeetLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        vergeetLabel.setText("Wachtwoord vergeten");
        jPanel1.add(vergeetLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 300, 180, -1));

        registreerButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ball_klein.png"))); // NOI18N
        registreerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registreerButtonActionPerformed(evt);
            }
        });
        jPanel1.add(registreerButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 320, 190, 190));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void sumbitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sumbitButtonActionPerformed
        if(DbConnection.DBHandler.verifyLogin(emailField.getText(), passwordField.getPassword())){
            message.setText("Inlog succes");
            new menuScherm().setVisible(true);
            this.dispose();
        }
        else{
            message.setText("Inlog gefaald");
        }

    }//GEN-LAST:event_sumbitButtonActionPerformed

    private void registreerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registreerButtonActionPerformed
        new registreerScherm().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_registreerButtonActionPerformed

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
            java.util.logging.Logger.getLogger(inlog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(inlog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(inlog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(inlog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new inlog().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ballLabel;
    private javax.swing.JTextField emailField;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel logInTextLabel;
    private javax.swing.JLabel message;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JButton registreerButton;
    private javax.swing.JLabel registrerenTextLabel;
    private javax.swing.JButton sumbitButton;
    private javax.swing.JLabel vergeetLabel;
    // End of variables declaration//GEN-END:variables
}
