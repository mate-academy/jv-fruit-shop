package core.basesyntax.model;

public class Transaction {
    private Operation operation;
    private String productName;
    private int emount;

    public Transaction(Operation operation, String productName, int emount) {
        this.operation = operation;
        this.productName = productName;
        this.emount = emount;
    }

    public Operation getOperation() {
        return operation;
    }

    public String getProductName() {
        return productName;
    }

    public int getEmount() {
        return emount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "operation=" + operation +
                ", productName='" + productName + '\'' +
                ", emount=" + emount +
                '}';
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

        public static Transaction.Operation getByCode(String code) {
            for (Transaction.Operation operation : Transaction.Operation.values()) {
                if (operation.getCode().equals(code)) {
                    return operation;
                }
            }
            throw new RuntimeException("Invalid transaction name!");
        }
    }
}
