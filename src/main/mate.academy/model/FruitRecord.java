package model;

public class FruitRecord {
    private final Operation typeOperation;
    private final Fruit fruit;
    private final int amount;

    public FruitRecord(String typeOperation, Fruit fruit, int amount) {
        this.typeOperation = Operation.get(typeOperation);
        this.fruit = fruit;
        this.amount = amount;
    }

    public Operation getTypeOperation() {
        return typeOperation;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public int getAmount() {
        return amount;
    }
}
