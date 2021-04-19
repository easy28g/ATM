package sample.models;

public class Products {
    private int id;
    private String name;
    private int categoryId;
    private String barcode;

    public Products() {
    }

    public Products(int id, String name, int categoryId, String barcode) {
        this.id = id;
        this.name = name;
        this.categoryId = categoryId;
        this.barcode = barcode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }
}
