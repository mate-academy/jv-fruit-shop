package core.basesyntax.model;

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
        return this.operation;
    }

    public String getFruit() {
        return this.fruit;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public enum Operation {
        BALANCE("b"),
        PURCHASE("p"),
        RETURN("r"),
        SUPPLY("s");

        private final String code;

        private Operation(String code) {
            this.code = code;
        }

        public String getCode() {
            return this.code;
        }

        public static Operation fromCode(String code) {
            for (Operation operation : values()) {
                if (operation.getCode().equals(code)) {
                    return operation;
                }
            }

            throw new IllegalArgumentException("No enum constant with code " + code);
        }
    }
}
