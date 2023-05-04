package restaurant.management.forms;

import com.formdev.flatlaf.FlatDarkLaf;
import java.math.BigInteger;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import restaurant.management.models.Database;

public class EmployeeForm extends javax.swing.JFrame {

    static String roleName;

    public EmployeeForm() {
        // Set FlatLaf Dark theme
        FlatDarkLaf.setup();

        initComponents();
        addRoles();
    }

    private void addRoles() {
        try {
            var db = new Database();
            var empRoleList = db.getEmployeeRoles();

            roleCBox.removeAllItems();

            empRoleList.forEach(role -> {
                roleCBox.addItem(role.roleName);
            });

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private boolean validateData() {
        // Check if specified fields are empty or contains whitespaces
        if (nameField.getText().trim().isEmpty() || phoneField.getText().trim().isEmpty()
                || addressArea.getText().trim().isEmpty() || salaryField.getText().trim().isEmpty()) {

            JOptionPane.showMessageDialog(this, "One or more fields are empty");
            return false;
        }

        // Check username and password field based on employee's role
        if (roleCBox.getSelectedItem().equals("Admin")
                || roleCBox.getSelectedItem().equals("Receptionist")) {

            if (userField.getText().trim().isEmpty() || passwordField.getPassword().length == 0) {
                JOptionPane.showMessageDialog(this, "One or more fields are empty");
                return false;
            }
        }

        // Check phone number field length is correct
        if ((phoneField.getText().length() != 10 && phoneField.getText().length() != 12)) {
            JOptionPane.showMessageDialog(this, "Invalid phone number");
            return false;
        }

        // Check salary field lies within range
        if (salaryField.getText().length() > 10) {
            JOptionPane.showMessageDialog(this, "Salary range too large");
            return false;
        }

        // Check if specified field's value is numeric
        try {
            new BigInteger(phoneField.getText());
            new BigInteger(salaryField.getText());

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid value for phone or salary");
            return false;
        }

        return true;
    }

    void clearData() {
        idSearchField.setText("");
        userField.setText("");
        passwordField.setText("");
        idField.setText("");
        nameField.setText("");
        phoneField.setText("");
        addressArea.setText("");
        salaryField.setText("");
    }

    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        empTable = new javax.swing.JTable();
        idSearchField = new javax.swing.JTextField();
        idSearchLabel = new javax.swing.JLabel();
        findButton = new javax.swing.JButton();
        roleLabel = new javax.swing.JLabel();
        roleCBox = new javax.swing.JComboBox<>();
        passwordLabel = new javax.swing.JLabel();
        userLabel = new javax.swing.JLabel();
        userField = new javax.swing.JTextField();
        passwordField = new javax.swing.JPasswordField();
        nameLabel = new javax.swing.JLabel();
        addressLabel = new javax.swing.JLabel();
        phoneLabel = new javax.swing.JLabel();
        salaryLabel = new javax.swing.JLabel();
        salaryField = new javax.swing.JTextField();
        phoneField = new javax.swing.JTextField();
        nameField = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        addressArea = new javax.swing.JTextArea();
        addButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        idLabel = new javax.swing.JLabel();
        idField = new javax.swing.JTextField();
        newRoleButton = new javax.swing.JButton();
        showEmpButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        empTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Role", "Name", "Phone", "Address", "Salary"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(empTable);

        idSearchLabel.setText("Employee's ID");

        findButton.setText("Find");
        findButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findButtonActionPerformed(evt);
            }
        });

        roleLabel.setText("Role");

        roleCBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        roleCBox.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                roleCBoxFocusGained(evt);
            }
        });
        roleCBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roleCBoxActionPerformed(evt);
            }
        });

        passwordLabel.setText("Password");

        userLabel.setText("Username");

        nameLabel.setText("Name");

        addressLabel.setText("Address");

        phoneLabel.setText("Phone");

        salaryLabel.setText("Salary");

        addressArea.setColumns(20);
        addressArea.setRows(5);
        jScrollPane2.setViewportView(addressArea);

        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        removeButton.setText("Remove");

        updateButton.setText("Update");

        idLabel.setText("ID");

        idField.setEnabled(false);

        newRoleButton.setText("New Role");
        newRoleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newRoleButtonActionPerformed(evt);
            }
        });

        showEmpButton.setText("Show All");
        showEmpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showEmpButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(idSearchLabel)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(passwordLabel)
                        .addComponent(userLabel)
                        .addComponent(roleLabel)
                        .addComponent(idLabel)
                        .addComponent(nameLabel)
                        .addComponent(phoneLabel)
                        .addComponent(addressLabel)
                        .addComponent(salaryLabel)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(salaryField, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(806, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(roleCBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(newRoleButton))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(idSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(findButton))
                            .addComponent(userField, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(phoneField, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 597, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))))
            .addGroup(layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(addButton)
                .addGap(18, 18, 18)
                .addComponent(updateButton)
                .addGap(18, 18, 18)
                .addComponent(removeButton)
                .addGap(18, 18, 18)
                .addComponent(showEmpButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(idSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(findButton)
                            .addComponent(idSearchLabel))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(roleLabel)
                            .addComponent(roleCBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(newRoleButton))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(userLabel)
                            .addComponent(userField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(passwordLabel)
                            .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(idLabel)
                            .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(phoneField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(phoneLabel))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addressLabel))))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(salaryField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(salaryLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton)
                    .addComponent(updateButton)
                    .addComponent(removeButton)
                    .addComponent(showEmpButton))
                .addGap(42, 42, 42))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void findButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findButtonActionPerformed
        try {
            var tableModel = (DefaultTableModel) empTable.getModel();
            var tableVector = tableModel.getDataVector();

            var empID = Integer.parseInt(idSearchField.getText());

            // return if data already exists in table
            for (int i = 0; i < tableVector.size(); i++) {
                if (tableVector.elementAt(i).elementAt(0).equals(empID)) {
                    return;
                }
            }

            var db = new Database();
            var empDetails = db.getEmployeeDetails(empID);

            if (empDetails == null) {
                JOptionPane.showMessageDialog(this, "Employee not founded");
                return;
            }

            var empRole = db.getEmployeeRole(empDetails.employeeID);

            tableModel.addRow(new Object[]{
                empDetails.employeeID, empRole.roleName, empDetails.employeeName, empDetails.employeePhone,
                empDetails.employeeAddress, empDetails.employeeSalary
            });

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Employee not founded");
        }
    }//GEN-LAST:event_findButtonActionPerformed

    private void newRoleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newRoleButtonActionPerformed
        var roleForm = new RoleForm();
        roleForm.setVisible(true);
        roleForm.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_newRoleButtonActionPerformed

    private void roleCBoxFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_roleCBoxFocusGained
        if (roleName != null) {
            roleCBox.addItem(roleName);
            roleName = null;
        }
    }//GEN-LAST:event_roleCBoxFocusGained

    private void roleCBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roleCBoxActionPerformed
        // Return if event triggered without mouse click
        if (roleCBox.getSelectedItem() == null) {
            return;
        }

        var role = roleCBox.getSelectedItem().toString();

        // Enable/Disable fields based on employee's role
        if (role.equals("Admin") || role.equals("Receptionist")) {
            userField.setEnabled(true);
            passwordField.setEnabled(true);
        } else {
            userField.setEnabled(false);
            passwordField.setEnabled(false);
        }
    }//GEN-LAST:event_roleCBoxActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        if (!validateData()) {
            return;
        }

        try {
            var db = new Database();
            var newEmpID = db.insertEmployee(nameField.getText(), phoneField.getText(),
                    addressArea.getText(), roleCBox.getSelectedItem().toString(), salaryField.getText());

            JOptionPane.showMessageDialog(this, "New employee's id = " + newEmpID);

            clearData();
        } catch (SQLIntegrityConstraintViolationException e) {
            JOptionPane.showMessageDialog(this, "Phone no. already exists");

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_addButtonActionPerformed

    private void showEmpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showEmpButtonActionPerformed
        var tableModel = (DefaultTableModel) empTable.getModel();

        // Clear table rows
        tableModel.setRowCount(0);

        try {
            var db = new Database();
            var empList = db.getAllEmployee();

            if (empList.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No employee entry founded");
                return;
            }

            for (var emp : empList) {
                tableModel.addRow(new Object[]{
                    emp.employeeID, db.getEmployeeRole(emp.employeeID).roleName, emp.employeeName,
                    emp.employeePhone, emp.employeeAddress, emp.employeeSalary
                });
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_showEmpButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JTextArea addressArea;
    private javax.swing.JLabel addressLabel;
    private javax.swing.JTable empTable;
    private javax.swing.JButton findButton;
    private javax.swing.JTextField idField;
    private javax.swing.JLabel idLabel;
    private javax.swing.JTextField idSearchField;
    private javax.swing.JLabel idSearchLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JButton newRoleButton;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JTextField phoneField;
    private javax.swing.JLabel phoneLabel;
    private javax.swing.JButton removeButton;
    private javax.swing.JComboBox<String> roleCBox;
    private javax.swing.JLabel roleLabel;
    private javax.swing.JTextField salaryField;
    private javax.swing.JLabel salaryLabel;
    private javax.swing.JButton showEmpButton;
    private javax.swing.JButton updateButton;
    private javax.swing.JTextField userField;
    private javax.swing.JLabel userLabel;
    // End of variables declaration//GEN-END:variables
}
