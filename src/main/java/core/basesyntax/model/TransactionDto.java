package core.basesyntax.model;

public class TransactionDto {
    private Operation operation;
    private Fruits fruit;
    private Integer quantity;

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public Fruits getFruit() {
        return fruit;
    }

    public void setFruit(Fruits fruit) {
        this.fruit = fruit;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "TransactionDto{" +
                "operation=" + operation +
                ", fruit=" + fruit +
                ", quantity=" + quantity +
                '}';
    }
}
