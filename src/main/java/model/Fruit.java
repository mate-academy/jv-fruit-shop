package model;

import java.util.Objects;

public class Fruit {
    private Type type;

    public Fruit(Type type) {
        this.type = type;
    }

    public Type getType() {
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

    public enum Type {
        APPLE,
        BANANA
    }
}
