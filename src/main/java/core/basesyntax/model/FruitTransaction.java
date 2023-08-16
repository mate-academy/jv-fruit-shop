package core.basesyntax.model;

import java.util.NoSuchElementException;

public class FruitTransaction {
    private final Operation operation;
    private final String fruit;
    private final int quantity;

    public FruitTransaction(Operation operation, String fruit, int quantity) {
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

    public int getQuantity() {
        return quantity;
    }

    public static Operation getOperationCode(String code) {
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
        RETURN("r");

        private final String code;

        Operation(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }
    }
}
