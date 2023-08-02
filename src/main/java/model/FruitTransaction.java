package model;

public class FruitTransaction {
    private OperationType type;
    private String product;
    private int quantity;

    public FruitTransaction(OperationType type, String product, int quantity) {
        this.product = product;
        this.quantity = quantity;
        this.type = type;
    }

    public OperationType getType() {
        return type;
    }

    public String getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public enum OperationType {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private String code;

        private OperationType(String code) {
            this.code = code;
        }

        public static OperationType byCode(String code) {
            for (OperationType type : OperationType.values()) {
                if (type.code.equals(code)) {
                    return type;
                }
            }
            throw new IllegalArgumentException("Invalid Type code: " + code);
        }
    }
}
