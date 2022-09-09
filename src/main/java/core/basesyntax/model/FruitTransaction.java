package core.basesyntax.model;

public class FruitTransaction {
    private final String operation;
    private final String fruit;
    private final Integer quantity;

    public FruitTransaction(String operation, String fruit, Integer quantity) {
        this.operation = operation;
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public String getOperation() {
        return operation;
    }

    public String getFruit() {
        return fruit;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
