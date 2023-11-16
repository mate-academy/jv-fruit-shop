package core.basesyntax.model;

import java.util.NoSuchElementException;

public class FruitTransaction {
    private static final String ILLEGAL_ARGUMENT_EXCEPTION_MESSAGE = "Quantity can't be negative";
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
        if (quantity < 0) {
            throw new IllegalArgumentException(ILLEGAL_ARGUMENT_EXCEPTION_MESSAGE);
        }
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

        public static Operation getOperationByCode(String operationCode) {
            for (Operation operation : Operation.values()) {
                if (operation.getCode().equals(operationCode)) {
                    return operation;
                }
            }
            throw new NoSuchElementException(
                    "Element doesn't exist for this code: " + operationCode);
        }
    }
}
