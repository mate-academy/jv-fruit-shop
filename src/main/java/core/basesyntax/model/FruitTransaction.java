package core.basesyntax.model;

import java.util.Arrays;
import java.util.Optional;

public class FruitTransaction {
    private Operation operation;
    private Fruit fruit;
    private int quantity;

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public void setFruit(Fruit fruit) {
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

        private String operation;

        Operation(String operation) {
            this.operation = operation;
        }

        public String getOperation() {
            return operation;
        }

        public static Operation fromOperationValue(String operationValue) {
            Optional<Operation> optionalOperation = Arrays.stream(values())
                    .filter(v -> v.getOperation().equals(operationValue))
                    .findFirst();
            return optionalOperation.orElseThrow(() -> new IllegalArgumentException("Invalid"
                    + " operation value: " + operationValue));
        }
    }
}
