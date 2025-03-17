package core.basesyntax.model;

public class FruitTransactionImpl implements FruitTransaction {
    private Operation operation;
    private String fruit;
    private int quantity;

    @Override
    public Operation getOperation() {
        return operation;
    }

    @Override
    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    @Override
    public String getFruit() {
        return fruit;
    }

    @Override
    public void setFruit(String fruit) {
        this.fruit = fruit;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    @Override
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
