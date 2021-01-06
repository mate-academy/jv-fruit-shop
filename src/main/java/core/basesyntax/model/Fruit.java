package core.basesyntax.model;

import java.util.Objects;

public class Fruit {
    private String fruitName;

    public Fruit(String fruitName) {
        this.fruitName = fruitName;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    @Override
    public boolean equals(Object fruit) {
        if (this == fruit) {
            return true;
        }
        if (fruit == null || getClass() != fruit.getClass()) {
            return false;
        }
        Fruit fruitToCheck = (Fruit) fruit;
        return Objects.equals(fruitName, fruitToCheck.getFruitName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(fruitName);
    }
}
