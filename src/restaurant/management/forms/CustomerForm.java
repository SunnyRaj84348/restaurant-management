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
        jPanel1 = new javax.swing.JPanel();
        CustomerSearchLabel = new javax.swing.JLabel();
        customerSearchField = new javax.swing.JTextField();
        idLabel = new javax.swing.JLabel();
        idField = new javax.swing.JTextField();
        nameLabel = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        phoneLabel = new javax.swing.JLabel();
        phoneField = new javax.swing.JTextField();
        addressLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        addressArea = new javax.swing.JTextArea();
        addButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        showAllButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        customerTable = new javax.swing.JTable();
        clearTableButton = new javax.swing.JButton();
        invoiceDashButton = new javax.swing.JButton();
        orderHistoryButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        CustomerSearchLabel.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        CustomerSearchLabel.setText("Search Customer");

        customerSearchField.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        customerSearchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                customerSearchFieldKeyReleased(evt);
            }
        });

        idLabel.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        idLabel.setText("ID");

        idField.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        idField.setEnabled(false);

        nameLabel.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        nameLabel.setText("Name");

        nameField.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        phoneLabel.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        phoneLabel.setText("Phone");

        phoneField.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        addressLabel.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        addressLabel.setText("Address");

        addressArea.setColumns(20);
        addressArea.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        addressArea.setRows(5);
        jScrollPane1.setViewportView(addressArea);

        addButton.setBackground(new java.awt.Color(0, 102, 102));
        addButton.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        addButton.setForeground(new java.awt.Color(255, 255, 255));
        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        updateButton.setBackground(new java.awt.Color(0, 102, 102));
        updateButton.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        updateButton.setForeground(new java.awt.Color(255, 255, 255));
        updateButton.setText("Update");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        removeButton.setBackground(new java.awt.Color(0, 102, 102));
        removeButton.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        removeButton.setForeground(new java.awt.Color(255, 255, 255));
        removeButton.setText("Remove");
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
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

        clearButton.setBackground(new java.awt.Color(0, 102, 102));
        clearButton.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        clearButton.setForeground(new java.awt.Color(255, 255, 255));
        clearButton.setText("Clear");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
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

        clearTableButton.setBackground(new java.awt.Color(0, 102, 102));
        clearTableButton.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        clearTableButton.setForeground(new java.awt.Color(255, 255, 255));
        clearTableButton.setText("Clear Table");
        clearTableButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearTableButtonActionPerformed(evt);
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

        orderHistoryButton.setBackground(new java.awt.Color(0, 102, 102));
        orderHistoryButton.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        orderHistoryButton.setForeground(new java.awt.Color(255, 255, 255));
        orderHistoryButton.setText("Order History");
        orderHistoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderHistoryButtonActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Add or Search Customer");

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Customers Data");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(CustomerSearchLabel)
                                .addGap(31, 31, 31)
                                .addComponent(customerSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(idLabel)
                                    .addComponent(nameLabel)
                                    .addComponent(phoneLabel))
                                .addGap(75, 75, 75)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(idField, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                                    .addComponent(nameField)
                                    .addComponent(phoneField))
                                .addGap(73, 73, 73)
                                .addComponent(addressLabel)))
                        .addGap(36, 36, 36)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(addButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(updateButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removeButton)
                        .addGap(18, 18, 18)
                        .addComponent(showAllButton)
                        .addGap(18, 18, 18)
                        .addComponent(clearButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(120, Short.MAX_VALUE)
                .addComponent(clearTableButton, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(invoiceDashButton)
                .addGap(97, 97, 97)
                .addComponent(orderHistoryButton)
                .addGap(136, 136, 136))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CustomerSearchLabel)
                            .addComponent(customerSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(idLabel)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(addressLabel))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phoneLabel)
                    .addComponent(phoneField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton)
                    .addComponent(updateButton)
                    .addComponent(removeButton)
                    .addComponent(showAllButton)
                    .addComponent(clearButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(invoiceDashButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(orderHistoryButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clearTableButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout rootPanelLayout = new javax.swing.GroupLayout(rootPanel);
        rootPanel.setLayout(rootPanelLayout);
        rootPanelLayout.setHorizontalGroup(
            rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rootPanelLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        rootPanelLayout.setVerticalGroup(
            rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rootPanelLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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

    private void showAllButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showAllButtonActionPerformed
        showAllCustomers();
    }//GEN-LAST:event_showAllButtonActionPerformed

    private void customerTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customerTableMouseClicked
        var selectedRow = customerTable.getSelectedRow();

        var tableModel = (DefaultTableModel) customerTable.getModel();
        var arr = tableModel.getDataVector();

        idField.setText(arr.elementAt(selectedRow).elementAt(0).toString());
        nameField.setText(arr.elementAt(selectedRow).elementAt(1).toString());
        phoneField.setText(arr.elementAt(selectedRow).elementAt(2).toString());
        addressArea.setText(arr.elementAt(selectedRow).elementAt(3).toString());
    }//GEN-LAST:event_customerTableMouseClicked

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

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        var selectedRows = customerTable.getSelectedRows();

        if (selectedRows.length == 0) {
            JOptionPane.showMessageDialog(this, "Select Customer row before deleting");
            return;
        }

        try {
            var db = new Database();

            for (var i = 0; i <= selectedRows.length - i; i++) {
                var id = Integer.parseInt(customerTable.getValueAt(selectedRows[i] - i, 0).toString());
                db.removeCustomer(id);

                var tableModel = (DefaultTableModel) customerTable.getModel();

                tableModel.removeRow(selectedRows[i] - i);
            }

            JOptionPane.showMessageDialog(this, "Customer entry deleted");
            clearFields();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_removeButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        clearFields();
    }//GEN-LAST:event_clearButtonActionPerformed

    private void clearTableButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearTableButtonActionPerformed
        var tableModel = (DefaultTableModel) customerTable.getModel();
        tableModel.setRowCount(0);
    }//GEN-LAST:event_clearTableButtonActionPerformed

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

    private void invoiceDashButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invoiceDashButtonActionPerformed
        if (customerTable.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Select customer row before proceeding");
            return;
        }

        var invoiceForm = new InvoiceForm(Integer.parseInt(idField.getText()));
        invoiceForm.setVisible(true);
        invoiceForm.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_invoiceDashButtonActionPerformed

    private void orderHistoryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderHistoryButtonActionPerformed
        if (customerTable.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Select customer row before proceeding");
            return;
        }

        var orderHistoryForm = new OrderHistoryForm(Integer.parseInt(idField.getText()));
        orderHistoryForm.setVisible(true);
        orderHistoryForm.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_orderHistoryButtonActionPerformed

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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JButton orderHistoryButton;
    private javax.swing.JTextField phoneField;
    private javax.swing.JLabel phoneLabel;
    private javax.swing.JButton removeButton;
    private javax.swing.JPanel rootPanel;
    private javax.swing.JButton showAllButton;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
