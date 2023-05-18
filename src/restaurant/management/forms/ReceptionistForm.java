package restaurant.management.forms;

public class ReceptionistForm extends javax.swing.JFrame {

    public ReceptionistForm() {
        initComponents();

        jTabbedPane1.add(new CustomerPanel());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rootPanel = new javax.swing.JPanel();
        headerPanel = new javax.swing.JPanel();
        dashLabel = new javax.swing.JLabel();
        logoutButton = new javax.swing.JButton();
        leftPanel = new javax.swing.JPanel();
        empButton = new javax.swing.JButton();
        itemsButton = new javax.swing.JButton();
        itemsButton1 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        rootPanel.setBackground(new java.awt.Color(51, 51, 51));
        rootPanel.setPreferredSize(new java.awt.Dimension(929, 688));
        rootPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        headerPanel.setBackground(new java.awt.Color(13, 13, 18));
        headerPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        dashLabel.setBackground(new java.awt.Color(0, 0, 0));
        dashLabel.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        dashLabel.setForeground(new java.awt.Color(255, 255, 255));
        dashLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dashLabel.setText("Receptionist Dashboard");
        headerPanel.add(dashLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 60));

        logoutButton.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        logoutButton.setForeground(new java.awt.Color(255, 255, 255));
        logoutButton.setText("LOGOUT");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });
        headerPanel.add(logoutButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 10, 80, 20));

        rootPanel.add(headerPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1170, -1));

        leftPanel.setBackground(new java.awt.Color(49, 51, 53));
        leftPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        empButton.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        empButton.setForeground(new java.awt.Color(255, 255, 255));
        empButton.setText("Customer");
        empButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empButtonActionPerformed(evt);
            }
        });
        leftPanel.add(empButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 130, 44));

        itemsButton.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        itemsButton.setForeground(new java.awt.Color(255, 255, 255));
        itemsButton.setText("Order History");
        itemsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemsButtonActionPerformed(evt);
            }
        });
        leftPanel.add(itemsButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 130, 44));

        itemsButton1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        itemsButton1.setForeground(new java.awt.Color(255, 255, 255));
        itemsButton1.setText("Invoice");
        itemsButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemsButton1ActionPerformed(evt);
            }
        });
        leftPanel.add(itemsButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 130, 44));

        rootPanel.add(leftPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 58, 190, 710));
        rootPanel.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(193, 18, 980, 750));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(rootPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rootPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 769, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        // Dispose all allocated forms
        for (var form : LoginForm.subForms) {
            form.dispose();
        }

        // Remove all forms from list
        LoginForm.subForms.clear();

        var loginForm = new LoginForm();
        loginForm.setVisible(true);
    }//GEN-LAST:event_logoutButtonActionPerformed

    private void empButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empButtonActionPerformed
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_empButtonActionPerformed

    private void itemsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemsButtonActionPerformed
        jTabbedPane1.add(new OrderHistoryPanel());
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_itemsButtonActionPerformed

    private void itemsButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemsButton1ActionPerformed
        jTabbedPane1.add(new InvoicePanel());
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_itemsButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel dashLabel;
    private javax.swing.JButton empButton;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JButton itemsButton;
    private javax.swing.JButton itemsButton1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel leftPanel;
    private javax.swing.JButton logoutButton;
    private javax.swing.JPanel rootPanel;
    // End of variables declaration//GEN-END:variables
}
