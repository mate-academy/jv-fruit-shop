package core.basesyntax.model;

public class Transaction {
    private Operation operation;
    private Product product;
    private int amount;

    public Transaction(Operation operation, Product product, int amount) {
        this.operation = operation;
        this.product = product;
        this.amount = amount;
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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAmountByOperation() {
        return (operation == Operation.PURCHASE) ? -1 * getAmount() : getAmount();
    }
}
