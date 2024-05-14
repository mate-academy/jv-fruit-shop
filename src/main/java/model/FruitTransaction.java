package model;

public class FruitTransaction {
    private Operation operation;
    private String fruit;
    private int quantity;

    public FruitTransaction(Operation operation, String fruit, int quantity) {
        this.operation = operation;
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public FruitTransaction(String operation, String fruit, String quantity) {
        this.operation = Operation.fromCode(operation.trim());
        this.fruit = fruit.trim();
        this.quantity = Integer.parseInt(quantity.trim());
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

        public String get() {
            return this.code;
        }

        public static Operation fromCode(String code) {
            for (Operation value : Operation.values()) {
                if (value.get().equals(code)) {
                    return value;
                }
            }
            throw new IllegalArgumentException("Operation not found: " + code);
        }
    }
}
