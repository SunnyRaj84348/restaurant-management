package restaurant.management.models;

public class ItemModel {

    public int itemID;
    public String itemName;
    public int itemTypeID;
    public double itemPrice;

    public ItemModel(int itemID, String itemName, int itemTypeID, double itemPrice) {
        this.itemID = itemID;
        this.itemName = itemName;
        this.itemTypeID = itemTypeID;
        this.itemPrice = itemPrice;
    }

    public ItemModel() {

    }
}
