package core.basesyntax.service.impl;

import core.basesyntax.strategy.OperationStrategy;

public class FruitTransaction {
    private OperationStrategy operation;
    private String fruit;
    private int quantity;

    public FruitTransaction(OperationStrategy operation, String fruit, int quantity) {
        this.operation = operation;
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public OperationStrategy getOperation() {
        return operation;
    }

    public void setOperation(OperationStrategy operation) {
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

    public enum Operation {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

        private String code;

        Operation(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }
    }

    public void executeStrategy() {
        operation.execute(getFruit(),getQuantity());
    }
}
