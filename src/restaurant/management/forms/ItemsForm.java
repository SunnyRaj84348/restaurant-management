package restaurant.management.forms;

import com.formdev.flatlaf.FlatDarkLaf;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import restaurant.management.models.Database;

public class ItemsForm extends javax.swing.JPanel {
    
    public ItemsForm() {
        // Set FlatLaf Dark theme
        FlatDarkLaf.setup();
        
        initComponents();
        addItemCategory();
    }
    
    private void addItemCategory() {
        try {
            var db = new Database();
            var itemCategoryList = db.getItemCategories();
            
            categoryCBox.removeAllItems();
            
            itemCategoryList.forEach(category -> {
                categoryCBox.addItem(category.itemCategoryName);
            });
            
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public boolean validateData() {
        // Check if item category list is empty
        if (categoryCBox.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Select item's category");
            return false;
        }

        // Check if name field is empty or contains only whitespaces
        if (nameField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Provide item's name");
            return false;
        }

        // Check if price format is invalid
        try {
            Double.parseDouble(priceField.getText());
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid value for price");
            return false;
        }

        // Check if price range is too large
        if (priceField.getText().length() > 6) {
            JOptionPane.showMessageDialog(this, "Price range too large");
            return false;
        }
        
        return true;
    }
    
    void clearFields() {
        nameSearchField.setText("");
        idField.setText("");
        nameField.setText("");
        priceField.setText("");
    }
    
    void showAllItems() {
        var tableModel = (DefaultTableModel) itemsTable.getModel();

        // Clear table rows
        tableModel.setRowCount(0);
        
        itemsTable.setRowSorter(null);
        
        try {
            var db = new Database();
            
            var itemList = db.getItems();
            
            if (itemList.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No item entry founded");
                return;
            }
            
            for (var item : itemList) {
                tableModel.addRow(new Object[]{
                    item.itemID, db.getCategory(item.itemCategoryID).itemCategoryName,
                    db.getCategory(item.itemCategoryID).itemCategoryType, item.itemName, item.itemPrice
                });
            }
            
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        clearButton = new javax.swing.JButton();
        categoryLabel = new javax.swing.JLabel();
        categoryRemoveButton = new javax.swing.JButton();
        newCategoryButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        nameField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        itemsTable = new javax.swing.JTable();
        headingLabel = new javax.swing.JLabel();
        priceLabel = new javax.swing.JLabel();
        nameSearchLabel = new javax.swing.JLabel();
        priceField = new javax.swing.JTextField();
        nameSearchField = new javax.swing.JTextField();
        idField = new javax.swing.JTextField();
        removeButton = new javax.swing.JButton();
        idLabel = new javax.swing.JLabel();
        showItemsButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        nameLabel = new javax.swing.JLabel();
        categoryCBox = new javax.swing.JComboBox<>();
        clearTableButton1 = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(719, 625));

        clearButton.setBackground(new java.awt.Color(0, 102, 102));
        clearButton.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        clearButton.setForeground(new java.awt.Color(255, 255, 255));
        clearButton.setText("Clear");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        categoryLabel.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        categoryLabel.setText("Category");

        categoryRemoveButton.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        categoryRemoveButton.setText("Remove");
        categoryRemoveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryRemoveButtonActionPerformed(evt);
            }
        });

