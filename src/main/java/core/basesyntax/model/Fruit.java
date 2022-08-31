package core.basesyntax.model;

import java.util.Objects;

public final class Fruit {
    private final String name;

    public Fruit(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
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
        return name.equals(newFruit.name);
    }
}
