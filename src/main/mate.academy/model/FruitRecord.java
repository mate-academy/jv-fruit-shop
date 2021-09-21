package model;

public class FruitRecord {
    private final String typeOperation;
    private final Fruit fruit;
    private final int amount;

    public FruitRecord(String typeOperation, Fruit fruit, int amount) {
        this.typeOperation = typeOperation;
        this.fruit = fruit;
        this.amount = amount;
    }

    public String getTypeOperation() {
        return typeOperation;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public int getAmount() {
        return amount;
    }
}