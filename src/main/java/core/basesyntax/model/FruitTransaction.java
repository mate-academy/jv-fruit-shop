package core.basesyntax.model;

public final class FruitTransaction {
    private final Operation operation;
    private final String fruit;
    private final int quantity;

    private FruitTransaction(Operation operation, String fruit, int quantity) {
        this.operation = operation;
        this.fruit = fruit;
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }
        this.quantity = quantity;
    }

    public static FruitTransaction of(Operation operation, String fruit, int quantity) {
        return new FruitTransaction(operation, fruit, quantity);
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

        private String code;

        Operation(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }

        public static Operation fromCode(String code) {
            for (Operation op : values()) {
                if (op.getCode().equals(code)) {
                    return op;
                }
            }
            throw new IllegalArgumentException("Unknown operation code: " + code);
        }
    }
}
