package sample.models;

public class OperationDetails {

    private int id;
    private int operationId;
    private int productId;
    private int amount;
    private int price;

    public OperationDetails() {
    }

    public OperationDetails(int id, int operationId, int productId, int amount, int price) {
        this.id = id;
        this.operationId = operationId;
        this.productId = productId;
        this.amount = amount;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public int getOperationId() {
        return operationId;
    }

    public void setOperationId(int operationId) {
        this.operationId = operationId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
