package restaurant.management.models;

import io.github.cdimascio.dotenv.Dotenv;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class Database {

    private Connection con;

    public Database() throws ClassNotFoundException, SQLException {
        // Load .env variables
        var dotenv = Dotenv.load();

        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(dotenv.get("DB_URL"), dotenv.get("USER"), dotenv.get("PASSWORD"));
    }

    public CredentialModel getCredentials(String username) throws SQLException {
        var stmt = con.prepareStatement(
                "SELECT * FROM credential WHERE username = ?"
        );

        stmt.setString(1, username);

        var rs = stmt.executeQuery();

        if (!rs.next()) {
            return null;
        }

        var creds = new CredentialModel(rs.getInt(1), rs.getString(2), rs.getString(3));
        return creds;
    }

    public CredentialModel getCredentials(int employeeID) throws SQLException {
        var stmt = con.prepareStatement(
                "SELECT * FROM credential WHERE emp_id = ?"
        );

        stmt.setInt(1, employeeID);

        var rs = stmt.executeQuery();

        rs.next();

        var creds = new CredentialModel(rs.getInt(1), rs.getString(2), rs.getString(3));
        return creds;
    }

    public EmployeeRoleModel getEmployeeRole(int employeeID) throws SQLException {
        var stmt = con.prepareStatement(
                "SELECT employee_role.erole_id, employee_role.erole_name FROM employee "
                + "INNER JOIN employee_role ON employee.emp_role = employee_role.erole_id "
                + "WHERE emp_id = ?"
        );

        stmt.setInt(1, employeeID);

        var rs = stmt.executeQuery();

        rs.next();

        var employeeRole = new EmployeeRoleModel(rs.getInt(1), rs.getString(2));
        return employeeRole;
    }

    public ArrayList<EmployeeRoleModel> getEmployeeRoles() throws SQLException {
        var stmt = con.prepareStatement(
                "SELECT * FROM employee_role"
        );

        var rs = stmt.executeQuery();
        var EmpRoleList = new ArrayList<EmployeeRoleModel>();

        while (rs.next()) {
            EmpRoleList.add(new EmployeeRoleModel(rs.getInt(1), rs.getString(2)));
        }

        return EmpRoleList;
    }

    public EmployeeModel getEmployeeDetails(int employeeID) throws SQLException {
        var stmt = con.prepareStatement(
                "SELECT emp_id, emp_name, emp_phone, emp_address, employee_role.erole_name, emp_salary "
                + "FROM employee INNER JOIN employee_role "
                + "ON employee.emp_role = employee_role.erole_id "
                + "WHERE emp_id = ?"
        );

        stmt.setInt(1, employeeID);

        var rs = stmt.executeQuery();

        if (!rs.next()) {
            return null;
        }

        var empDetails = new EmployeeModel(
                rs.getInt(1), rs.getString(2), rs.getString(3),
                rs.getString(4), rs.getString(5), rs.getDouble(6)
        );

        return empDetails;
    }

    public ArrayList<EmployeeModel> getAllEmployee() throws SQLException {
        var stmt = con.prepareStatement(
                "SELECT emp_id, emp_name, emp_phone, emp_address, employee_role.erole_name, emp_salary "
                + "FROM employee INNER JOIN employee_role "
                + "ON employee.emp_role = employee_role.erole_id"
        );

        var rs = stmt.executeQuery();

        var empList = new ArrayList<EmployeeModel>();
        while (rs.next()) {
            empList.add(new EmployeeModel(
                    rs.getInt(1), rs.getString(2), rs.getString(3),
                    rs.getString(4), rs.getString(5), rs.getDouble(6))
            );
        }

        return empList;
    }

    public int getMaxEmployeeID() throws SQLException {
        var stmt = con.prepareStatement(
                "SELECT emp_id FROM employee ORDER BY emp_id DESC LIMIT 1"
        );

        var rs = stmt.executeQuery();

        if (rs.next()) {
            return rs.getInt(1);
        }

        return -1;
    }

    public ArrayList<ItemCategoryModel> getItemCategories() throws SQLException {
        var stmt = con.prepareStatement(
                "SELECT category_id, category_name, category_type.ctype_name FROM item_category "
                + "INNER JOIN category_type ON item_category.category_type = category_type.ctype_id "
        );

        var rs = stmt.executeQuery();
        var itemCategoryList = new ArrayList<ItemCategoryModel>();

        while (rs.next()) {
            itemCategoryList.add(new ItemCategoryModel(
                    rs.getInt(1), rs.getString(2), rs.getString(3)
            ));
        }

        return itemCategoryList;
    }

    public ArrayList<ItemModel> getItems() throws SQLException {
        var stmt = con.prepareStatement(
                "SELECT * FROM item"
        );

        var rs = stmt.executeQuery();

        var itemList = new ArrayList<ItemModel>();

        while (rs.next()) {
            itemList.add(new ItemModel(
                    rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDouble(4)
            ));
        }

        return itemList;
    }

    public ItemCategoryModel getCategory(int categoryID) throws SQLException {
        var stmt = con.prepareStatement(
                "SELECT item_category.category_id, item_category.category_name, category_type.ctype_name "
                + "FROM item_category INNER JOIN category_type "
                + "ON item_category.category_type = category_type.ctype_id "
                + "WHERE category_id = ?"
        );

        stmt.setInt(1, categoryID);

        var rs = stmt.executeQuery();

        if (!rs.next()) {
            return null;
        }

        var itemCategory = new ItemCategoryModel(
                rs.getInt(1), rs.getString(2), rs.getString(3)
        );

        return itemCategory;
    }

    public ItemCategoryModel getCategory(String categoryName) throws SQLException {
        var stmt = con.prepareStatement(
                "SELECT item_category.category_id, item_category.category_name, category_type.ctype_name "
                + "FROM item_category INNER JOIN category_type "
                + "ON item_category.category_type = category_type.ctype_id "
                + "WHERE category_name = ?"
        );

        stmt.setString(1, categoryName);

        var rs = stmt.executeQuery();

        if (!rs.next()) {
            return null;
        }

        var itemCategory = new ItemCategoryModel(
                rs.getInt(1), rs.getString(2), rs.getString(3)
        );

        return itemCategory;
    }

    public ArrayList<CustomerModel> getAllCustomers() throws SQLException {
        var stmt = con.prepareStatement(
                "SELECT * FROM customer"
        );

        var rs = stmt.executeQuery();

        var customerList = new ArrayList<CustomerModel>();

        while (rs.next()) {
            customerList.add(new CustomerModel(
                    rs.getInt(1), rs.getString(2),
                    rs.getString(3), rs.getString(4)
            ));
        }

        return customerList;
    }

    public CustomerModel getCustomer(int customerID) throws SQLException {
        var stmt = con.prepareStatement(
                "SELECT * FROM customer WHERE cust_id = ?"
        );

        stmt.setInt(1, customerID);
        var rs = stmt.executeQuery();

        if (!rs.next()) {
            return null;
        }

        var customer = new CustomerModel(
                rs.getInt(1), rs.getString(2),
                rs.getString(3), rs.getString(4)
        );

        return customer;
    }

    public ArrayList<OrderModel> getOrderHistory(int customerID) throws SQLException {
        var stmt = con.prepareStatement(
                "SELECT * FROM order_history WHERE cust_id = ?"
        );

        stmt.setInt(1, customerID);
        var rs = stmt.executeQuery();

        var orderHistory = new ArrayList<OrderModel>();

        while (rs.next()) {
            orderHistory.add(new OrderModel(
                    rs.getInt(1), rs.getTimestamp(2), rs.getInt(3)
            ));
        }

        return orderHistory;
    }

    public void setRole(String roleName) throws SQLException {
        var stmt = con.prepareStatement(
                "INSERT INTO employee_role VALUES(DEFAULT, ?)"
        );

        stmt.setString(1, roleName);
        stmt.executeUpdate();
    }

    public int insertEmployee(String empName, String empPhone, String empAddress, String empRole, String empSalary) throws SQLException {
        var stmt = con.prepareStatement(
                "INSERT INTO employee VALUES(DEFAULT, ?, ?, ?, (SELECT erole_id FROM employee_role WHERE erole_name = ?), ?)"
        );

        stmt.setString(1, empName);
        stmt.setString(2, empPhone);
        stmt.setString(3, empAddress);
        stmt.setString(4, empRole);
        stmt.setDouble(5, Double.parseDouble(empSalary));

        stmt.executeUpdate();

        stmt = con.prepareStatement("SELECT LAST_INSERT_ID()");

        var rs = stmt.executeQuery();
        rs.next();

        return rs.getInt(1);
    }

    public void insertCredentials(int empID, String username, String password) throws SQLException {
        var stmt = con.prepareStatement(
                "INSERT INTO credential VALUES(?, ?, ?)"
        );

        stmt.setInt(1, empID);
        stmt.setString(2, username);
        stmt.setString(3, password);

        stmt.executeUpdate();
    }

    public void insertItemCategory(String categoryName, String categoryType) throws SQLException {
        var stmt = con.prepareStatement(
                "INSERT INTO item_category VALUES"
                + "(DEFAULT, ?, (SELECT ctype_id FROM category_type WHERE ctype_name = ?))"
        );

        stmt.setString(1, categoryName);
        stmt.setString(2, categoryType);

        stmt.executeUpdate();
    }

    public void insertItem(String itemName, String itemCategory, double itemPrice) throws SQLException {
        var stmt = con.prepareStatement(
                "INSERT INTO item VALUES "
                + "(DEFAULT, ?, (SELECT category_id FROM item_category WHERE category_name = ?), ?)"
        );

        stmt.setString(1, itemName);
        stmt.setString(2, itemCategory);
        stmt.setDouble(3, itemPrice);

        stmt.executeUpdate();
    }

    public void insertCustomer(String customerName, String customerPhone, String customerAddress) throws SQLException {
        var stmt = con.prepareStatement(
                "INSERT INTO customer VALUES (DEFAULT, ?, ?, ?)"
        );

        stmt.setString(1, customerName);
        stmt.setString(2, customerPhone);
        stmt.setString(3, customerAddress);

        stmt.executeUpdate();
    }

    public int insertOrder(int customerID) throws SQLException {
        var stmt = con.prepareStatement(
                "INSERT INTO order_history VALUES (DEFAULT, DEFAULT, ?)"
        );

        stmt.setInt(1, customerID);

        stmt.executeUpdate();

        stmt = con.prepareStatement(
                "SELECT LAST_INSERT_ID()"
        );

        var rs = stmt.executeQuery();

        if (!rs.next()) {
            return -1;
        }

        return rs.getInt(1);
    }

    public void insertOrderItem(int orderID, String itemName, int itemQuantity) throws SQLException {
        var stmt = con.prepareStatement(
                "INSERT INTO ordered_item VALUES "
                + "(?, (SELECT item_id FROM item WHERE item_name = ?), ?)"
        );

        stmt.setInt(1, orderID);
        stmt.setString(2, itemName);
        stmt.setInt(3, itemQuantity);

        stmt.executeUpdate();
    }

    public void updateCredentials(int empID, String username, String password) throws SQLException {
        PreparedStatement stmt = null;

        if (!password.isEmpty()) {
            stmt = con.prepareStatement(
                    "UPDATE credential SET username = ?, password = ? WHERE emp_id = ?"
            );

            stmt.setString(1, username);
            stmt.setString(2, password);
            stmt.setInt(3, empID);

        } else {
            stmt = con.prepareStatement(
                    "UPDATE credential SET username = ? WHERE emp_id = ?"
            );

            stmt.setString(1, username);
            stmt.setInt(2, empID);
        }

        stmt.executeUpdate();
    }

    public void updateEmployee(int empID, String empName, String empPhone, String empAddress, String empRole, double empSalary) throws SQLException {
        var stmt = con.prepareStatement(
                "UPDATE employee SET emp_name = ?, emp_phone = ?, emp_address = ?,"
                + " emp_role = (SELECT erole_id FROM employee_role WHERE erole_name = ?), emp_salary = ?"
                + " WHERE emp_id = ?"
        );

        stmt.setString(1, empName);
        stmt.setString(2, empPhone);
        stmt.setString(3, empAddress);
        stmt.setString(4, empRole);
        stmt.setDouble(5, empSalary);
        stmt.setInt(6, empID);

        stmt.executeUpdate();
    }

    public void updateItem(int itemID, String itemName, String itemCategory, double itemPrice) throws SQLException {
        var stmt = con.prepareStatement(
                "UPDATE item SET item_name = ?, item_category = (SELECT category_id FROM item_category WHERE category_name = ?), "
                + "item_price = ? WHERE item_id = ?"
        );

        stmt.setString(1, itemName);
        stmt.setString(2, itemCategory);
        stmt.setDouble(3, itemPrice);
        stmt.setInt(4, itemID);

        stmt.executeUpdate();
    }

    public void updateCustomer(int customerID, String customerName, String customerPhone, String customerAddress) throws SQLException {
        var stmt = con.prepareStatement(
                "UPDATE customer SET cust_name = ?, cust_phone = ?, cust_address = ? "
                + "WHERE cust_id = ?"
        );

        stmt.setString(1, customerName);
        stmt.setString(2, customerPhone);
        stmt.setString(3, customerAddress);
        stmt.setInt(4, customerID);

        stmt.executeUpdate();
    }

    public void deleteCredentials(int empID) throws SQLException {
        var stmt = con.prepareStatement(
                "DELETE FROM credential WHERE emp_id = ?"
        );

        stmt.setInt(1, empID);
        stmt.executeUpdate();
    }

    public void removeEmployee(int empID) throws SQLException {
        var stmt = con.prepareStatement(
                "DELETE FROM employee WHERE emp_id = ?"
        );

        stmt.setInt(1, empID);
        stmt.executeUpdate();
    }

    public void removeItem(int itemID) throws SQLException {
        var stmt = con.prepareStatement(
                "DELETE FROM item WHERE item_id = ?"
        );

        stmt.setInt(1, itemID);
        stmt.executeUpdate();
    }

    public void removeCustomer(int customerID) throws SQLException {
        var stmt = con.prepareStatement(
                "DELETE FROM customer WHERE cust_id = ?"
        );

        stmt.setInt(1, customerID);
        stmt.executeUpdate();
    }
}
