package core.basesyntax.model;

import java.util.Objects;

public class Fruit implements Comparable<Fruit>, Cloneable {
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
        if (fruit == null || getClass() != fruit.getClass()) {
            return false;
        }
        Fruit currentFruit = (Fruit) fruit;
        return Objects.equals(name, currentFruit.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public int compareTo(Fruit fruit) {
        return this.name.compareTo(fruit.getName());
    }

    @Override
    public Fruit clone() {
        try {
            return (Fruit) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Can't clone Fruit object", e);
        }
    }
}
