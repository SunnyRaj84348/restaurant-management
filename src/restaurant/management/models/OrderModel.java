package restaurant.management.models;

import java.sql.Timestamp;

public class OrderModel {

    public int orderID;
    public Timestamp orderDate;
    public int customerID;

    public OrderModel(int orderID, Timestamp orderDate, int customerID) {
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.customerID = customerID;
    }

    public OrderModel() {

    }
}
