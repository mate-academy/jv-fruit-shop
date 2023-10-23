package core.basesyntax.model;

public class FruitTransaction {
    private Operation operation;
    private String fruitName;
    private int quantity;

    public FruitTransaction() {

    }

    public FruitTransaction(Operation operation, String fruitName, int quantity) {
        this.operation = operation;
        this.fruitName = fruitName;
        this.quantity = quantity;
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

    @Override
    public String toString() {
        return "FruitTransaction{" +
                "operation=" + operation +
                ", fruitName='" + fruitName + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
