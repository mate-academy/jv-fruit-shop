package core.basesyntax.model;

import java.util.Arrays;

public class FruitTransaction {
    private Operation operation;
    private String fruit;
    private int quantity;

    public Operation getOperation() {
        return operation;
    }

    public String getFruit() {
        return fruit;
    }

    public int getQuantity() {
        return this.quantity;
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

        private final String firstLetter;

        Operation(String operation) {
            this.firstLetter = operation;
        }

        public Operation getOperationByLetter(String operation){
            return Arrays.stream(Operation.values())
                    .filter(o -> o.getOperation().equals(operation))
                    .findAny()
                    .orElseThrow(() ->
                            new RuntimeException("Could not find this operation: " + operation));
        }

        private String getOperation() {
            return firstLetter;
        }
    }
}
