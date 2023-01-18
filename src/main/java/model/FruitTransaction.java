package model;

public class FruitTransaction {
    private StoreOperation storeOperation;
    private String fruit;
    private int quantity;

    public FruitTransaction(StoreOperation storeOperation, String fruit, int quantity) {
        this.storeOperation = storeOperation;
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public StoreOperation getStoreOperation() {
        return storeOperation;
    }

    public void setStoreOperation(StoreOperation storeOperation) {
        this.storeOperation = storeOperation;
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
