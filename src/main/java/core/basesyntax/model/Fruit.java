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

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (object == null) {
            return false;
        }

        if (object.getClass() != Fruit.class) {
            return false;
        }

        Fruit fruit = (Fruit) object;

        return Objects.equals(this.name, fruit.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Fruit{"
                + "name='"
                + name
                + '\''
                + '}';
    }
}
