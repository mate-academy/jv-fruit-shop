package core.service;

public class OperationData {
    private OperationType operationType;
    private String product;
    private int quantity;

    public OperationData(OperationType operationType, String product, int number) {
        this.operationType = operationType;
        this.product = product;
        this.quantity = number;
    }

    @Override
    public String toString() {
        return "OperationData{"
                + "operationType='" + operationType + '\''
                + ", product='" + product + '\''
                + ", number=" + quantity
                + '}';
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public String getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
}
