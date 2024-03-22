package core.basesyntax.model;

import core.basesyntax.exception.InvalidDataException;

public class FruitTransaction {
    private Operation operation;
    private String fruit;
    private int quantity;

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


        private final String code;

        Operation(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }

        public static FruitTransaction.Operation getOperation(String operation) {
            for (FruitTransaction.Operation operationEnum : FruitTransaction.Operation.values()) {
                if (operation.equals(operationEnum.getCode())) {
                    return operationEnum;
                }
            }
            throw new InvalidDataException("Operation is not exist" + operation);
        }
    }
}
