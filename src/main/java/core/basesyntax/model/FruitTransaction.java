package core.basesyntax.model;

public class FruitTransaction {
    private String fruit;
    private int quantity;
    private Operation operation;

    private FruitTransaction(Operation operation, String fruit, int quantity) {
        this.fruit = fruit;
        this.quantity = quantity;
        this.operation = operation;
    }

    public static FruitTransaction of(Operation operation, String fruit, int quantity) {
        return new FruitTransaction(operation, fruit, quantity);
    }

    public String getFruit() {
        return fruit;
    }

    public void subtract(int quantity) {
        if (quantity > this.quantity) {
            throw new RuntimeException("Cannot sell more fruit than is in stock");
        }
        this.quantity -= quantity;
    }

    public void add(int quantity) {
        this.quantity += quantity;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity < 0) {
            throw new RuntimeException("Quantiny cannot be less than 0");
        }
        this.quantity = quantity;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

}
