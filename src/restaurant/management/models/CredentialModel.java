package restaurant.management.models;

public class CredentialModel {

    public int employeeID;
    public String username;
    public String password;

    public CredentialModel(int employeeID, String username, String password) {
        this.employeeID = employeeID;
        this.username = username;
        this.password = password;
    }

    public CredentialModel() {

    }
}
