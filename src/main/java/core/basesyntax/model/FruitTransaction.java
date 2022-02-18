package core.basesyntax.model;

import java.util.Arrays;

public class FruitTransaction {
    private Operation operation;
    private String fruit;
    private int quantity;

    public Operation getOperationByLetter(String letter) {
        return Arrays.stream(Operation.values())
                .filter(o -> o.getOperationIndex().equals(letter))
                .findFirst().orElseThrow(() -> new RuntimeException("There is no such operation"
                        + letter));
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

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private String operationIndex;

        Operation(String operationIndex) {
            this.operationIndex = operationIndex;
        }

        public String getOperationIndex() {
            return operationIndex;
        }
    }
}
