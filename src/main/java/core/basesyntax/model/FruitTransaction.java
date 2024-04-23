package core.basesyntax.model;

import java.math.BigDecimal;

public class FruitTransaction {
    private Operation operation;
    private String fruit;
    private BigDecimal quantity;

    public FruitTransaction(Operation operation,
                          String fruit, BigDecimal quantity) {
        this.operation = operation;
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public Operation getOperation() {
        return operation;
    }

    public String getFruit() {
        return fruit;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }
}
