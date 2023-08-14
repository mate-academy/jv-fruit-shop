package core.basesyntax.model;

import java.util.NoSuchElementException;

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

    public Operation getOperationCode(String code) {
        try {
            for (Operation allOperators : Operation.values()) {
                if (allOperators.getCode().equals(code)) {
                    return allOperators;
                }
            }
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Code" + code + "isn't valid");
        }
        throw new NullPointerException("Code mustn't be null");
    }

    public enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r"),
        TOTAL("t");

        private final String code;

        Operation(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }
    }
}
