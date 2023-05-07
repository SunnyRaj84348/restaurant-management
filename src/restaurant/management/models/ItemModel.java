package restaurant.management.models;

public class ItemModel {

    public int itemID;
    public String itemName;
    public int itemCategoryID;
    public double itemPrice;

    public ItemModel(int itemID, String itemName, int itemCategoryID, double itemPrice) {
        this.itemID = itemID;
        this.itemName = itemName;
        this.itemCategoryID = itemCategoryID;
        this.itemPrice = itemPrice;
    }

    public ItemModel() {

    }
}
