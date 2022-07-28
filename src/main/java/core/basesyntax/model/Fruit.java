package core.basesyntax.model;

public class Fruit {
    private final String fruitType;
    private int fruitQuantity;

    public Fruit(String fruitType, int fruitQuantity) {
        this.fruitType = fruitType;
        this.fruitQuantity = fruitQuantity;
    }

    public String getFruitType() {
        return fruitType;
    }

    public int getFruitQuantity() {
        return fruitQuantity;
    }

    public void setFruitQuantity(int fruitQuantity) {
        this.fruitQuantity = fruitQuantity;
    }
}
