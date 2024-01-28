package core.basesyntax.fruitshop.model;

public class FruitTransaction {
    public static final String CODE_B = "b";
    public static final String CODE_S = "s";
    public static final String CODE_P = "p";
    public static final String CODE_R = "r";

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
        BALANCE(CODE_B),
        SUPPLY(CODE_S),
        PURCHASE(CODE_P),
        RETURN(CODE_R);

        private final String code;

        Operation(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }

        public static Operation fromString(String text) {
            for (Operation op : Operation.values()) {
                if (op.code.equalsIgnoreCase(text)) {
                    return op;
                }
            }
            throw new IllegalArgumentException("No constant with text " + text + " found");
        }
    }
}
