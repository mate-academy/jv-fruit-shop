package core.basesyntax.model;

import java.util.Objects;

public class Fruit {
    private final String fruitName;
    private int fruitCountInStorage;

    public Fruit(String fruitName, int fruitCountInStorage) {
        this.fruitName = fruitName;
        this.fruitCountInStorage = fruitCountInStorage;
    }

    public String getFruitName() {
        return fruitName;
    }

    public int getFruitCountInStorage() {
        return fruitCountInStorage;
    }

    public void setFruitCountInStorage(int fruitCountInStorage) {
        this.fruitCountInStorage = fruitCountInStorage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fruit fruit = (Fruit) o;
        return fruitCountInStorage == fruit.fruitCountInStorage && Objects.equals(fruitName, fruit.fruitName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fruitName, fruitCountInStorage);
    }

    @Override
    public String toString() {
        return "Fruit: " + fruitName + " - " + fruitCountInStorage;
    }
}
