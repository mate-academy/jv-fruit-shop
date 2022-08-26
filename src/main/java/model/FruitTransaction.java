package model;

import java.util.Arrays;

public class FruitTransaction {
    private Operation operation;
    private String fruit;
    private Integer quantity;

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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private String operationType;

        Operation(String operationType) {
            this.operationType = operationType;
        }

        public String getOperationType() {
            return operationType;
        }

        public static Operation getTypeOperation(String operation) {
            return Arrays.stream(Operation.values())
                    .filter(o -> o.getOperationType().equals(operation))
                    .findFirst()
                    .orElseThrow(() ->
                    new RuntimeException("Not allowed operation with first operation "
                            + operation));
        }
    }
}
