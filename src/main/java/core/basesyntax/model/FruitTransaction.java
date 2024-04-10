package core.basesyntax.model;

import jdk.dynalink.Operation;

public class FruitTransaction {
    private Operation operation;
    private String fruit;
    private int quantity;

    public core.basesyntax.model.Operation getOperation() {
        return (core.basesyntax.model.Operation) operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public String getFruit() {
        return fruit;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
