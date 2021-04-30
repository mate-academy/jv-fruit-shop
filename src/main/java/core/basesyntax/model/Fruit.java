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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        Fruit fruit = (Fruit) o;

        return Objects.equals(fruitName, fruit.fruitName);
    }

    @Override
    public int hashCode() {
        return fruitName != null ? fruitName.hashCode() : 0;
    }

    @Override
    public String toString() {
        return fruitName;
    }
}
