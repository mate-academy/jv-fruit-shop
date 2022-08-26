package core.basesyntax.model;

import java.util.Arrays;
import java.util.NoSuchElementException;

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

        private String value;
        Operation(String value) {
            this.value = value;
        }

        public static Operation getType(String value) {
            return Arrays.stream(Operation.values())
                    .filter(operation -> operation.value.equals(value))
                    .findFirst()
                    .orElseThrow(() ->
                            new NoSuchElementException("Invalid operation type: " + value));
        }
    }
}
