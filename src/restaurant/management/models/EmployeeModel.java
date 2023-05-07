package restaurant.management.models;

public class EmployeeModel {

    public int employeeID;
    public String employeeName;
    public String employeePhone;
    public String employeeAddress;
    public String employeeRole;
    public double employeeSalary;

    public EmployeeModel(int employeeID, String employeeName, String employeePhone,
            String employeeAddress, String employeeRole, double employeeSalary) {

        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.employeePhone = employeePhone;
        this.employeeAddress = employeeAddress;
        this.employeeRole = employeeRole;
        this.employeeSalary = employeeSalary;
    }

    public EmployeeModel() {

    }
}
