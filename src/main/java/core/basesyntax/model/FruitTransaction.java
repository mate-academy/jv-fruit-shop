package core.basesyntax.model;

public class FruitTransaction {
    private final Operation operation;
    private final String fruit;
    private final int quantity;

    public FruitTransaction(Operation operation, String fruit, int quantity) {
        if (operation == null) {
            throw new IllegalArgumentException("Operation cannot be null");
        }
        if (fruit == null || fruit.isBlank()) {
            throw new IllegalArgumentException("Fruit cannot be null or empty");
        }
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }

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

        private final String code;

        Operation(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }

        public static Operation getOperationByCode(String code) {
            if (code == null || code.isBlank()) {
                throw new IllegalArgumentException("Operation code cannot be empty");
            }

            for (Operation operation : values()) {
                if (operation.code.equals(code)) {
                    return operation;
                }
            }

            throw new IllegalArgumentException(
                    "Unknown operation code: " + code);
        }
    }
}
