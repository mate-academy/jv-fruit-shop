package core.basesyntax.model;

import java.math.BigDecimal;

public class FruitTransaction {
    private Operation operation;
    private String fruit;
    private BigDecimal quantity;

    public FruitTransaction(Operation operation, String fruit, BigDecimal quantity) {
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

    public String getFruit() {
        return fruit;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }
}
