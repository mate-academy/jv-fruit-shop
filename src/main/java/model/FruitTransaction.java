package model;

public class FruitTransaction {
    private String fruit;
    private int quantity;
    private OperationsList operationsList;

    public String getFruit() {
        return fruit;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public OperationsList getOperation() {
        return operationsList;
    }

    public void setOperation(OperationsList operationsList) {
        this.operationsList = operationsList;
    }
}
