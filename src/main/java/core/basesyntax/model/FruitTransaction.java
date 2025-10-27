package core.basesyntax.model;

public class FruitTransaction {
    private Operation operation;
    private String fruit;
    private int quantity;

    public FruitTransaction(Operation operation, String fruit, int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("quantity can't be negative");
        }
        this.operation = operation;
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public Operation getOperation() {
        return operation;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getFruit() {
        return fruit;
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
            for (Operation op : Operation.values()) {
                if (op.code.equals(code)) {
                    return op;
                }
            }
            throw new IllegalArgumentException("No Operation with code '" + code + "' found.");
        }
    }
}
