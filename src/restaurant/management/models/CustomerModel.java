package restaurant.management.models;

public class CustomerModel {

    public int customerID;
    public String customerName;
    public String customerPhone;
    public String customerAddress;

    public CustomerModel(int customerID, String customerName, String customerPhone, String customerAddress) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.customerAddress = customerAddress;
    }

    public CustomerModel() {

    }
}
