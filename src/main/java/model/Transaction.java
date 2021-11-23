package model;

public class Transaction {
    private String operation;
    private String fruitName;
    private int quality;

    public Transaction(String operation, String fruitName, int quality) {
        this.operation = operation;
        this.fruitName = fruitName;
        this.quality = quality;
    }

    public int getQuality() {
        return quality;
    }

    public String getFruitName() {
        return fruitName;
    }

    public String getOperation() {
        return operation;
    }
}
