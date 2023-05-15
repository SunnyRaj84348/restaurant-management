package restaurant.management.forms;

import com.formdev.flatlaf.FlatDarkLaf;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import restaurant.management.models.Database;

public class InvoiceForm extends javax.swing.JFrame {
    
    private int customerID;
    
    public InvoiceForm(int customerID) {
        // Set FlatLaf Dark theme
        FlatDarkLaf.setup();
        
        initComponents();
        
        this.customerID = customerID;
        
        initFields();
        showAllItems();
    }
    
    private void initFields() {
        try {
            var db = new Database();
            
            var customer = db.getCustomer(customerID);
            customerNameField.setText(customer.customerName);
            
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        dateField.setText(LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
    }
    
    void showAllItems() {
        var tableModel = (DefaultTableModel) itemsTable.getModel();

        // Clear table rows
        tableModel.setRowCount(0);
        
        try {
            var db = new Database();
            
            var itemList = db.getItems();
            
            for (var item : itemList) {
                tableModel.addRow(new Object[]{
                    item.itemName, db.getCategory(item.itemCategoryID).itemCategoryName,
                    db.getCategory(item.itemCategoryID).itemCategoryType, item.itemPrice
                });
            }
            
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    boolean validateData(JTextField quantityField) {
        if (quantityField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter item quantity");
            return false;
        }
        
        try {
            var quantity = Integer.parseInt(quantityField.getText());
            
            if (quantity < 0) {
                JOptionPane.showMessageDialog(this, "Invalid quantity value");
                return false;
            }
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid quantity value");
            return false;
        }
        
        return true;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rootPanel = new javax.swing.JPanel();
        itemAddButton = new javax.swing.JButton();
        customerNameLabel = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        itemsTable = new javax.swing.JTable();
        itemSearchField = new javax.swing.JTextField();
        itemQtLabel = new javax.swing.JLabel();
        dateField = new javax.swing.JTextField();
        itemSearchLabel = new javax.swing.JLabel();
        customerNameField = new javax.swing.JTextField();
        itemQtField = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        cartTable = new javax.swing.JTable();
        cartItemQtLabel = new javax.swing.JLabel();
        cartItemQtField = new javax.swing.JTextField();
        itemQtUpdateButton = new javax.swing.JButton();
        cartItemRemoveButton = new javax.swing.JButton();
        cartLabel = new javax.swing.JLabel();
        genInvoiceButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        invoiceArea = new javax.swing.JTextArea();
        clearButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        itemAddButton.setBackground(new java.awt.Color(0, 102, 102));
        itemAddButton.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        itemAddButton.setForeground(new java.awt.Color(255, 255, 255));
        itemAddButton.setText("Add");
        itemAddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemAddButtonActionPerformed(evt);
            }
        });

        customerNameLabel.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        customerNameLabel.setText("Customer Name");

        dateLabel.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        dateLabel.setText("Order Date");

        itemsTable.setBackground(new java.awt.Color(102, 102, 102));
        itemsTable.setBorder(new javax.swing.border.MatteBorder(null));
        itemsTable.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        itemsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Category", "Type", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(itemsTable);

        itemSearchField.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        itemSearchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                itemSearchFieldKeyReleased(evt);
            }
        });

        itemQtLabel.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        itemQtLabel.setText("Quantity");

        dateField.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        dateField.setEnabled(false);

        itemSearchLabel.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        itemSearchLabel.setText("Search Item");

        customerNameField.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        customerNameField.setEnabled(false);

        itemQtField.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        cartTable.setBackground(new java.awt.Color(102, 102, 102));
        cartTable.setBorder(new javax.swing.border.MatteBorder(null));
        cartTable.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        cartTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item Name", "Price", "Quantity", "Total Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(cartTable);

        cartItemQtLabel.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        cartItemQtLabel.setText("Quantity");

        cartItemQtField.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        itemQtUpdateButton.setBackground(new java.awt.Color(0, 102, 102));
        itemQtUpdateButton.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        itemQtUpdateButton.setForeground(new java.awt.Color(255, 255, 255));
        itemQtUpdateButton.setText("Update");
        itemQtUpdateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemQtUpdateButtonActionPerformed(evt);
            }
        });

        cartItemRemoveButton.setBackground(new java.awt.Color(0, 102, 102));
        cartItemRemoveButton.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        cartItemRemoveButton.setForeground(new java.awt.Color(255, 255, 255));
        cartItemRemoveButton.setText("Remove");
        cartItemRemoveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cartItemRemoveButtonActionPerformed(evt);
            }
        });

        cartLabel.setBackground(new java.awt.Color(0, 0, 0));
        cartLabel.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        cartLabel.setForeground(new java.awt.Color(255, 255, 255));
        cartLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cartLabel.setText("CART");

        genInvoiceButton.setBackground(new java.awt.Color(0, 102, 102));
        genInvoiceButton.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        genInvoiceButton.setForeground(new java.awt.Color(255, 255, 255));
        genInvoiceButton.setText("Generate Invoice");
        genInvoiceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genInvoiceButtonActionPerformed(evt);
            }
        });

        invoiceArea.setColumns(20);
        invoiceArea.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        invoiceArea.setRows(5);
        jScrollPane3.setViewportView(invoiceArea);

        clearButton.setBackground(new java.awt.Color(0, 102, 102));
        clearButton.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        clearButton.setForeground(new java.awt.Color(255, 255, 255));
        clearButton.setText("Clear");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout rootPanelLayout = new javax.swing.GroupLayout(rootPanel);
        rootPanel.setLayout(rootPanelLayout);
        rootPanelLayout.setHorizontalGroup(
            rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rootPanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rootPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(rootPanelLayout.createSequentialGroup()
                        .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(rootPanelLayout.createSequentialGroup()
                                .addGap(71, 71, 71)
                                .addComponent(itemQtLabel)
                                .addGap(18, 18, 18)
                                .addComponent(itemQtField, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(itemAddButton))
                            .addGroup(rootPanelLayout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(rootPanelLayout.createSequentialGroup()
                                        .addComponent(dateLabel)
                                        .addGap(18, 18, 18)
                                        .addComponent(dateField, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(rootPanelLayout.createSequentialGroup()
                                        .addComponent(itemSearchLabel)
                                        .addGap(18, 18, 18)
                                        .addComponent(itemSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(rootPanelLayout.createSequentialGroup()
                                .addGap(277, 277, 277)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cartLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(273, 273, 273))
                    .addGroup(rootPanelLayout.createSequentialGroup()
                        .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(rootPanelLayout.createSequentialGroup()
                                .addGap(249, 249, 249)
                                .addComponent(customerNameLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(customerNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(rootPanelLayout.createSequentialGroup()
                                .addGap(365, 365, 365)
                                .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cartItemQtLabel)
                                    .addComponent(genInvoiceButton, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addComponent(cartItemQtField, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(itemQtUpdateButton)
                                .addGap(18, 18, 18)
                                .addComponent(cartItemRemoveButton)
                                .addGap(20, 20, 20)
                                .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        rootPanelLayout.setVerticalGroup(
            rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rootPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dateLabel)
                    .addComponent(dateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(customerNameLabel)
                    .addComponent(customerNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rootPanelLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(itemSearchLabel)
                            .addComponent(itemSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(rootPanelLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(cartLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23)
                .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rootPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(itemQtLabel)
                            .addComponent(itemQtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(itemAddButton)
                            .addComponent(cartItemQtLabel)
                            .addComponent(cartItemQtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(itemQtUpdateButton)
                            .addComponent(cartItemRemoveButton)
                            .addComponent(clearButton)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(genInvoiceButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(rootPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 931, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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

    private void itemSearchFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_itemSearchFieldKeyReleased
        var tableModel = (DefaultTableModel) itemsTable.getModel();
        var sorter = new TableRowSorter<>(tableModel);
        
        itemsTable.setRowSorter(sorter);
        
        var text = itemSearchField.getText();
        
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
    }//GEN-LAST:event_itemSearchFieldKeyReleased
    
    private void itemAddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAddButtonActionPerformed
        int selectedRow = itemsTable.getSelectedRow();
        
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Select item row before adding to cart");
            return;
        }
        
        if (!validateData(itemQtField)) {
            return;
        }
        
        var name = itemsTable.getValueAt(selectedRow, 0).toString();
        var price = Double.parseDouble(itemsTable.getValueAt(selectedRow, 3).toString());
        var quantity = Integer.parseInt(itemQtField.getText());
        
        var tableModel = (DefaultTableModel) cartTable.getModel();
        var arr = tableModel.getDataVector();

        // Append item quantity if item already exists in cart
        for (var i = 0; i < arr.size(); i++) {
            if (arr.elementAt(i).elementAt(0).toString().equals(name)) {
                var currentQuantity = Integer.parseInt(arr.elementAt(i).elementAt(2).toString());
                
                tableModel.setValueAt((currentQuantity + quantity), i, 2);
                tableModel.setValueAt((currentQuantity + quantity) * price, i, 3);
                
                return;
            }
        }
        
        tableModel.addRow(new Object[]{
            itemsTable.getValueAt(selectedRow, 0),
            price,
            quantity,
            price * quantity
        });
    }//GEN-LAST:event_itemAddButtonActionPerformed
    
    private void itemQtUpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemQtUpdateButtonActionPerformed
        int selectedRow = cartTable.getSelectedRow();
        
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Select item row before updating quantity");
            return;
        }
        
        if (!validateData(cartItemQtField)) {
            return;
        }
        
        var newQuantity = Integer.parseInt(cartItemQtField.getText());
        var price = Double.parseDouble(cartTable.getValueAt(selectedRow, 1).toString());
        
        if (newQuantity == 0) {
            var tableModel = (DefaultTableModel) cartTable.getModel();
            tableModel.removeRow(selectedRow);
            
        } else {
            cartTable.setValueAt(newQuantity, selectedRow, 2);
            cartTable.setValueAt(newQuantity * price, selectedRow, 3);
        }
    }//GEN-LAST:event_itemQtUpdateButtonActionPerformed
    
    private void cartItemRemoveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cartItemRemoveButtonActionPerformed
        var selectedRows = cartTable.getSelectedRows();
        
        if (selectedRows.length == 0) {
            JOptionPane.showMessageDialog(this, "Select item row before removing");
            return;
        }

        // Remove selected items from cart
        for (var i = 0; i < selectedRows.length; i++) {
            var tableModel = (DefaultTableModel) cartTable.getModel();
            tableModel.removeRow(selectedRows[i] - i);
        }
    }//GEN-LAST:event_cartItemRemoveButtonActionPerformed
    
    private void genInvoiceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genInvoiceButtonActionPerformed
        if (cartTable.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Cart is empty");
            return;
        }
        
        try {
            var db = new Database();
            var orderID = db.insertOrder(customerID);
            
            var tableModel = (DefaultTableModel) cartTable.getModel();
            var arr = tableModel.getDataVector();

            // Insert each item from cart
            for (var item : arr) {
                var itemName = item.elementAt(0).toString();
                var quantity = Integer.parseInt(item.elementAt(2).toString());
                
                db.insertOrderItem(orderID, itemName, quantity);
            }
            
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_genInvoiceButtonActionPerformed
    
    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        var tableModel = (DefaultTableModel) cartTable.getModel();
        tableModel.setRowCount(0);
    }//GEN-LAST:event_clearButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cartItemQtField;
    private javax.swing.JLabel cartItemQtLabel;
    private javax.swing.JButton cartItemRemoveButton;
    private javax.swing.JLabel cartLabel;
    private javax.swing.JTable cartTable;
    private javax.swing.JButton clearButton;
    private javax.swing.JTextField customerNameField;
    private javax.swing.JLabel customerNameLabel;
    private javax.swing.JTextField dateField;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JButton genInvoiceButton;
    private javax.swing.JTextArea invoiceArea;
    private javax.swing.JButton itemAddButton;
    private javax.swing.JTextField itemQtField;
    private javax.swing.JLabel itemQtLabel;
    private javax.swing.JButton itemQtUpdateButton;
    private javax.swing.JTextField itemSearchField;
    private javax.swing.JLabel itemSearchLabel;
    private javax.swing.JTable itemsTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel rootPanel;
    // End of variables declaration//GEN-END:variables
}
