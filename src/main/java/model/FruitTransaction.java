package model;

import jdk.dynalink.Operation;

public class FruitTransaction {
    private Operation operation;
    private String fruit;
    private int quantity;

    public FruitTransaction(Operation operation, String fruit, int quantity) {
        this.operation = operation;
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

    public enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private String code;

        Operation(String code) {
            this.code = code;
        }

        public static Operation getByCode(String code) {
            for (Operation operation : Operation.values()) {
                if (operation.getCode().equals(code)) {
                    return operation;
                }
            }
            throw new IllegalArgumentException("Unknown operation type! " + code);
        }

        private String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }
    }
}
