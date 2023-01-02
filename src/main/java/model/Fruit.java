package model;

public class Fruit {
    private String fruitName;
    private int fruitCount;
    private Operation operation;

    public Fruit(String fruitName, int fruitCount) {
        this.fruitName = fruitName;
        this.fruitCount = fruitCount;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public int getFruitCount() {
        return fruitCount;
    }

    public void setFruitCount(int fruitCount) {
        this.fruitCount = fruitCount;
    }
}
