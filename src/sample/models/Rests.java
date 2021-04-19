package sample.models;

public class Rests {
    private int productId;
    private int amount;
    private int maxAmount;
    private int minAmount;

    public Rests() {
    }

    public Rests(int productId, int amount, int maxAmount, int minAmount) {
        this.productId = productId;
        this.amount = amount;
        this.maxAmount = maxAmount;
        this.minAmount = minAmount;
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

    public int getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(int maxAmount) {
        this.maxAmount = maxAmount;
    }

    public int getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(int minAmount) {
        this.minAmount = minAmount;
    }
}
