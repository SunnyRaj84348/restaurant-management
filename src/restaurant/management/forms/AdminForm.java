package restaurant.management.forms;

import com.formdev.flatlaf.FlatDarkLaf;

public class AdminForm extends javax.swing.JFrame {

    public AdminForm() {
        // Set FlatLaf Dark theme
        FlatDarkLaf.setup();

        initComponents();

        jTabbedPane1.add(new EmployeeForm());
        jTabbedPane1.add(new ItemsForm());

        empButton.grabFocus();
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
        jTabbedPane1 = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(89, 92, 87));
        setResizable(false);

        rootPanel.setBackground(new java.awt.Color(51, 51, 51));
        rootPanel.setPreferredSize(new java.awt.Dimension(929, 688));
        rootPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        headerPanel.setBackground(new java.awt.Color(13, 13, 18));
        headerPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        dashLabel.setBackground(new java.awt.Color(0, 0, 0));
        dashLabel.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        dashLabel.setForeground(new java.awt.Color(255, 255, 255));
        dashLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dashLabel.setText("Admin Dashboard");
        headerPanel.add(dashLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 60));

        logoutButton.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        logoutButton.setForeground(new java.awt.Color(255, 255, 255));
        logoutButton.setText("LOGOUT");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });
        headerPanel.add(logoutButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 10, 80, 20));

        rootPanel.add(headerPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, -1));

        leftPanel.setBackground(new java.awt.Color(49, 51, 53));
        leftPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        empButton.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        empButton.setForeground(new java.awt.Color(255, 255, 255));
        empButton.setText("Employee");
        empButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empButtonActionPerformed(evt);
            }
        });
        leftPanel.add(empButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 170, 44));

        itemsButton.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        itemsButton.setForeground(new java.awt.Color(255, 255, 255));
        itemsButton.setText("Dish Items");
        itemsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemsButtonActionPerformed(evt);
            }
        });
        leftPanel.add(itemsButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 170, 44));

        rootPanel.add(leftPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 58, 210, 650));
        rootPanel.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(213, 18, 740, 690));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(rootPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 950, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rootPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 708, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void itemsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemsButtonActionPerformed
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_itemsButtonActionPerformed

    private void empButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empButtonActionPerformed
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_empButtonActionPerformed

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel dashLabel;
    private javax.swing.JButton empButton;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JButton itemsButton;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel leftPanel;
    private javax.swing.JButton logoutButton;
    private javax.swing.JPanel rootPanel;
    // End of variables declaration//GEN-END:variables
}
