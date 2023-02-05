package core.basesyntax.model;

import java.util.Arrays;

public class FruitTransaction {

    private Operation operation;
    private String fruit;
    private int quantity;

    public enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private String operation;

        Operation(String operation) {
            this.operation = operation;
        }

        public String getOperation() {
            return operation;
        }

        public static Operation getFromString(String operation) {
            return Arrays.stream(values())
                    .filter(value -> value.getOperation().equals(operation))
                    .findFirst()
                    .orElseThrow();
        }

        @Override
        public String toString() {
            return operation;
        }
    }

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
}
