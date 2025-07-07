package core.basesyntax.model;

import core.basesyntax.HelloWorld;

public class FruitTransaction {
    private Operation operation;
    private String fruit;
    private int quantity;

    public FruitTransaction(String fruit, int quantity, Operation operation) {
        this.fruit = fruit;
        this.quantity = quantity;
        this.operation = operation;
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
            if (!codeExists(code)) {
                throw new RuntimeException("Code was not found");
            }
            return code;
        }

        private boolean codeExists(String code) {
            return HelloWorld.getHandlers().containsKey(code);
        }
    }
}
