package core.basesyntax.model;

public class Transaction {
    private Operation operation;
    private String productName;
    private int amount;

    public Transaction(Operation operation, String productName, int amount) {
        this.operation = operation;
        this.productName = productName;
        this.amount = amount;
    }

    public Operation getOperation() {
        return operation;
    }

    public String getProductName() {
        return productName;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Transaction{"
                + "operation=" + operation
                + ", productName='" + productName + '\''
                + ", amount=" + amount
                + '}';
    }

    public enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private final String code;

        Operation(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }

        public static Operation getByCode(String code) {
            for (Transaction.Operation operation : Transaction.Operation.values()) {
                if (operation.getCode().equals(code)) {
                    return operation;
                }
            }
            throw new RuntimeException("Invalid transaction name!");
        }
    }
}
