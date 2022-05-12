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
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Fruit other = (Fruit) o;
        return Objects.equals(fruit, other.fruit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fruit);
    }
}
