package core.basesyntax.model;

import java.util.Objects;

public final class Fruit {
    String type;

    public Fruit(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
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
        return Objects.equals(type, fruit.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }
}
