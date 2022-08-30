package core.basesyntax.model;

import java.util.Objects;

public final class Fruit {
    private final String fruit;

    public Fruit(String fruit) {
        this.fruit = fruit;
    }

    public String getFruit() {
        return fruit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fruit);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Fruit newFruit = (Fruit) obj;
        return fruit.equals(newFruit.fruit);
    }
}
