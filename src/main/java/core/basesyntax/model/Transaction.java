package core.basesyntax.model;

public class Transaction {
    private Operation operation;
    private Fruit fruit;
    private int quantity;

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public Fruit getProduct() {
        return fruit;
    }

    public void setProduct(Fruit fruit) {
        this.fruit = fruit;
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
                + ", fruit=" + fruit.getName()
                + ", quantity=" + quantity
                + '}';
    }
}
