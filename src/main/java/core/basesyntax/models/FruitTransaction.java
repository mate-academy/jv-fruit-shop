package core.basesyntax.models;

import core.basesyntax.exceptions.OperationException;

public class FruitTransaction {
    private Operation operation;
    private String fruit;
    private int quantity;

    public FruitTransaction() {

    }

    public FruitTransaction(Operation operation, String fruit, int quantity) {
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Operation getOperationFromEnum(String code) throws OperationException {
        switch (code) {
            case "b" -> {
                return Operation.BALANCE;
            }
            case "s" -> {
                return Operation.SUPPLY;
            }
            case "p" -> {
                return Operation.PURCHASE;
            }
            case "r" -> {
                return Operation.RETURN;
            }
            default -> throw new OperationException("Can't handle an unknown operation");
        }
    }

    public enum Operation {
        BALANCE("b"), SUPPLY("s"), PURCHASE("p"), RETURN("r");

        private final String code;

        Operation(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }
    }
}
