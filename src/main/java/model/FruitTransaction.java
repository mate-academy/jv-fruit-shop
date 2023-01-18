package model;

public class FruitTransaction {
    private StoreOperation operation;
    private String fruit;
    private int quantity;

    public FruitTransaction(StoreOperation operation, String fruit, int quantity) {
        this.operation = operation;
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public StoreOperation getOperation() {
        return operation;
    }

    public void setOperation(StoreOperation operation) {
        this.operation = operation;
    }

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
}
