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

public class EmployeeForm extends javax.swing.JFrame {

    static String newRoleName;

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

    private boolean validateInsertData() {
        // Check username and password field based on employee's role
        if (roleCBox.getSelectedItem().equals("Admin")
                || roleCBox.getSelectedItem().equals("Receptionist")) {

            if (userField.getText().trim().isEmpty() || passwordField.getPassword().length == 0) {
                JOptionPane.showMessageDialog(this, "One or more fields are empty");
                return false;
            }
        }

        return true;
    }

    private boolean validateUpdateData() {
        // Check username field based on employee's role
        if (roleCBox.getSelectedItem().equals("Admin")
                || roleCBox.getSelectedItem().equals("Receptionist")) {

            if (userField.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "One or more fields are empty");
                return false;
            }
        }

        return true;
    }

    private boolean validateData() {
        if (roleCBox.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Select employee's role");
            return false;
        }

        // Check if specified fields are empty or contains whitespaces
        if (nameField.getText().trim().isEmpty() || phoneField.getText().trim().isEmpty()
                || addressArea.getText().trim().isEmpty() || salaryField.getText().trim().isEmpty()) {

            JOptionPane.showMessageDialog(this, "One or more fields are empty");
            return false;
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

        // Check if phone number is valid
        try {
            new BigInteger(phoneField.getText());

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid phone number");
            return false;
        }

        // Check if salary value is valid
        try {
            Double.parseDouble(salaryField.getText());

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid value for salary");
            return false;
        }

        return true;
    }

    void clearFields() {
        empSearchField.setText("");
        userField.setText("");
        passwordField.setText("");
        idField.setText("");
        nameField.setText("");
        phoneField.setText("");
        addressArea.setText("");
        salaryField.setText("");
    }

    void showAllEmployee() {
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
                    emp.employeeID, emp.employeeRole, emp.employeeName,
                    emp.employeePhone, emp.employeeAddress, emp.employeeSalary
                });
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        empTable = new javax.swing.JTable();
        empSearchField = new javax.swing.JTextField();
        empSearchLabel = new javax.swing.JLabel();
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
        clearButton = new javax.swing.JButton();
        clearTableButton = new javax.swing.JButton();
        empListLabel = new javax.swing.JLabel();
        headingLabel = new javax.swing.JLabel();
        empHeadingLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 102, 0));

        empTable.setBackground(new java.awt.Color(102, 102, 102));
        empTable.setBorder(new javax.swing.border.MatteBorder(null));
        empTable.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
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
        empTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                empTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(empTable);

        empSearchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                empSearchFieldKeyReleased(evt);
            }
        });

        empSearchLabel.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        empSearchLabel.setText("Search Employee");

        roleLabel.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        roleLabel.setText("Role");

        roleCBox.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        roleCBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        roleCBox.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                roleCBoxPopupMenuWillBecomeVisible(evt);
            }
        });
        roleCBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roleCBoxActionPerformed(evt);
            }
        });

        passwordLabel.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        passwordLabel.setText("Password");

        userLabel.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        userLabel.setText("Username");

        nameLabel.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        nameLabel.setText("Name");

        addressLabel.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        addressLabel.setText("Address");

        phoneLabel.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        phoneLabel.setText("Phone");

        salaryLabel.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        salaryLabel.setText("Salary");

        addressArea.setColumns(20);
        addressArea.setRows(5);
        jScrollPane2.setViewportView(addressArea);

        addButton.setBackground(new java.awt.Color(0, 102, 102));
        addButton.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        addButton.setForeground(new java.awt.Color(255, 255, 255));
        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
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

        updateButton.setBackground(new java.awt.Color(0, 102, 102));
        updateButton.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        updateButton.setForeground(new java.awt.Color(255, 255, 255));
        updateButton.setText("Update");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        idLabel.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        idLabel.setText("ID");

        idField.setEnabled(false);

        newRoleButton.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        newRoleButton.setText("New Role");
        newRoleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newRoleButtonActionPerformed(evt);
            }
        });

        showEmpButton.setBackground(new java.awt.Color(0, 102, 102));
        showEmpButton.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        showEmpButton.setForeground(new java.awt.Color(255, 255, 255));
        showEmpButton.setText("Show All");
        showEmpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showEmpButtonActionPerformed(evt);
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

        clearTableButton.setBackground(new java.awt.Color(0, 102, 102));
        clearTableButton.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        clearTableButton.setForeground(new java.awt.Color(255, 255, 255));
        clearTableButton.setText("Clear Table ");
        clearTableButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearTableButtonActionPerformed(evt);
            }
        });

        empListLabel.setBackground(new java.awt.Color(0, 0, 0));
        empListLabel.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        empListLabel.setForeground(new java.awt.Color(255, 255, 255));
        empListLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        empListLabel.setText("EMPLOYEE LIST");

        headingLabel.setBackground(new java.awt.Color(0, 0, 0));
        headingLabel.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        headingLabel.setForeground(new java.awt.Color(255, 255, 255));
        headingLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headingLabel.setText("RESTAURANT MANAGEMENT SYSTEM");

        empHeadingLabel.setBackground(new java.awt.Color(0, 0, 0));
        empHeadingLabel.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        empHeadingLabel.setForeground(new java.awt.Color(255, 255, 255));
        empHeadingLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        empHeadingLabel.setText("MANAGE EMPLOYEE");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(roleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(userLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(phoneLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(idLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(passwordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(empSearchLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(roleCBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(newRoleButton))
                    .addComponent(userField, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(empSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phoneField, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addressLabel)
                    .addComponent(salaryLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(salaryField, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(addButton)
                .addGap(44, 44, 44)
                .addComponent(updateButton)
                .addGap(43, 43, 43)
                .addComponent(removeButton)
                .addGap(29, 29, 29)
                .addComponent(showEmpButton)
                .addGap(35, 35, 35)
                .addComponent(clearButton)
                .addGap(134, 134, 134))
            .addComponent(empListLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(clearTableButton)
                .addGap(356, 356, 356))
            .addComponent(headingLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(empHeadingLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(headingLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(empHeadingLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(empSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(empSearchLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(roleCBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(newRoleButton)
                            .addComponent(roleLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(userField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(userLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(passwordLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(idLabel))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameLabel)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addressLabel))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(salaryField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(salaryLabel))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phoneField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phoneLabel))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton)
                    .addComponent(updateButton)
                    .addComponent(removeButton)
                    .addComponent(showEmpButton)
                    .addComponent(clearButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(empListLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(clearTableButton)
                .addGap(18, 18, 18))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void newRoleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newRoleButtonActionPerformed
        var roleForm = new RoleForm();
        roleForm.setVisible(true);
        roleForm.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_newRoleButtonActionPerformed

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
        if (!validateData() || !validateInsertData()) {
            return;
        }

        try {
            var role = roleCBox.getSelectedItem().toString();

            var db = new Database();

            if (role.equals("Admin") || role.equals("Receptionist")) {
                var creds = db.getCredentials(userField.getText());

                if (creds != null) {
                    JOptionPane.showMessageDialog(this, "Username already exists");
                    return;
                }
            }

            var newEmpID = db.insertEmployee(nameField.getText(), phoneField.getText(),
                    addressArea.getText(), role, salaryField.getText());

            if (role.equals("Admin") || role.equals("Receptionist")) {
                db.insertCredentials(newEmpID, userField.getText(), String.valueOf(passwordField.getPassword()));
            }

            JOptionPane.showMessageDialog(this, "New employee's id = " + newEmpID);

            clearFields();

        } catch (SQLIntegrityConstraintViolationException e) {
            JOptionPane.showMessageDialog(this, "Phone no. already exists");

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_addButtonActionPerformed

    private void showEmpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showEmpButtonActionPerformed
        showAllEmployee();
    }//GEN-LAST:event_showEmpButtonActionPerformed

    private void empTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_empTableMouseClicked
        var row = empTable.getSelectedRow();

        var tableModel = (DefaultTableModel) empTable.getModel();
        var tableVector = tableModel.getDataVector();

        idField.setText(tableVector.elementAt(row).elementAt(0).toString());
        roleCBox.setSelectedItem(tableVector.elementAt(row).elementAt(1));
        nameField.setText(tableVector.elementAt(row).elementAt(2).toString());
        phoneField.setText(tableVector.elementAt(row).elementAt(3).toString());
        addressArea.setText(tableVector.elementAt(row).elementAt(4).toString());
        salaryField.setText(tableVector.elementAt(row).elementAt(5).toString());

        empSearchField.setText("");
        userField.setText("");
        passwordField.setText("");

        var role = roleCBox.getSelectedItem().toString();

        // set username field only if role is either admin or receptionist
        if (role.equals("Admin") || role.equals("Receptionist")) {
            try {
                var empID = Integer.parseInt(tableVector.elementAt(row).elementAt(0).toString());

                var db = new Database();
                var creds = db.getCredentials(empID);

                userField.setText(creds.username);

            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_empTableMouseClicked

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        if (idField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Select employee row before updating");
            return;
        }

        if (!validateData() || !validateUpdateData()) {
            return;
        }

        try {
            var db = new Database();

            var empID = Integer.parseInt(idField.getText());
            var role = roleCBox.getSelectedItem().toString();
            var currentRole = db.getEmployeeRole(empID);

            var credExists = false;

            // Check existing role
            if (currentRole.roleName.equals("Admin") || currentRole.roleName.equals("Receptionist")) {
                // Set status to true as credential is available already
                credExists = true;
            }

            // Check new role 
            if (role.equals("Admin") || role.equals("Receptionist")) {

                var otherUserCreds = db.getCredentials(userField.getText());

                // Check if specified username already exists
                if (otherUserCreds != null && empID != otherUserCreds.employeeID) {
                    JOptionPane.showMessageDialog(this, "Username already exists");
                    return;
                }

                if (!credExists) {
                    // Validate password field for new credential
                    if (String.valueOf(passwordField.getPassword()).trim().isEmpty()) {
                        JOptionPane.showMessageDialog(this, "Invalid password format");
                        return;
                    }
                }
            }

            // Update specified employee details
            db.updateEmployee(empID, nameField.getText(), phoneField.getText(),
                    addressArea.getText(), role, Double.parseDouble(salaryField.getText()));

            if (role.equals("Admin") || role.equals("Receptionist")) {

                if (credExists) {
                    db.updateCredentials(empID, userField.getText(), String.valueOf(passwordField.getPassword()));
                } else {
                    db.insertCredentials(empID, userField.getText(), String.valueOf(passwordField.getPassword()));
                }

            } else if (credExists) {
                db.deleteCredentials(empID);
            }

            var tableRow = empTable.getSelectedRow();
            var tableModel = (DefaultTableModel) empTable.getModel();

            tableModel.setValueAt(idField.getText(), tableRow, 0);
            tableModel.setValueAt(roleCBox.getSelectedItem(), tableRow, 1);
            tableModel.setValueAt(nameField.getText(), tableRow, 2);
            tableModel.setValueAt(phoneField.getText(), tableRow, 3);
            tableModel.setValueAt(addressArea.getText(), tableRow, 4);
            tableModel.setValueAt(salaryField.getText(), tableRow, 5);

            JOptionPane.showMessageDialog(this, "Data updated successfully");

            clearFields();

        } catch (SQLIntegrityConstraintViolationException e) {
            JOptionPane.showMessageDialog(this, "Phone number already exists");

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_updateButtonActionPerformed

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        if (idField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Select employee row before deleting");
            return;
        }

        try {
            var db = new Database();
            var empID = Integer.parseInt(idField.getText());

            if (roleCBox.getSelectedItem().equals("Admin") || roleCBox.getSelectedItem().equals("Admin")) {
                db.deleteCredentials(empID);
            }

            db.removeEmployee(empID);

            var tableRow = empTable.getSelectedRow();
            var tableModel = (DefaultTableModel) empTable.getModel();

            tableModel.removeRow(tableRow);

            JOptionPane.showMessageDialog(this, "Deleted successfully");

            clearFields();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_removeButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        clearFields();
    }//GEN-LAST:event_clearButtonActionPerformed

    private void clearTableButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearTableButtonActionPerformed
        var tableModel = (DefaultTableModel) empTable.getModel();
        tableModel.setRowCount(0);
    }//GEN-LAST:event_clearTableButtonActionPerformed

    private void roleCBoxPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_roleCBoxPopupMenuWillBecomeVisible
        if (newRoleName != null) {
            roleCBox.addItem(newRoleName);
            newRoleName = null;
        }
    }//GEN-LAST:event_roleCBoxPopupMenuWillBecomeVisible

    private void empSearchFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_empSearchFieldKeyReleased
        showAllEmployee();

        var tableModel = (DefaultTableModel) empTable.getModel();
        var sorter = new TableRowSorter<>(tableModel);

        empTable.setRowSorter(sorter);

        var text = empSearchField.getText();

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
    }//GEN-LAST:event_empSearchFieldKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JTextArea addressArea;
    private javax.swing.JLabel addressLabel;
    private javax.swing.JButton clearButton;
    private javax.swing.JButton clearTableButton;
    private javax.swing.JLabel empHeadingLabel;
    private javax.swing.JLabel empListLabel;
    private javax.swing.JTextField empSearchField;
    private javax.swing.JLabel empSearchLabel;
    private javax.swing.JTable empTable;
    private javax.swing.JLabel headingLabel;
    private javax.swing.JTextField idField;
    private javax.swing.JLabel idLabel;
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
