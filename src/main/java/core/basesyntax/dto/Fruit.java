package core.basesyntax.dto;

import java.util.Objects;

public class Fruit {
    private final String name;

    public Fruit(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object fruit) {
        if (this == fruit) {
            return true;
        }
        if (!(fruit instanceof Fruit)) {
            return false;
        }
        Fruit newFruit = (Fruit) fruit;
        return Objects.equals(getName(), newFruit.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
