package core.basesyntax.model;

import java.util.Objects;

public class Fruits {
    private String fruitName;

    public Fruits(String fruitName) {
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
        Fruits fruitToCheck = (Fruits) fruit;
        return Objects.equals(fruitName, fruitToCheck.getFruitName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(fruitName);
    }
}
