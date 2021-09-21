package core.basesyntax.model;

import java.util.Objects;

public final class Fruit {
    private final String fruitName;

    public Fruit(String fruitName) {
        this.fruitName = fruitName;
    }

    public String getFruitName() {
        return fruitName;
    }

    @Override
    public String toString() {
        return fruitName;
    }

    @Override
    public boolean equals(Object comparedFruit) {
        if (this == comparedFruit) {
            return true;
        }
        if (comparedFruit == null || getClass() != comparedFruit.getClass()) {
            return false;
        }
        Fruit fruit = (Fruit) comparedFruit;
        return Objects.equals(getFruitName(), fruit.getFruitName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFruitName());
    }
}
