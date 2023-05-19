package restaurant.management.forms;

import java.math.BigInteger;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import restaurant.management.models.Database;

public class CustomerForm extends javax.swing.JPanel {
    
    private ReceptionistForm receptionistForm;
    
    public CustomerForm(ReceptionistForm receptionistForm) {
        initComponents();
        
        this.receptionistForm = receptionistForm;
    }
    
    boolean validateData() {
        if (nameField.getText().trim().isEmpty() || phoneField.getText().trim().isEmpty()
                || addressArea.getText().trim().isEmpty()) {
            
            JOptionPane.showMessageDialog(this, "One or more fields are empty");
            return false;
        }

        // Check phone number field length is correct
        if ((phoneField.getText().length() != 10 && phoneField.getText().length() != 12)) {
            JOptionPane.showMessageDialog(this, "Invalid phone number");
            return false;
        }

        // Check if phone number is valid
        try {
            new BigInteger(phoneField.getText());
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid phone number");
            return false;
        }
        
        return true;
    }
    
    void clearFields() {
        customerSearchField.setText("");
        idField.setText("");
        nameField.setText("");
        phoneField.setText("");
        addressArea.setText("");
    }
    
    void showAllCustomers() {
        try {
            var db = new Database();
            
            var customerList = db.getAllCustomers();
            
            if (customerList.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No customer entry founded");
                return;
            }
            
            customerTable.setRowSorter(null);
            
            var tableModel = (DefaultTableModel) customerTable.getModel();
            tableModel.setRowCount(0);
            
            for (var customer : customerList) {
                tableModel.addRow(new Object[]{
                    customer.customerID, customer.customerName,
                    customer.customerPhone, customer.customerAddress
                });
            }
            
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addressLabel = new javax.swing.JLabel();
        customerSearchField = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        customerTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        clearButton = new javax.swing.JButton();
        CustomerSearchLabel = new javax.swing.JLabel();
        clearTableButton = new javax.swing.JButton();
        headingLabel = new javax.swing.JLabel();
        idLabel = new javax.swing.JLabel();
        addButton = new javax.swing.JButton();
        showAllButton = new javax.swing.JButton();
        nameField = new javax.swing.JTextField();
        idField = new javax.swing.JTextField();
        updateButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        addressArea = new javax.swing.JTextArea();
        nameLabel = new javax.swing.JLabel();
        phoneLabel = new javax.swing.JLabel();
        phoneField = new javax.swing.JTextField();

        addressLabel.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        addressLabel.setText("Address");

        customerSearchField.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        customerSearchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                customerSearchFieldKeyReleased(evt);
            }
        });

        customerTable.setBackground(new java.awt.Color(102, 102, 102));
        customerTable.setBorder(new javax.swing.border.MatteBorder(null));
        customerTable.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        customerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Phone", "Address"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        customerTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                customerTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(customerTable);

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Customers Data");

        clearButton.setBackground(new java.awt.Color(0, 102, 102));
        clearButton.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        clearButton.setForeground(new java.awt.Color(255, 255, 255));
        clearButton.setText("Clear");
        clearButton.setPreferredSize(new java.awt.Dimension(80, 30));
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        CustomerSearchLabel.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        CustomerSearchLabel.setText("Search Customer");

        clearTableButton.setBackground(new java.awt.Color(0, 102, 102));
        clearTableButton.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        clearTableButton.setForeground(new java.awt.Color(255, 255, 255));
        clearTableButton.setText("Clear Table");
        clearTableButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearTableButtonActionPerformed(evt);
            }
        });

        headingLabel.setBackground(new java.awt.Color(0, 0, 0));
        headingLabel.setFont(new java.awt.Font("Century Gothic", 1, 32)); // NOI18N
        headingLabel.setForeground(new java.awt.Color(255, 255, 255));
        headingLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headingLabel.setText("Manage Customers");

        idLabel.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        idLabel.setText("ID");

        addButton.setBackground(new java.awt.Color(0, 102, 102));
        addButton.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        addButton.setForeground(new java.awt.Color(255, 255, 255));
        addButton.setText("Add");
        addButton.setPreferredSize(new java.awt.Dimension(80, 30));
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        showAllButton.setBackground(new java.awt.Color(0, 102, 102));
        showAllButton.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        showAllButton.setForeground(new java.awt.Color(255, 255, 255));
        showAllButton.setText("Show All");
        showAllButton.setPreferredSize(new java.awt.Dimension(80, 30));
        showAllButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showAllButtonActionPerformed(evt);
            }
        });

        nameField.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        idField.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        idField.setEnabled(false);

        updateButton.setBackground(new java.awt.Color(0, 102, 102));
        updateButton.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        updateButton.setForeground(new java.awt.Color(255, 255, 255));
        updateButton.setText("Update");
        updateButton.setPreferredSize(new java.awt.Dimension(80, 30));
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        addressArea.setColumns(20);
        addressArea.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        addressArea.setRows(5);
        jScrollPane1.setViewportView(addressArea);

        nameLabel.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        nameLabel.setText("Name");

        phoneLabel.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        phoneLabel.setText("Phone");

        phoneField.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(headingLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(139, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(showAllButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(224, 224, 224))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(idLabel)
                                    .addComponent(nameLabel)
                                    .addComponent(phoneLabel))
                                .addGap(95, 95, 95)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(nameField)
                                    .addComponent(idField)
                                    .addComponent(phoneField, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(CustomerSearchLabel)
                                .addGap(31, 31, 31)
                                .addComponent(customerSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(95, 95, 95)
                        .addComponent(addressLabel)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(121, 121, 121))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(clearTableButton, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(423, 423, 423))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(headingLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(CustomerSearchLabel)
                                .addComponent(customerSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(addressLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(idLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(phoneField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(phoneLabel))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(showAllButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(clearTableButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void customerSearchFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_customerSearchFieldKeyReleased
        showAllCustomers();
        
        var tableModel = (DefaultTableModel) customerTable.getModel();
        var sorter = new TableRowSorter<>(tableModel);
        
        customerTable.setRowSorter(sorter);
        
        var text = customerSearchField.getText();
        
        var pattern = "^";
        
        for (int i = 0; i < text.length(); i++) {
            // Append space and skip iteration
            if (text.charAt(i) == ' ') {
                pattern += " ";
                continue;
            }

            // Append character sets to match both lower and upper case
            pattern += "[" + Character.toLowerCase(text.charAt(i))
                    + Character.toUpperCase(text.charAt(i))
                    + "]";
        }

        // Append asterisk quantifier wildcard at end to match char if exists
        pattern += ".*";
        
        sorter.setRowFilter(RowFilter.regexFilter(pattern));
    }//GEN-LAST:event_customerSearchFieldKeyReleased
    
    private void customerTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customerTableMouseClicked
        var selectedRow = customerTable.getSelectedRow();
        
        idField.setText(customerTable.getValueAt(selectedRow, 0).toString());
        nameField.setText(customerTable.getValueAt(selectedRow, 1).toString());
        phoneField.setText(customerTable.getValueAt(selectedRow, 2).toString());
        addressArea.setText(customerTable.getValueAt(selectedRow, 3).toString());
        
        receptionistForm.enableButtons();
        receptionistForm.initInvoiceForm(Integer.parseInt(idField.getText()));
    }//GEN-LAST:event_customerTableMouseClicked
    
    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        clearFields();
    }//GEN-LAST:event_clearButtonActionPerformed
    
    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        if (!validateData()) {
            return;
        }
        
        try {
            var db = new Database();
            
            db.insertCustomer(nameField.getText(), phoneField.getText(), addressArea.getText());
            
            clearFields();
            
            JOptionPane.showMessageDialog(this, "Customer added");
            
        } catch (SQLIntegrityConstraintViolationException e) {
            JOptionPane.showMessageDialog(this, "Phone no. already exists");
            
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_addButtonActionPerformed
    
    private void showAllButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showAllButtonActionPerformed
        showAllCustomers();
    }//GEN-LAST:event_showAllButtonActionPerformed
    
    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        var selectedRow = customerTable.getSelectedRow();
        
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Select Customer row before updating");
            return;
        }
        
        if (!validateData()) {
            return;
        }
        
        try {
            var db = new Database();
            
            db.updateCustomer(Integer.parseInt(idField.getText()), nameField.getText(),
                    phoneField.getText(), addressArea.getText());
            
            customerTable.setValueAt(idField.getText(), selectedRow, 0);
            customerTable.setValueAt(nameField.getText(), selectedRow, 1);
            customerTable.setValueAt(phoneField.getText(), selectedRow, 2);
            customerTable.setValueAt(addressArea.getText(), selectedRow, 3);
            
            JOptionPane.showMessageDialog(this, "Data updated");
            
        } catch (SQLIntegrityConstraintViolationException e) {
            JOptionPane.showMessageDialog(this, "Phone no. already exists");
            
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_updateButtonActionPerformed
    
    private void clearTableButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearTableButtonActionPerformed
        var tableModel = (DefaultTableModel) customerTable.getModel();
        tableModel.setRowCount(0);
    }//GEN-LAST:event_clearTableButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CustomerSearchLabel;
    private javax.swing.JButton addButton;
    private javax.swing.JTextArea addressArea;
    private javax.swing.JLabel addressLabel;
    private javax.swing.JButton clearButton;
    private javax.swing.JButton clearTableButton;
    private javax.swing.JTextField customerSearchField;
    private javax.swing.JTable customerTable;
    private javax.swing.JLabel headingLabel;
    private javax.swing.JTextField idField;
    private javax.swing.JLabel idLabel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField phoneField;
    private javax.swing.JLabel phoneLabel;
    private javax.swing.JButton showAllButton;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
