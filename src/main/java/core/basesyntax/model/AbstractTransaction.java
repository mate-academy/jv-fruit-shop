package core.basesyntax.model;

public abstract class AbstractTransaction<T> {
    private OperationType operationType;
    private T item;
    private int quantity;

    AbstractTransaction(T item, int quantity, OperationType operationType) {
        this.item = item;
        this.quantity = quantity;
        this.operationType = operationType;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public void setOperationType(OperationType operationType) {
        this.operationType = operationType;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
