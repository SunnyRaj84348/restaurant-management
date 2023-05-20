package restaurant.management.forms;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import restaurant.management.models.Database;

public class InvoiceForm extends javax.swing.JPanel {

    int customerID;

    public InvoiceForm(int customerID) {
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

        itemQtField = new javax.swing.JTextField();
        dateField = new javax.swing.JTextField();
        cartItemQtLabel = new javax.swing.JLabel();
        itemQtLabel = new javax.swing.JLabel();
        clearButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        cartTable = new javax.swing.JTable();
        itemQtUpdateButton = new javax.swing.JButton();
        cartItemQtField = new javax.swing.JTextField();
        dateLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        itemsTable = new javax.swing.JTable();
        genInvoiceButton = new javax.swing.JButton();
        itemSearchLabel = new javax.swing.JLabel();
        cartItemRemoveButton = new javax.swing.JButton();
        customerNameLabel = new javax.swing.JLabel();
        customerNameField = new javax.swing.JTextField();
        itemAddButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        invoiceArea = new javax.swing.JTextArea();
        itemSearchField = new javax.swing.JTextField();
        cartLabel = new javax.swing.JLabel();
        headingLabel = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(980, 720));

        itemQtField.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        itemQtField.setText("1");

        dateField.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        dateField.setEnabled(false);

        cartItemQtLabel.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        cartItemQtLabel.setText("Quantity");

        itemQtLabel.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        itemQtLabel.setText("Quantity");

        clearButton.setBackground(new java.awt.Color(0, 102, 102));
        clearButton.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        clearButton.setForeground(new java.awt.Color(255, 255, 255));
        clearButton.setText("Clear");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

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
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        cartTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cartTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(cartTable);