        newCategoryButton.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        newCategoryButton.setText("New");
        newCategoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newCategoryButtonActionPerformed(evt);
            }
        });

        addButton.setBackground(new java.awt.Color(0, 102, 102));
        addButton.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        addButton.setForeground(new java.awt.Color(255, 255, 255));
        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ITEM LIST");

        itemsTable.setBackground(new java.awt.Color(102, 102, 102));
        itemsTable.setBorder(new javax.swing.border.MatteBorder(null));
        itemsTable.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        itemsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Category", "Type", "Name", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        itemsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                itemsTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(itemsTable);

        headingLabel.setBackground(new java.awt.Color(0, 0, 0));
        headingLabel.setFont(new java.awt.Font("Century Gothic", 1, 34)); // NOI18N
        headingLabel.setForeground(new java.awt.Color(255, 255, 255));
        headingLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headingLabel.setText("MANAGE ITEMS");

        priceLabel.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        priceLabel.setText("Price");

        nameSearchLabel.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        nameSearchLabel.setText("Search Item");

        nameSearchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nameSearchFieldKeyReleased(evt);
            }
        });

        idField.setEnabled(false);

        removeButton.setBackground(new java.awt.Color(0, 102, 102));
        removeButton.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        removeButton.setForeground(new java.awt.Color(255, 255, 255));
        removeButton.setText("Remove");
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        idLabel.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        idLabel.setText("ID");

        showItemsButton.setBackground(new java.awt.Color(0, 102, 102));
        showItemsButton.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        showItemsButton.setForeground(new java.awt.Color(255, 255, 255));
        showItemsButton.setText("Show All");
        showItemsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showItemsButtonActionPerformed(evt);
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

        nameLabel.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        nameLabel.setText("Name");

        categoryCBox.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        categoryCBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        categoryCBox.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                categoryCBoxPopupMenuWillBecomeVisible(evt);
            }
        });

        clearTableButton1.setBackground(new java.awt.Color(0, 102, 102));
        clearTableButton1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        clearTableButton1.setForeground(new java.awt.Color(255, 255, 255));
        clearTableButton1.setText("Clear Table ");
        clearTableButton1.setPreferredSize(new java.awt.Dimension(101, 22));
        clearTableButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearTableButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(headingLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 694, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(96, Short.MAX_VALUE)
                .addComponent(addButton)
                .addGap(34, 34, 34)
                .addComponent(updateButton)
                .addGap(34, 34, 34)
                .addComponent(removeButton)
                .addGap(34, 34, 34)
                .addComponent(showItemsButton)
                .addGap(34, 34, 34)
                .addComponent(clearButton)
                .addGap(111, 111, 111))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nameLabel)
                                    .addComponent(priceLabel))
                                .addGap(93, 93, 93)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(priceField, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(idLabel)
                                    .addComponent(categoryLabel)
                                    .addComponent(nameSearchLabel))
                                .addGap(59, 59, 59)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(categoryCBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(newCategoryButton)
                                        .addGap(12, 12, 12)
                                        .addComponent(categoryRemoveButton))
                                    .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nameSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(306, 306, 306)
                        .addComponent(clearTableButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(headingLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nameSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nameSearchLabel)
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(categoryLabel)
                            .addComponent(categoryCBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(newCategoryButton)
                            .addComponent(categoryRemoveButton))))
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
                    .addComponent(priceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(priceLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(updateButton)
                        .addComponent(addButton))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(showItemsButton)
                        .addComponent(clearButton))
                    .addComponent(removeButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(clearTableButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        clearFields();
    }//GEN-LAST:event_clearButtonActionPerformed
    
    private void newCategoryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newCategoryButtonActionPerformed
        var categoryForm = new ItemCategoryForm();
        categoryForm.setVisible(true);
        categoryForm.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // Add category form to subForm list
        LoginForm.subForms.add(categoryForm);
    }//GEN-LAST:event_newCategoryButtonActionPerformed
    
    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        if (!validateData()) {
            return;
        }
        
        try {
            var db = new Database();
            
            db.insertItem(
                    nameField.getText(), categoryCBox.getSelectedItem().toString(),
                    Double.parseDouble(priceField.getText())
            );
            
            clearFields();
            
            JOptionPane.showMessageDialog(this, "Item added");
            
        } catch (SQLIntegrityConstraintViolationException e) {
            JOptionPane.showMessageDialog(this, "Item already exists");
            
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_addButtonActionPerformed
    
    private void itemsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemsTableMouseClicked
        var selectedRow = itemsTable.getSelectedRow();
        
        categoryCBox.setSelectedItem(itemsTable.getValueAt(selectedRow, 1));
        idField.setText(itemsTable.getValueAt(selectedRow, 0).toString());
        nameField.setText(itemsTable.getValueAt(selectedRow, 3).toString());
        priceField.setText(itemsTable.getValueAt(selectedRow, 4).toString());
    }//GEN-LAST:event_itemsTableMouseClicked
    
    private void nameSearchFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameSearchFieldKeyReleased
        showAllItems();
        
        var tableModel = (DefaultTableModel) itemsTable.getModel();
        var sorter = new TableRowSorter<>(tableModel);
        
        itemsTable.setRowSorter(sorter);
        
        var text = nameSearchField.getText();
        
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
    }//GEN-LAST:event_nameSearchFieldKeyReleased
    
    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        var selectedRows = itemsTable.getSelectedRows();
        
        if (selectedRows.length == 0) {
            JOptionPane.showMessageDialog(this, "Select item row before deleting");
            return;
        }
        
        try {
            var db = new Database();
            
            for (var i = 0; i < selectedRows.length; i++) {
                var itemID = Integer.parseInt(itemsTable.getValueAt(selectedRows[i] - i, 0).toString());
                db.removeItem(itemID);
                
                var tableModel = (DefaultTableModel) itemsTable.getModel();
                var arr = tableModel.getDataVector();
                
                for (int row = 0; row < arr.size(); row++) {
                    if (arr.elementAt(row).elementAt(0).equals(itemID)) {
                        tableModel.removeRow(row);
                    }
                }
            }
            
            clearFields();
            
            JOptionPane.showMessageDialog(this, "Item Removed");
            
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_removeButtonActionPerformed
    
    private void showItemsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showItemsButtonActionPerformed
        showAllItems();
    }//GEN-LAST:event_showItemsButtonActionPerformed
    
    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        var selectedRow = itemsTable.getSelectedRow();
        
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Select item row before updating");
            return;
        }
        
        if (!validateData()) {
            return;
        }
        
        try {
            var db = new Database();
            
            db.updateItem(
                    Integer.parseInt(idField.getText()), nameField.getText(),
                    categoryCBox.getSelectedItem().toString(), Double.parseDouble(priceField.getText())
            );
            
            itemsTable.setValueAt(categoryCBox.getSelectedItem(), selectedRow, 1);
            itemsTable.setValueAt(db.getCategory(categoryCBox.getSelectedItem().toString()).itemCategoryType, selectedRow, 2);
            itemsTable.setValueAt(nameField.getText(), selectedRow, 3);
            itemsTable.setValueAt(priceField.getText(), selectedRow, 4);
            
            JOptionPane.showMessageDialog(this, "Item Updated");
            
        } catch (SQLIntegrityConstraintViolationException e) {
            JOptionPane.showMessageDialog(this, "Item already exists");
            
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_updateButtonActionPerformed
    
    private void categoryCBoxPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_categoryCBoxPopupMenuWillBecomeVisible
        addItemCategory();
    }//GEN-LAST:event_categoryCBoxPopupMenuWillBecomeVisible
    
    private void clearTableButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearTableButton1ActionPerformed
        var tableModel = (DefaultTableModel) itemsTable.getModel();
        tableModel.setRowCount(0);
    }//GEN-LAST:event_clearTableButton1ActionPerformed
    
    private void categoryRemoveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryRemoveButtonActionPerformed
        if (categoryCBox.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Select category to be removed");
            return;
        }
        
        try {
            var db = new Database();
            db.removeCategory(categoryCBox.getSelectedItem().toString());
            
            categoryCBox.removeItemAt(categoryCBox.getSelectedIndex());
            
        } catch (SQLIntegrityConstraintViolationException e) {
            JOptionPane.showMessageDialog(this, "One or more item exist under this category");
            
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_categoryRemoveButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JComboBox<String> categoryCBox;
    private javax.swing.JLabel categoryLabel;
    private javax.swing.JButton categoryRemoveButton;
    private javax.swing.JButton clearButton;
    private javax.swing.JButton clearTableButton1;
    private javax.swing.JLabel headingLabel;
    private javax.swing.JTextField idField;
    private javax.swing.JLabel idLabel;
    private javax.swing.JTable itemsTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameSearchField;
    private javax.swing.JLabel nameSearchLabel;
    private javax.swing.JButton newCategoryButton;
    private javax.swing.JTextField priceField;
    private javax.swing.JLabel priceLabel;
    private javax.swing.JButton removeButton;
    private javax.swing.JButton showItemsButton;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
