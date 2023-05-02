package restaurant.management.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private Connection con;

    public Database() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306", "user", "password");
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
}
