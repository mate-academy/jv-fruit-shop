package core.basesyntax.model;

public class GoodsOperation {
    private final TransactionType operationType;
    private final String item;
    private final int quantity;

    public GoodsOperation(TransactionType operation, String item, int quantity) {
        this.operationType = operation;
        this.item = item;
        this.quantity = quantity;
    }

    public String getItem() {
        return item;
    }

    public TransactionType getOperationType() {
        return operationType;
    }

    public int getQuantity() {
        return quantity;
    }

    public enum TransactionType {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");
        private final String typesCode;

        TransactionType(String code) {
            this.typesCode = code;
        }

        public static TransactionType getByCode(String code) {
            for (TransactionType type : TransactionType.values()) {
                if (type.typesCode.equals(code)) {
                    return type;
                }
            }
            throw new RuntimeException("Can't find operation type: " + code);
        }
    }
}
