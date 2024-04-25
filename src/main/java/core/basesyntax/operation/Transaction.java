package core.basesyntax.operation;

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
        BALANCE,
        SUPPLY,
        PURCHASE,
        RETURN;

        public static Operation getByCode(String code) {
            return switch (code) {
                case BALANCE_ABBREVIATION -> Transaction.Operation.BALANCE;
                case SUPPLY_ABBREVIATION -> Transaction.Operation.SUPPLY;
                case PURCHASE_ABBREVIATION -> Transaction.Operation.PURCHASE;
                case RETURN_ABBREVIATION -> Transaction.Operation.RETURN;
                default -> throw new RuntimeException("Invalid data, no corresponding Operation");
            };
        }
    }
}
