package core.basesyntax.model;

public class Transaction {
    private Operation operation;
    private Fruit fruit;
    private Integer quantity;

    public Transaction(Operation operation, Fruit fruit, Integer quantity) {
            this.operation = operation;
            this.fruit = fruit;
            this.quantity = quantity;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public void setFruit(Fruit fruit) {
        this.fruit = fruit;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
