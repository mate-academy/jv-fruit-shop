package core.basesyntax.model;

import java.util.Objects;

public class Fruit {
    private final String fruitName;

    public Fruit(String fruit) {
        this.fruitName = fruit;
    }

    public String getFruitName() {
        return fruitName;
    }

    @Override
    public String toString() {
        return "Fruit{"
                + "fruitName='" + fruitName + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Fruit)) {
            return false;
        }
        Fruit fruit = (Fruit) o;
        return Objects.equals(getFruitName(), fruit.getFruitName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFruitName());
    }
}
