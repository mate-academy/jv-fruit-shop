package model;

public class FruitTransactionDto {
    private final Fruit fruit;
    private final Operation operation;
    private final int amount;

    public FruitTransactionDto(Operation operation, Fruit fruit, int amount) {
        this.operation = operation;
        this.fruit = fruit;
        this.amount = amount;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public Operation getOperation() {
        return operation;
    }

    public int getAmount() {
        return amount;
    }

}
