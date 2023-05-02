package restaurant.management.models;

public class OrderedItemModel {

    public int orderID;
    public int itemID;
    public int itemQuantity;

    public OrderedItemModel(int orderID, int itemID, int itemQuantity) {
        this.orderID = orderID;
        this.itemID = itemID;
        this.itemQuantity = itemQuantity;
    }

    public OrderedItemModel() {

    }
}
