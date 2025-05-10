package core.basesyntax.model;

import core.basesyntax.exception.InvalidOperationCodeException;

public class FruitTransaction {
    private Operation operation;
    private String fruit;
    private int quantity;

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

    public enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private String code;

        Operation(String code) {
            this.code = code;
        }

        public static Operation getValue(String code) {
            for (Operation o : values()) {
                if (o.code.equals(code)) {
                    return o;
                }
            }
            throw new InvalidOperationCodeException("Can't find operation with code: " + code);
        }

        public String getCode() {
            return code;
        }
    }
}
