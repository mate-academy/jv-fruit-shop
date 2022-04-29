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
    public String toString() {
        return fruit;
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
        return Objects.equals(getFruit(), fruit.getFruit());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFruit());
    }
}
