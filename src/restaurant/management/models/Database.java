package restaurant.management.models;

import io.github.cdimascio.dotenv.Dotenv;
import java.sql.Connection;
import java.sql.DriverManager;
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
                "SELECT * FROM employee WHERE emp_id = ?"
        );

        stmt.setInt(1, employeeID);

        var rs = stmt.executeQuery();

        if (!rs.next()) {
            return null;
        }

        var empDetails = new EmployeeModel(
                rs.getInt(1), rs.getString(2), rs.getString(3),
                rs.getString(4), rs.getInt(5), rs.getDouble(6)
        );

        return empDetails;
    }

    public ArrayList<EmployeeModel> getAllEmployee() throws SQLException {
        var stmt = con.prepareStatement(
                "SELECT * FROM employee"
        );

        var rs = stmt.executeQuery();

        var empList = new ArrayList<EmployeeModel>();
        while (rs.next()) {
            empList.add(new EmployeeModel(
                    rs.getInt(1), rs.getString(2), rs.getString(3),
                    rs.getString(4), rs.getInt(5), rs.getDouble(6))
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
}
