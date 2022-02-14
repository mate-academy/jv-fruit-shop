package fruitshop.model;

public class FruitTransaction {
    private Operation operation;
    private String fruit;
    private int quantity;

    private FruitTransaction(Operation operation, String fruit, int quantity) {
        this.operation = operation;
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public static FruitTransaction of(Operation operation, String fruit, int quantity) {
        return new FruitTransaction(operation, fruit, quantity);
    }

    public Operation getOperation() {
        return operation;
    }

    public String getFruit() {
        return fruit;
    }

    public int getQuantity() {
        return quantity;
    }

}

