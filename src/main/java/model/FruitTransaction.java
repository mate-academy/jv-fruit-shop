package model;

import java.util.Arrays;

public class FruitTransaction {
    private Operation operation;
    private String name;
    private int quantity;

    public FruitTransaction(Operation operation, String name, int quantity) {
        this.operation = operation;
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public Operation getOperation() {
        return operation;
    }

    @Override
    public String toString() {
        return "Fruit {" + "name ='" + name + '\''
                + ", quantity = " + quantity
                + ", Operation = " + operation + '}';
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

        public String getOperationCode() {
            return operationCode;
        }

        public static FruitTransaction.Operation getByCode(String operationCode) {
            return Arrays.stream(FruitTransaction.Operation.values())
                    .filter(c -> c.getOperationCode().equals(operationCode))
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("Activities at the store is not valid, "
                            + "add new activity to Enum (Operation)"));
        }
    }
}
