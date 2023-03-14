package com.mate.fruitshop.model;

public class Transaction {
    private final Operation operation;
    private final String fruitName;
    private final int quantity;

    public Transaction(Operation operation, String fruitName, int quantity) {
        this.operation = operation;
        this.fruitName = fruitName;
        this.quantity = quantity;
    }

    public Operation getOperation() {
        return operation;
    }

    public String getFruitName() {
        return fruitName;
    }

    public int getQuantity() {
        return quantity;
    }

    public enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private final String operationCode;

        Operation(String operationCode) {
            this.operationCode = operationCode;
        }

        public static Operation getOperationByCode(String code) {
            for (Operation operation : Operation.values()) {
                if (operation.operationCode.equals(code)) {
                    return operation;
                }
            }
            return null;
        }
    }
}
