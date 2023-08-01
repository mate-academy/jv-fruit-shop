package model;

public class Transaction {
    private Type type;
    private String product;
    private int quantity;

    public Transaction(Type type, String product, int quantity) {
        this.product = product;
        this.quantity = quantity;
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public String getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public enum Type {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private String code;

        Type(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }

        public static Type byCode(String code) {
            for (Type type : Type.values()) {
                if (type.code.equals(code)) {
                    return type;
                }
            }
            throw new IllegalArgumentException("Invalid Type code: " + code);
        }
    }
}
