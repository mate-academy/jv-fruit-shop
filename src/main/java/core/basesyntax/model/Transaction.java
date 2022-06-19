package core.basesyntax.model;

public class Transaction {
    private Operation operation;
    private Product product;
    private int quantity;

    public Transaction() {
    }

    public Transaction(Operation operation, Product product, int quantity) {
        this.operation = operation;
        this.product = product;
        this.quantity = quantity;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Transaction{"
                + "operation=" + operation
                + ", product=" + product.getType()
                + ", quantity=" + quantity
                + '}';
    }
}
