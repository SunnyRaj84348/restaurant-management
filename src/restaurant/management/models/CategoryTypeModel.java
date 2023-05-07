package restaurant.management.models;

public class CategoryTypeModel {

    public int categoryTypeID;
    public String categoryTypeName;

    public CategoryTypeModel(int categoryTypeID, String categoryTypeName) {
        this.categoryTypeID = categoryTypeID;
        this.categoryTypeName = categoryTypeName;
    }

    public CategoryTypeModel() {
    }
}
