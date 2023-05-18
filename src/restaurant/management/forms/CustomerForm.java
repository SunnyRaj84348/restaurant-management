package restaurant.management.forms;

import com.formdev.flatlaf.FlatDarkLaf;
import java.math.BigInteger;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import restaurant.management.models.Database;

public class CustomerForm extends javax.swing.JFrame {

    public CustomerForm() {
        // Set FlatLaf Dark theme
        FlatDarkLaf.setup();

        initComponents();
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

        rootPanel = new javax.swing.JPanel();
        idLabel = new javax.swing.JLabel();
        clearTableButton = new javax.swing.JButton();
        phoneField = new javax.swing.JTextField();
        orderHistoryButton = new javax.swing.JButton();
        phoneLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        customerSearchField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        addressArea = new javax.swing.JTextArea();
        CustomerSearchLabel = new javax.swing.JLabel();
        idField = new javax.swing.JTextField();
        nameLabel = new javax.swing.JLabel();
        updateButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        customerTable = new javax.swing.JTable();
        addButton = new javax.swing.JButton();
        invoiceDashButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        showAllButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        addressLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        idLabel.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        idLabel.setText("ID");

        clearTableButton.setBackground(new java.awt.Color(0, 102, 102));
        clearTableButton.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        clearTableButton.setForeground(new java.awt.Color(255, 255, 255));
        clearTableButton.setText("Clear Table");
        clearTableButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearTableButtonActionPerformed(evt);
            }
        });

        phoneField.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        orderHistoryButton.setBackground(new java.awt.Color(0, 102, 102));
        orderHistoryButton.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        orderHistoryButton.setForeground(new java.awt.Color(255, 255, 255));
        orderHistoryButton.setText("Order History");
        orderHistoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderHistoryButtonActionPerformed(evt);
            }
        });

        phoneLabel.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        phoneLabel.setText("Phone");

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Customers Data");

        nameField.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        customerSearchField.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        customerSearchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                customerSearchFieldKeyReleased(evt);
            }
        });

        addressArea.setColumns(20);
        addressArea.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        addressArea.setRows(5);
        jScrollPane1.setViewportView(addressArea);

        CustomerSearchLabel.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        CustomerSearchLabel.setText("Search Customer");

        idField.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        idField.setEnabled(false);

        nameLabel.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        nameLabel.setText("Name");

        updateButton.setBackground(new java.awt.Color(0, 102, 102));
        updateButton.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        updateButton.setForeground(new java.awt.Color(255, 255, 255));
        updateButton.setText("Update");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
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

        addButton.setBackground(new java.awt.Color(0, 102, 102));
        addButton.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        addButton.setForeground(new java.awt.Color(255, 255, 255));
        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        invoiceDashButton.setBackground(new java.awt.Color(0, 102, 102));
        invoiceDashButton.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        invoiceDashButton.setForeground(new java.awt.Color(255, 255, 255));
        invoiceDashButton.setText("Invoice Dashboard");
        invoiceDashButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invoiceDashButtonActionPerformed(evt);
            }
        });

        clearButton.setBackground(new java.awt.Color(0, 102, 102));
        clearButton.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        clearButton.setForeground(new java.awt.Color(255, 255, 255));
        clearButton.setText("Clear");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        showAllButton.setBackground(new java.awt.Color(0, 102, 102));
        showAllButton.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        showAllButton.setForeground(new java.awt.Color(255, 255, 255));
        showAllButton.setText("Show All");
        showAllButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showAllButtonActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(0, 102, 102));
        jButton1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jButton1.setText("LogOut");

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Manage Customers");

        addressLabel.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        addressLabel.setText("Address");

        javax.swing.GroupLayout rootPanelLayout = new javax.swing.GroupLayout(rootPanel);
        rootPanel.setLayout(rootPanelLayout);
        rootPanelLayout.setHorizontalGroup(
            rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rootPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rootPanelLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(rootPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(rootPanelLayout.createSequentialGroup()
                                .addComponent(CustomerSearchLabel)
                                .addGap(31, 31, 31)
                                .addComponent(customerSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(rootPanelLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(idLabel)
                                    .addComponent(nameLabel)
                                    .addComponent(phoneLabel))
                                .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(rootPanelLayout.createSequentialGroup()
                                        .addGap(306, 306, 306)
                                        .addComponent(addressLabel))
                                    .addGroup(rootPanelLayout.createSequentialGroup()
                                        .addGap(81, 81, 81)
                                        .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(phoneField, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(36, 36, 36)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE))
                    .addGroup(rootPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 120, Short.MAX_VALUE)
                        .addComponent(clearTableButton, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80)
                        .addComponent(invoiceDashButton)
                        .addGap(79, 79, 79)
                        .addComponent(orderHistoryButton)
                        .addGap(136, 136, 136)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rootPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addButton)
                .addGap(40, 40, 40)
                .addComponent(updateButton)
                .addGap(44, 44, 44)
                .addComponent(showAllButton)
                .addGap(45, 45, 45)
                .addComponent(clearButton)
                .addGap(169, 169, 169))
        );
        rootPanelLayout.setVerticalGroup(
            rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rootPanelLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(rootPanelLayout.createSequentialGroup()
                        .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CustomerSearchLabel)
                            .addComponent(customerSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2)
                        .addComponent(addressLabel)
                        .addGap(0, 0, 0)
                        .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(idLabel))
                        .addGap(33, 33, 33)
                        .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nameLabel)
                            .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phoneLabel)
                    .addComponent(phoneField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton)
                    .addComponent(updateButton)
                    .addComponent(showAllButton)
                    .addComponent(clearButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(invoiceDashButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(orderHistoryButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clearTableButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(rootPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rootPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void orderHistoryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderHistoryButtonActionPerformed
        if (customerTable.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Select customer row before proceeding");
            return;
        }

        var orderHistoryForm = new OrderHistoryForm(Integer.parseInt(idField.getText()));
        orderHistoryForm.setVisible(true);
        orderHistoryForm.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // Add orderHistory form to subForm list
        LoginForm.subForms.add(orderHistoryForm);
    }//GEN-LAST:event_orderHistoryButtonActionPerformed

    private void invoiceDashButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invoiceDashButtonActionPerformed
        if (customerTable.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Select customer row before proceeding");
            return;
        }

        var invoiceForm = new InvoiceForm(Integer.parseInt(idField.getText()));
        invoiceForm.setVisible(true);
        invoiceForm.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // Add invoice form to subForm list
        LoginForm.subForms.add(invoiceForm);
    }//GEN-LAST:event_invoiceDashButtonActionPerformed

    private void clearTableButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearTableButtonActionPerformed
        var tableModel = (DefaultTableModel) customerTable.getModel();
        tableModel.setRowCount(0);
    }//GEN-LAST:event_clearTableButtonActionPerformed

    private void customerTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customerTableMouseClicked
        var selectedRow = customerTable.getSelectedRow();

        var tableModel = (DefaultTableModel) customerTable.getModel();
        var arr = tableModel.getDataVector();

        idField.setText(arr.elementAt(selectedRow).elementAt(0).toString());
        nameField.setText(arr.elementAt(selectedRow).elementAt(1).toString());
        phoneField.setText(arr.elementAt(selectedRow).elementAt(2).toString());
        addressArea.setText(arr.elementAt(selectedRow).elementAt(3).toString());
    }//GEN-LAST:event_customerTableMouseClicked

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        clearFields();
    }//GEN-LAST:event_clearButtonActionPerformed

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

            var tableModel = (DefaultTableModel) customerTable.getModel();

            tableModel.setValueAt(idField.getText(), selectedRow, 0);
            tableModel.setValueAt(nameField.getText(), selectedRow, 1);
            tableModel.setValueAt(phoneField.getText(), selectedRow, 2);
            tableModel.setValueAt(addressArea.getText(), selectedRow, 3);

            JOptionPane.showMessageDialog(this, "Data updated");

            clearFields();

        } catch (SQLIntegrityConstraintViolationException e) {
            JOptionPane.showMessageDialog(this, "Phone no. already exists");

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_updateButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        if (!validateData()) {
            return;
        }

        try {
            var db = new Database();

            db.insertCustomer(nameField.getText(), phoneField.getText(), addressArea.getText());

            JOptionPane.showMessageDialog(this, "Customer added");

            clearFields();

        } catch (SQLIntegrityConstraintViolationException e) {
            JOptionPane.showMessageDialog(this, "Phone no. already exists");

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_addButtonActionPerformed

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CustomerSearchLabel;
    private javax.swing.JButton addButton;
    private javax.swing.JTextArea addressArea;
    private javax.swing.JLabel addressLabel;
    private javax.swing.JButton clearButton;
    private javax.swing.JButton clearTableButton;
    private javax.swing.JTextField customerSearchField;
    private javax.swing.JTable customerTable;
    private javax.swing.JTextField idField;
    private javax.swing.JLabel idLabel;
    private javax.swing.JButton invoiceDashButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JButton orderHistoryButton;
    private javax.swing.JTextField phoneField;
    private javax.swing.JLabel phoneLabel;
    private javax.swing.JPanel rootPanel;
    private javax.swing.JButton showAllButton;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
