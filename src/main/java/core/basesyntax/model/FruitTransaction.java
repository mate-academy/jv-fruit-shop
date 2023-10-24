package core.basesyntax.model;

public class FruitTransaction {
    private Operation operation;
    private String fruitName;
    private int amount;

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruit) {
        this.fruitName = fruit;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
