package core.basesyntax.model;

public class FruitTransaction {

    private final OperationType operation;
    private final String fruit;
    private final int quantity;

    public FruitTransaction(OperationType operation, String fruit, int quantity) {
        this.operation = operation;
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public OperationType getOperation() {
        return operation;
    }

    public String getFruit() {
        return fruit;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "FruitTransaction{"
                + "operation=" + operation
                + ", fruit='" + fruit + '\''
                + ", quantity=" + quantity
                + '}';
    }

    public enum OperationType {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private final String code;

        OperationType(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }

        public static OperationType fromCode(String code) {
            for (OperationType type : OperationType.values()) {
                if (type.code.equals(code)) {
                    return type;
                }
            }
            throw new IllegalArgumentException("Unknown operation: " + code);
        }
    }
}
