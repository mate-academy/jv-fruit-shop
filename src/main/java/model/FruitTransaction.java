package model;

public class FruitTransaction {
    private String fruitName;
    private int quantity;
    private Operation operation;

    public FruitTransaction(Operation operation, String fruitName, int fruitCount) {
        this.fruitName = fruitName;
        this.quantity = fruitCount;
        this.operation = operation;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
