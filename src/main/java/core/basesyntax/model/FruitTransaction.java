package core.basesyntax.model;

import core.basesyntax.exceptions.InvalidOperationException;

public class FruitTransaction {
    private final Operation operation;
    private final String fruit;
    private final int quantity;

    public FruitTransaction(String operationCode, String fruit, int quantity) {
        this.operation = getByCode(operationCode);
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public String getFruit() {
        return fruit;
    }

    public int getQuantity() {
        return quantity;
    }

    public Operation getOperation() {
        return operation;
    }

    private Operation getByCode(String code) {
        for (Operation operation : Operation.values()) {
            if (operation.getCode().equals(code)) {
                return operation;
            }
        }
        throw new InvalidOperationException("Invalid code");
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
