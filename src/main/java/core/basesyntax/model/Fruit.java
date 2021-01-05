package core.basesyntax.model;

import java.util.Objects;

public class Fruit {
    private final String fruitName;

    public Fruit(String fruitName) {
        if (fruitName == null || fruitName.length() <= 2) {
            throw new RuntimeException("Fruit cannot be null or length less 3");
        }
        this.fruitName = fruitName;
    }

    public String getFruitName() {
        return fruitName;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() == obj.getClass()) {
            Fruit fruit = (Fruit) obj;
            return Objects.equals(fruitName, fruit.fruitName);
        }
        return false;

    }

    @Override
    public int hashCode() {
        return Objects.hash(fruitName);
    }
}
