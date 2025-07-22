package model;

public class Item {
    private String itemsID;
    private String itemsName;
    private double price;
    private int quantity;
    private String categoryID;
    private String itemsImagePath;

    public Item() {}

    public Item(String itemsID, String itemsName, double price, int quantity, String categoryID, String itemsImagePath) {
        this.itemsID = itemsID;
        this.itemsName = itemsName;
        this.price = price;
        this.quantity = quantity;
        this.categoryID = categoryID;
        this.itemsImagePath = itemsImagePath;
    }

    public String getItemsID() { return itemsID; }
    public void setItemsID(String itemsID) { this.itemsID = itemsID; }

    public String getItemsName() { return itemsName; }
    public void setItemsName(String itemsName) { this.itemsName = itemsName; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public String getCategoryID() { return categoryID; }
    public void setCategoryID(String categoryID) { this.categoryID = categoryID; }

    public String getItemsImagePath() { return itemsImagePath; }
    public void setItemsImagePath(String itemsImagePath) { this.itemsImagePath = itemsImagePath; }
}
