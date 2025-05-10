package core.basesyntax.transaction;

public class Transaction {
    private static final String BALANCE_ABBREVIATION = "b";
    private static final String SUPPLY_ABBREVIATION = "s";
    private static final String PURCHASE_ABBREVIATION = "p";
    private static final String RETURN_ABBREVIATION = "r";
    private Operation operation;
    private String product;
    private int quantity;

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Operation getOperation() {
        return operation;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String fruit) {
        this.product = fruit;
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
            for (Operation operationName : Operation.values()) {
                if (operationName.getCode().equals(code)) {
                    return operationName;
                }
            }
            throw new IllegalArgumentException("Invalid operation code: " + code);
        }
    }
}
