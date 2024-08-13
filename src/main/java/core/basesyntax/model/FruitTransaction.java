package core.basesyntax.model;

public class FruitTransaction {
    private final Operation operation;
    private final String fruit;
    private final int quantity;

    public FruitTransaction(String code, String fruit, int quantity) {
        this.operation = Operation.fromCode(code);
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

        private final String code;

        Operation(String code) {
            this.code = code;
        }

        public static Operation fromCode(String code) {
            for (Operation operation : values()) {
                if (operation.code.equals(code.trim())) {
                    return operation;
                }
            }
            throw new IllegalArgumentException("Invalid code: " + code);
        }
    }
}
