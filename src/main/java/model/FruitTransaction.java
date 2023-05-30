package model;

public class FruitTransaction {
    private OperationType operationType;
    private String name;
    private int quantity;

    public FruitTransaction() {
    }

    public FruitTransaction(String operationType, String name, int quantity) {
        switch (operationType) {
            case "b":
                this.operationType = OperationType.BALANCE;
                break;
            case "s":
                this.operationType = OperationType.SUPPLY;
                break;
            case "p":
                this.operationType = OperationType.PURCHASE;
                break;
            case "r":
                this.operationType = OperationType.RETURN;
                break;
            default:
                this.operationType = OperationType.NONE;
        }
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
