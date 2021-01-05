package core.basesyntax.model;

public class TransactionDto {
    private Operation operation;
    private Fruit fruit;
    private Integer quantity;

    public TransactionDto(Operation operation, Fruit fruit, Integer quantity) {
        this.operation = operation;
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public Operation getOperation() {
        return operation;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
