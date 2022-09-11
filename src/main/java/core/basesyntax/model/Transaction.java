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


}