        itemQtUpdateButton.setBackground(new java.awt.Color(0, 102, 102));
        itemQtUpdateButton.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        itemQtUpdateButton.setForeground(new java.awt.Color(255, 255, 255));
        itemQtUpdateButton.setText("Update");
        itemQtUpdateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemQtUpdateButtonActionPerformed(evt);
            }
        });

        cartItemQtField.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

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
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        itemsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                itemsTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(itemsTable);

        genInvoiceButton.setBackground(new java.awt.Color(0, 102, 102));
        genInvoiceButton.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        genInvoiceButton.setForeground(new java.awt.Color(255, 255, 255));
        genInvoiceButton.setText("Generate Invoice");
        genInvoiceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genInvoiceButtonActionPerformed(evt);
            }
        });

        itemSearchLabel.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        itemSearchLabel.setText("Search Item");

        cartItemRemoveButton.setBackground(new java.awt.Color(0, 102, 102));
        cartItemRemoveButton.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        cartItemRemoveButton.setForeground(new java.awt.Color(255, 255, 255));
        cartItemRemoveButton.setText("Remove");
        cartItemRemoveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cartItemRemoveButtonActionPerformed(evt);
            }
        });

        customerNameLabel.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        customerNameLabel.setText("Customer Name");

        customerNameField.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        customerNameField.setEnabled(false);

        itemAddButton.setBackground(new java.awt.Color(0, 102, 102));
        itemAddButton.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        itemAddButton.setForeground(new java.awt.Color(255, 255, 255));
        itemAddButton.setText("Add");
        itemAddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemAddButtonActionPerformed(evt);
            }
        });

        invoiceArea.setColumns(20);
        invoiceArea.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        invoiceArea.setRows(5);
        jScrollPane3.setViewportView(invoiceArea);

        itemSearchField.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        itemSearchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                itemSearchFieldKeyReleased(evt);
            }
        });

        cartLabel.setBackground(new java.awt.Color(0, 0, 0));
        cartLabel.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        cartLabel.setForeground(new java.awt.Color(255, 255, 255));
        cartLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cartLabel.setText("CART");

        headingLabel.setBackground(new java.awt.Color(0, 0, 0));
        headingLabel.setFont(new java.awt.Font("Century Gothic", 1, 32)); // NOI18N
        headingLabel.setForeground(new java.awt.Color(255, 255, 255));
        headingLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headingLabel.setText("Invoice Dashboard");

        jButton1.setBackground(new java.awt.Color(0, 102, 102));
        jButton1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Print");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(headingLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cartLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(115, 115, 115))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(145, 145, 145)
                .addComponent(itemQtLabel)
                .addGap(18, 18, 18)
                .addComponent(itemQtField, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(itemAddButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cartItemQtLabel)
                .addGap(27, 27, 27)
                .addComponent(cartItemQtField, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(itemQtUpdateButton)
                .addGap(18, 18, 18)
                .addComponent(cartItemRemoveButton)
                .addGap(20, 20, 20)
                .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(itemSearchLabel)
                            .addComponent(dateLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(dateField, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(customerNameLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(customerNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(itemSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(386, 386, 386)
                        .addComponent(genInvoiceButton)
                        .addGap(49, 49, 49)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(291, 291, 291)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(319, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(headingLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dateLabel)
                    .addComponent(dateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(customerNameLabel)
                    .addComponent(customerNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cartLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(itemSearchLabel)
                    .addComponent(itemSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(itemQtLabel)
                    .addComponent(itemQtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(itemAddButton)
                    .addComponent(cartItemQtLabel)
                    .addComponent(cartItemQtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(itemQtUpdateButton)
                    .addComponent(cartItemRemoveButton)
                    .addComponent(clearButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(genInvoiceButton)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        var tableModel = (DefaultTableModel) cartTable.getModel();
        tableModel.setRowCount(0);
    }//GEN-LAST:event_clearButtonActionPerformed

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

            var customerDeatils = db.getCustomer(customerID);
            var orderDetails = db.getOrderDetails(orderID);

            invoiceArea.setText("""
                            ************************* Yummy In The Tummy *************************
                                                                  Food Business Centre
                                                                 Bhatta Bazaar Purnea
                                                                     Tel - 06454-202122

                              Date:""" + " " + new SimpleDateFormat("dd/MM/yyyy hh:mm:ss aa").format(orderDetails.orderDate) + "\n\n  "
                    + """
                  Order ID:""" + " " + orderID + "\n\n  "
                    + """
                  Customer Name:""" + "  " + customerDeatils.customerName + "\n  "
                    + """
                  Customer Phone:""" + " " + customerDeatils.customerPhone + "\n\n"
                    + """
                  -------------------------------------------------------------------------------------------""" + "\n  "
                    + """
                  S.No""" + "\n"
                    + """
                  -------------------------------------------------------------------------------------------""" + "\n"
            );

            String str = "";
            double totalPrice = 0;

            for (int i = 0; i < arr.size(); i++) {
                totalPrice += Double.parseDouble(arr.elementAt(i).elementAt(3).toString());

                str += "   " + (i + 1) + "          " + arr.elementAt(i).elementAt(0) + "\n" + "                x" + arr.elementAt(i).elementAt(2) + " - Rs. " + arr.elementAt(i).elementAt(3) + "\n\n";
            }

            str += """
                   -------------------------------------------------------------------------------------------""" + "\n   "
                    + """
                      -           Total Price:""" + "        Rs. " + totalPrice + "\n"
                    + """
                      -------------------------------------------------------------------------------------------""" + "\n"
                    + """
                                                              Thanks For Visiting!
                      """;

            invoiceArea.setText(invoiceArea.getText() + str);

            tableModel.setRowCount(0);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_genInvoiceButtonActionPerformed

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

    private void cartTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartTableMouseClicked
        int selectedRow = cartTable.getSelectedRow();

        cartItemQtField.setText(cartTable.getValueAt(selectedRow, 2).toString());
    }//GEN-LAST:event_cartTableMouseClicked

    private void itemsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemsTableMouseClicked
        itemQtField.setText("1");
    }//GEN-LAST:event_itemsTableMouseClicked

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
    private javax.swing.JLabel headingLabel;
    private javax.swing.JTextArea invoiceArea;
    private javax.swing.JButton itemAddButton;
    private javax.swing.JTextField itemQtField;
    private javax.swing.JLabel itemQtLabel;
    private javax.swing.JButton itemQtUpdateButton;
    private javax.swing.JTextField itemSearchField;
    private javax.swing.JLabel itemSearchLabel;
    private javax.swing.JTable itemsTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
