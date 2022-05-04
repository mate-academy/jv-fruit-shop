package model;

public class FruitTransferDto {
    private String operationType;
    private Fruit fruit;
    private int quantity;

    public FruitTransferDto(String operationType, Fruit fruit, int quantity) {
        this.operationType = operationType;
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public String getOperationType() {
        return operationType;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public int getQuantity() {
        return quantity;
    }
}
