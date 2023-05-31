package model;

public class FruitTransaction {
    private OperationType operationType;
    private String name;
    private int quantity;

    public FruitTransaction() {
    }

    public FruitTransaction(OperationType operationType, String name, int quantity) {
        this.operationType = operationType;
        this.name = name;
        this.quantity = quantity;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public void setOperationType(OperationType operationType) {
        this.operationType = operationType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "FruitTransaction{"
                + "operationType='" + operationType + '\''
                + ", name='" + name + '\''
                + ", quantity=" + quantity
                + '}';
    }
}
