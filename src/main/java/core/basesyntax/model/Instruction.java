package core.basesyntax.model;

public class Instruction {
    private FruitOperation operation;
    private String fruit;
    private int quantity;

    public Instruction(FruitOperation operation, String fruit, int quantity) {
        this.operation = operation;
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public FruitOperation getOperation() {
        return operation;
    }

    public void setOperation(FruitOperation operation) {
        this.operation = operation;
    }

    public String getFruitName() {
        return fruit;
    }

    public void setFruitName(String fruit) {
        this.fruit = fruit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
