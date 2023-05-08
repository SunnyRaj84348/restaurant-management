package restaurant.management.forms;

import com.formdev.flatlaf.FlatDarkLaf;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import restaurant.management.models.Database;

public class ItemsForm extends javax.swing.JFrame {

    static String newItemcategory;

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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nameSearchLabel = new javax.swing.JLabel();
        nameSearchField = new javax.swing.JTextField();
        findButton = new javax.swing.JButton();
        categoryLabel = new javax.swing.JLabel();
        categoryCBox = new javax.swing.JComboBox<>();
        newCategoryButton = new javax.swing.JButton();
        idLabel = new javax.swing.JLabel();
        idField = new javax.swing.JTextField();
        nameLabel = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        priceLabel = new javax.swing.JLabel();
        priceField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        itemsTable = new javax.swing.JTable();
        updateButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        showItemsButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        clearTableButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        nameSearchLabel.setText("Item's Name");

        findButton.setText("Find");

        categoryLabel.setText("Category");

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

        newCategoryButton.setText("New Category");
        newCategoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newCategoryButtonActionPerformed(evt);
            }
        });

        idLabel.setText("ID");

        idField.setEnabled(false);

        nameLabel.setText("Name");

        priceLabel.setText("Price");

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

        removeButton.setText("Remove");

        showItemsButton.setText("Show All");
        showItemsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showItemsButtonActionPerformed(evt);
            }
        });

        clearButton.setText("Clear");

        clearTableButton.setText("Clear Table");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(idLabel)
                                    .addComponent(nameLabel)
                                    .addComponent(priceLabel)
                                    .addComponent(categoryLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(36, 36, 36))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(nameSearchLabel)
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(nameSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(findButton))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(categoryCBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(newCategoryButton))
                            .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(priceField, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(addButton)
                                .addGap(18, 18, 18)
                                .addComponent(updateButton)
                                .addGap(18, 18, 18)
                                .addComponent(removeButton))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(showItemsButton)
                                .addGap(42, 42, 42)
                                .addComponent(clearButton)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(clearTableButton)
                        .addGap(248, 248, 248))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameSearchLabel)
                    .addComponent(nameSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(findButton))
                .addGap(72, 72, 72)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(categoryCBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(categoryLabel)
                    .addComponent(newCategoryButton))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updateButton)
                    .addComponent(removeButton)
                    .addComponent(addButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(showItemsButton)
                    .addComponent(clearButton))
                .addGap(84, 84, 84))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(clearTableButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void newCategoryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newCategoryButtonActionPerformed
        var categoryForm = new ItemCategoryForm();
        categoryForm.setVisible(true);
        categoryForm.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_newCategoryButtonActionPerformed

    private void categoryCBoxPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_categoryCBoxPopupMenuWillBecomeVisible
        if (newItemcategory != null) {
            categoryCBox.addItem(newItemcategory);
            newItemcategory = null;
        }
    }//GEN-LAST:event_categoryCBoxPopupMenuWillBecomeVisible

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

            JOptionPane.showMessageDialog(this, "Item added");

        } catch (SQLIntegrityConstraintViolationException e) {
            JOptionPane.showMessageDialog(this, "Item already exists");

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_addButtonActionPerformed

    private void showItemsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showItemsButtonActionPerformed
        var tableModel = (DefaultTableModel) itemsTable.getModel();

        // Clear table rows
        tableModel.setRowCount(0);

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

    }//GEN-LAST:event_showItemsButtonActionPerformed

    private void itemsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemsTableMouseClicked
        var selectedRow = itemsTable.getSelectedRow();

        var tableModel = (DefaultTableModel) itemsTable.getModel();
        var arr = tableModel.getDataVector();

        categoryCBox.setSelectedItem(arr.elementAt(selectedRow).elementAt(1));
        idField.setText(arr.elementAt(selectedRow).elementAt(0).toString());
        nameField.setText(arr.elementAt(selectedRow).elementAt(3).toString());
        priceField.setText(arr.elementAt(selectedRow).elementAt(4).toString());
    }//GEN-LAST:event_itemsTableMouseClicked

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        if (idField.getText().isEmpty()) {
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

            var tableModel = (DefaultTableModel) itemsTable.getModel();
            var selectedRow = itemsTable.getSelectedRow();

            tableModel.setValueAt(categoryCBox.getSelectedItem(), selectedRow, 1);
            tableModel.setValueAt(db.getCategory(categoryCBox.getSelectedItem().toString()).itemCategoryType, selectedRow, 2);
            tableModel.setValueAt(nameField.getText(), selectedRow, 3);
            tableModel.setValueAt(priceField.getText(), selectedRow, 4);

            JOptionPane.showMessageDialog(this, "Item Updated");

        } catch (SQLIntegrityConstraintViolationException e) {
            JOptionPane.showMessageDialog(this, "Item already exists");

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_updateButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JComboBox<String> categoryCBox;
    private javax.swing.JLabel categoryLabel;
    private javax.swing.JButton clearButton;
    private javax.swing.JButton clearTableButton;
    private javax.swing.JButton findButton;
    private javax.swing.JTextField idField;
    private javax.swing.JLabel idLabel;
    private javax.swing.JTable itemsTable;
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
