package model;

//this is a class to create a model for each line from a file.
public class FruitTransactionModel {
    private String operationType;
    private String name;
    private int quantity;

    public FruitTransactionModel() {
    }

    public FruitTransactionModel(String operationType, String name, int quantity) {
        this.operationType = operationType;
        this.name = name;
        this.quantity = quantity;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
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
        return "FruitTransactionModel{"
                + "operationType='" + operationType + '\''
                + ", name='" + name + '\''
                + ", quantity=" + quantity
                + '}';
    }
}
