package restaurant.management.models;

public class EmployeeModel {

    public int employeeID;
    public String employeeName;
    public String employeePhone;
    public String employeeAddress;
    public int employeeRoleID;
    public double employeeSalary;

    public EmployeeModel(int employeeID, String employeeName, String employeePhone,
            String employeeAddress, int employeeRoleID, double employeeSalary) {

        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.employeePhone = employeePhone;
        this.employeeAddress = employeeAddress;
        this.employeeRoleID = employeeRoleID;
        this.employeeSalary = employeeSalary;
    }

    public EmployeeModel() {

    }
}
