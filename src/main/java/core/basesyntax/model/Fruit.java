package core.basesyntax.model;

import java.util.Objects;

public class Fruit {
    private String name;

    public Fruit(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public boolean equals(Object fruit) {
        if (fruit == null) {
            return false;
        }

        if (fruit.getClass() != this.getClass()) {
            return false;
        }

        final Fruit current = (Fruit) fruit;

        return Objects.equals(name, current.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
