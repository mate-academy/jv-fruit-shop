package core.basesyntax.model;

public class FruitTransaction {
    private String name;
    private Integer quantity;
    private Operation operation;

    public FruitTransaction(String name, Integer quantity, Operation operation) {
        this.name = name;
        this.quantity = quantity;
        this.operation = operation;
    }

    public String getName() {
        return name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Operation getOperation() {
        return operation;
    }
}
