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
        updateButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        customerSearchField = new javax.swing.JTextField();
        phoneField = new javax.swing.JTextField();
        idLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        showAllButton = new javax.swing.JButton();
        orderHistoryButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        customerTable = new javax.swing.JTable();
        CustomerSearchLabel = new javax.swing.JLabel();
        phoneLabel = new javax.swing.JLabel();
        invoiceDashButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        addressArea = new javax.swing.JTextArea();
        clearTableButton = new javax.swing.JButton();
        nameField = new javax.swing.JTextField();
        addressLabel = new javax.swing.JLabel();
        removeButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        idField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        updateButton.setText("Update");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        customerSearchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                customerSearchFieldKeyReleased(evt);
            }
        });

        idLabel.setText("ID");

        nameLabel.setText("Name");

        showAllButton.setText("Show All");
        showAllButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showAllButtonActionPerformed(evt);
            }
        });

        orderHistoryButton.setText("Order History");

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

        CustomerSearchLabel.setText("Search Customer");

        phoneLabel.setText("Phone");

        invoiceDashButton.setText("Invoice Dashboard");
        invoiceDashButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invoiceDashButtonActionPerformed(evt);
            }
        });

        addressArea.setColumns(20);
        addressArea.setRows(5);
        jScrollPane1.setViewportView(addressArea);

        clearTableButton.setText("Clear Table");
        clearTableButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearTableButtonActionPerformed(evt);
            }
        });

        addressLabel.setText("Address");

        removeButton.setText("Remove");
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        clearButton.setText("Clear");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        idField.setEnabled(false);

        javax.swing.GroupLayout rootPanelLayout = new javax.swing.GroupLayout(rootPanel);
        rootPanel.setLayout(rootPanelLayout);
        rootPanelLayout.setHorizontalGroup(
            rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rootPanelLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rootPanelLayout.createSequentialGroup()
                        .addGap(228, 228, 228)
                        .addComponent(removeButton))
                    .addGroup(rootPanelLayout.createSequentialGroup()
                        .addComponent(addButton)
                        .addGap(36, 36, 36)
                        .addComponent(updateButton))
                    .addGroup(rootPanelLayout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(showAllButton)
                        .addGap(50, 50, 50)
                        .addComponent(clearButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(rootPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rootPanelLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(rootPanelLayout.createSequentialGroup()
                                .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(phoneLabel)
                                    .addComponent(nameLabel))
                                .addGap(39, 39, 39)
                                .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(phoneField, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(rootPanelLayout.createSequentialGroup()
                                .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(addressLabel)
                                    .addComponent(idLabel))
                                .addGap(27, 27, 27)
                                .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(rootPanelLayout.createSequentialGroup()
                        .addComponent(CustomerSearchLabel)
                        .addGap(18, 18, 18)
                        .addComponent(customerSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 115, Short.MAX_VALUE)
                .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rootPanelLayout.createSequentialGroup()
                        .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rootPanelLayout.createSequentialGroup()
                                .addComponent(invoiceDashButton)
                                .addGap(49, 49, 49)
                                .addComponent(orderHistoryButton))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rootPanelLayout.createSequentialGroup()
                                .addComponent(clearTableButton)
                                .addGap(113, 113, 113)))
                        .addGap(120, 120, 120))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rootPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        rootPanelLayout.setVerticalGroup(
            rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rootPanelLayout.createSequentialGroup()
                .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rootPanelLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CustomerSearchLabel)
                            .addComponent(customerSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(60, 60, 60)
                        .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(idLabel))
                        .addGap(38, 38, 38)
                        .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nameLabel)
                            .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(phoneLabel)
                            .addComponent(phoneField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(49, 49, 49)
                        .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addressLabel)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(rootPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(clearTableButton)
                        .addGap(20, 20, 20)
                        .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(orderHistoryButton)
                            .addComponent(invoiceDashButton))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updateButton)
                    .addComponent(addButton)
                    .addComponent(removeButton))
                .addGap(40, 40, 40)
                .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(showAllButton)
                    .addComponent(clearButton))
                .addGap(64, 64, 64))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rootPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(rootPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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

        var invoiceForm = new invoiceForm(Integer.parseInt(idField.getText()));
        invoiceForm.setVisible(true);
        invoiceForm.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_invoiceDashButtonActionPerformed

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