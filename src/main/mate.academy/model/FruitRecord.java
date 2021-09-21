package model;

public class FruitRecord {
    private final String typeOperation;
    private final Fruit fruitName;
    private final int amount;

    public FruitRecord(String typeOperation, Fruit fruitName, int amount) {
        this.typeOperation = typeOperation;
        this.fruitName = fruitName;
        this.amount = amount;
    }

    public String getTypeOperation() {
        return typeOperation;
    }

    public Fruit getFruitName() {
        return fruitName;
    }

    public int getAmount() {
        return amount;
    }
}