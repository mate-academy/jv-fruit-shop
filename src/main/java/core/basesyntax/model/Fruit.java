package core.basesyntax.model;

import java.util.Objects;

public final class Fruit {
    private String fruitName;

    public Fruit(String name) {
        this.fruitName = name;
    }

    public String getFruitName() {
        return fruitName;
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
        return Objects.equals(fruitName, fruit.fruitName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fruitName);
    }
}
