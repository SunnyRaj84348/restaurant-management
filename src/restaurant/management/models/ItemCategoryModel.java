package restaurant.management.models;

public class ItemCategoryModel {

    public int itemCategoryID;
    public String itemCategoryName;
    public String itemCategoryType;

    public ItemCategoryModel(int itemCategoryID, String itemCategoryName, String itemCategoryType) {
        this.itemCategoryID = itemCategoryID;
        this.itemCategoryName = itemCategoryName;
        this.itemCategoryType = itemCategoryType;
    }

    public ItemCategoryModel() {
    }
}
