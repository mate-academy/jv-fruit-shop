package core.basesyntax.model;

import core.basesyntax.service.OperationHandler;

public class FruitTransaction {
    private OperationHandler operationHandler;
    private Fruit fruit;
    private int quantity;

    public OperationHandler getOperationHandler() {
        return operationHandler;
    }

    public void setOperation(OperationHandler operationHandler) {
        this.operationHandler = operationHandler;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public void setFruit(Fruit fruit) {
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

        private final String value;

        Operation(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
}
