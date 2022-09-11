package core.basesyntax.model;

public class Transaction {
    private final Operation operation;
    private final String productName;
    private final int quantity;

    public Transaction(Operation operation, String productName, int quantity) {
        this.operation = operation;
        this.productName = productName;
        this.quantity = quantity;
    }

    public Operation getOperation() {
        return operation;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
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

        public static Operation getByCode(String code) {
            for (Operation o : Operation.values()) {
                if (o.getCode().equals(code)) {
                    return o;
                }
            }
            throw new RuntimeException("Unable to perform the operation: " + code);
        }
    }
}
