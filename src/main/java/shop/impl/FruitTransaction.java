package shop.impl;

public class FruitTransaction {
    private String operation;
    private String fruitName;
    private int quantity;

    public FruitTransaction(String operation, String fruitName, int quantity) {
        this.operation = operation;
        this.fruitName = fruitName;
        this.quantity = quantity;
    }

    public String getOperation() {
        return operation;
    }

    public String getFruitName() {
        return fruitName;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "FruitTransaction{"
                + "operation=" + operation
                + ", fruitName='" + fruitName + '\''
                + ", quantity=" + quantity
                + '}';
    }
}
