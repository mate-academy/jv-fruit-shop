package core.basesyntax.model;

import java.util.Objects;

public class Fruit implements Comparable<Fruit> {
    private final String name;

    public Fruit(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Fruit fruit = (Fruit) object;
        return Objects.equals(name, fruit.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public int compareTo(Fruit anotherFruit) {
        return name.compareTo(anotherFruit.getName());
    }
}
