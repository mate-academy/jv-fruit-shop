package model;

public class Transaction {
    private String operation;
    private String fruitName;
    private int quantity;

    public Transaction(String operation, String fruitName, int quality) {
        this.operation = operation;
        this.fruitName = fruitName;
        this.quantity = quality;
    }

    public int getQuality() {
        return quantity;
    }

    public String getFruitName() {
        return fruitName;
    }

    public String getOperation() {
        return operation;
    }
}
