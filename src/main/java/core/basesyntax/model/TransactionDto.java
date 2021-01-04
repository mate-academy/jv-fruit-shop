package core.basesyntax.model;

public class TransactionDto { //сюди записуємо
    private Operation operation;
    private Fruit fruit;
    private Integer quantity;

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public void setFruit(Fruit fruit) {
        this.fruit = fruit;
    }

    public void setQuantity(Integer quantity) {
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
