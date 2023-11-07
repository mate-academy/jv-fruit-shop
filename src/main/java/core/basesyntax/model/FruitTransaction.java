package core.basesyntax.model;

public class FruitTransaction {
    private Operation operation;
    private String fruit;
    private int amount;

    public Operation getOperation() {
        return operation;
    }

    public String getFruit() {
        return fruit;
    }

    public int getAmount() {
        return amount;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

}
