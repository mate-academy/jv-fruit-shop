package core.basesyntax.model;

import java.util.Objects;

public class Fruit {
    private final String fruitName;
    private int fruitCount;

    public Fruit(String fruitName, int fruitCountInStorage) {
        this.fruitName = fruitName;
        this.fruitCount = fruitCountInStorage;
    }

    public String getFruitName() {
        return fruitName;
    }

    public int getFruitCount() {
        return fruitCount;
    }

    public void setFruitCount(int fruitCount) {
        this.fruitCount = fruitCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Fruit fruit = (Fruit) o;
        return fruitCount == fruit.fruitCount
                && Objects.equals(fruitName, fruit.fruitName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fruitName, fruitCount);
    }

    @Override
    public String toString() {
        return fruitName + "," + fruitCount;
    }
}
