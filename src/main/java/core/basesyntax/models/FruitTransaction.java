package core.basesyntax.models;

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

        private final String abbreviation;

        Operation(String abbreviation) {
            this.abbreviation = abbreviation;
        }

        public static Operation fromString(String value) {
            for (Operation op : Operation.values()) {
                if (op.abbreviation.equalsIgnoreCase(value)) {
                    return op;
                }
            }
            throw new IllegalArgumentException("No enum constant for value: " + value);
        }
    }

}

