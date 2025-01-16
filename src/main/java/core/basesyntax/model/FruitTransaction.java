package core.basesyntax.model;

public class FruitTransaction {
    private static final int ZERO = 0;
    private Operation operation;
    private String fruit;
    private int quantity;

    public String getFruit() {
        return fruit;
    }

    public void setFruit(String fruit) {
        if (fruit == null || fruit.isEmpty()) {
            throw new NullPointerException("Fruit cannot be null or empty");
        }
        this.fruit = fruit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity < ZERO) {
            throw new RuntimeException("Quantity cannot be negative");
        }
        this.quantity = quantity;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private final String operation;

        Operation(String operation) {
            this.operation = operation;
        }

        public String getOperation() {
            return operation;
        }

        public static Operation fromString(String value) {
            for (Operation op : values()) {
                if (op.getOperation().equalsIgnoreCase(value)) {
                    return op;
                }
            }
            throw new IllegalArgumentException("Unknown operation code: " + value);
        }
    }
}
