package model;

import java.util.Arrays;

public class Transaction {
    private final Operation operation;
    private final Fruit fruit;
    private final int quantity;

    public Transaction(Operation operation, Fruit fruit, int quantity) {
        this.operation = operation;
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public Operation getOperation() {
        return operation;
    }

    public Fruit getFruit() {
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

        private final String label;

        Operation(String label) {
            this.label = label;
        }

        public String getLabel() {
            return label;
        }

        public static Operation valueOfLabel(String label) {
            return Arrays.stream(values())
                    .filter(o -> o.label.equals(label))
                    .findFirst()
                    .get();
        }
    }
}
