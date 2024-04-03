package core.basesyntax.model;

public class FruitTransaction {
    private String fruit;
    private int quantity;
    private Operation operation;

    public FruitTransaction(Operation operation, String fruit, int quantity) {
        this.operation = operation;
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public String getFruit() {
        return fruit;
    }

    public int getQuantity() {
        return quantity;
    }

    public Operation getOperation() {
        return operation;
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

        public static Operation fromCode(String code) {
            for (Operation operation : values()) {
                if (operation.code.equals(code)) {
                    return operation;
                }
            }
            throw new IllegalArgumentException("No operation with code: " + code);
        }
    }
}
