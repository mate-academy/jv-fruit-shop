package core.basesyntax.model;

public class Transaction {
    private final Operation operation;
    private final String productName;
    private final int quantity;

    public Transaction(String operation, String productName, int quantity) {
        this.operation = convertToOperation(operation);
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

    private Operation convertToOperation(String operation) {
        for (Operation o : Operation.values()) {
            if (o.getOperation().equals(operation)) {
                return o;
            }
        }
        throw new RuntimeException("Unable to perform the operation: " + operation);
    }
}
