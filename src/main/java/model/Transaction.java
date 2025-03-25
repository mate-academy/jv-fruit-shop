package model;

public class Transaction {
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

        private String operationCode;

        Operation(String operationCode) {
            this.operationCode = operationCode;
        }

        public String getOperationCode() {
            return operationCode;
        }

        public static Transaction.Operation operationFromCode(String operationCode) {
            for (Transaction.Operation operation : Transaction.Operation.values()) {
                if (operation.getOperationCode().equals(operationCode)) {
                    return operation;
                }
            }
            throw new IllegalArgumentException("Unknown operation code: " + operationCode);
        }
    }
}
