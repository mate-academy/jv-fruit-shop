package model;

public class FruitTransaction {
    private String fruitName;
    private Integer quantity;
    private OperationType type;

    public FruitTransaction(OperationType type, String fruitName, int quantity) {
        this.type = type;
        this.fruitName = fruitName;
        this.quantity = quantity;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public OperationType getType() {
        return type;
    }

    public void setType(OperationType type) {
        this.type = type;
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

        public static OperationType getByCode(String code) {
            for (OperationType value : values()) {
                if (value.code.equals(code)) {
                    return value;
                }
            }
            throw new RuntimeException("Incorrect transaction type");
        }
    }
}
