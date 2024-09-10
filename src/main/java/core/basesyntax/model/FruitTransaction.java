package core.basesyntax.model;

public class FruitTransaction {
    private Operation operation;
    private String fruitName;
    private int quantity;

    public FruitTransaction(Operation operation, String fruitName, int quantity) {
        setOperation(operation);
        setFruitName(fruitName);
        setQuantity(quantity);
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        if (operation == null) {
            throw new IllegalArgumentException("Operation can't be null.");
        }
        this.operation = operation;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        if (fruitName == null || fruitName.trim().isEmpty()) {
            throw new IllegalArgumentException("Fruit name can't be null or empty.");
        }
        this.fruitName = fruitName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity can't be negative.");
        }
        this.quantity = quantity;
    }
}

