package core.basesyntax.model;

public class FruitTransaction {
    private final OperationType operationType;
    private final String fruitName;
    private final int quantity;

    public FruitTransaction(OperationType operationType, String fruitType, int quantity) {
        this.operationType = operationType;
        this.fruitName = fruitType;
        this.quantity = quantity;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public String getFruitName() {
        return fruitName;
    }

    public int getQuantity() {
        return quantity;
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
            for (OperationType operationType : OperationType.values()) {
                if (operationType.getCode().equals(code)) {
                    return operationType;
                }
            }
            throw new IllegalArgumentException("Invalid Operation code: " + code);
        }
    }
}
